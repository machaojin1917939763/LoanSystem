package com.loan.common.core.domain.model;

/**
 * 用户注册对象
 * 
 * @author loan
 */
public class RegisterBody extends LoginBody
{
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RegisterBody{" +
                "role='" + role + '\'' +
                '}';
    }
}
