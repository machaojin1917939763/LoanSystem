package com.loan.framework.web.service;

import com.loan.common.core.domain.entity.SysRole;
import com.loan.system.domain.SysUserRole;
import com.loan.system.mapper.SysUserRoleMapper;
import com.loan.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.loan.common.constant.CacheConstants;
import com.loan.common.constant.Constants;
import com.loan.common.constant.UserConstants;
import com.loan.common.core.domain.entity.SysUser;
import com.loan.common.core.domain.model.RegisterBody;
import com.loan.common.core.redis.RedisCache;
import com.loan.common.exception.user.CaptchaException;
import com.loan.common.exception.user.CaptchaExpireException;
import com.loan.common.utils.MessageUtils;
import com.loan.common.utils.SecurityUtils;
import com.loan.common.utils.StringUtils;
import com.loan.framework.manager.AsyncManager;
import com.loan.framework.manager.factory.AsyncFactory;
import com.loan.system.service.ISysConfigService;
import com.loan.system.service.ISysUserService;

import java.util.List;

/**
 * 注册校验方法
 * 
 * @author loan
 */
@Component
public class SysRegisterService
{
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private SysUserRoleMapper userRoleService;

    @Autowired
    private ISysRoleService roleService;

    /**
     * 注册
     */
    public String register(RegisterBody registerBody)
    {
        String msg = "", username = registerBody.getUsername(), password = registerBody.getPassword();
        SysUser sysUser = new SysUser();
        sysUser.setUserName(username);

        // 验证码开关
        boolean captchaEnabled = configService.selectCaptchaEnabled();
        if (captchaEnabled)
        {
            validateCaptcha(username, registerBody.getCode(), registerBody.getUuid());
        }

        if (StringUtils.isEmpty(username))
        {
            msg = "用户名不能为空";
        }
        else if (StringUtils.isEmpty(password))
        {
            msg = "用户密码不能为空";
        }
        else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            msg = "账户长度必须在2到20个字符之间";
        }
        else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            msg = "密码长度必须在5到20个字符之间";
        }
        else if (!userService.checkUserNameUnique(sysUser))
        {
            msg = "保存用户'" + username + "'失败，注册账号已存在";
        }
        else
        {
            sysUser.setNickName(username);
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            //userRoleService---插入学生和角色的关系
            //roleService---查询学生角色
            List<SysRole> sysRoles = roleService.selectRoleList(new SysRole());
            //查询到学生角色的id
            long studentRoleId = 0;
            for (SysRole sysRole : sysRoles) {
                if (sysRole.getRoleName().equals("学生")){
                    studentRoleId = sysRole.getRoleId();
                    break;
                }
            }
            boolean regFlag = userService.registerUser(sysUser);
            if (!regFlag)
            {
                msg = "注册失败,请联系系统管理人员";
            }
            else
            {
                //查询该学生的信息，添加到角色用户表中
                if (studentRoleId != 0){
                    SysUser user = userService.selectUserByUserName(sysUser.getUserName());
                    SysUserRole userRole = new SysUserRole();
                    userRole.setRoleId(studentRoleId);
                    userRole.setUserId(user.getUserId());
                    userRoleService.insertUserRole(userRole);
                }
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.REGISTER, MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }

    /**
     * 校验验证码
     * 
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            throw new CaptchaException();
        }
    }
}
