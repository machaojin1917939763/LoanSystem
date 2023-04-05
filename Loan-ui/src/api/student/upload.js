import request from '@/utils/request'

// 查询学院管理列表
export function fieldcollegeFun(query) {
    return request({
      url: '/system/college/list',
      method: 'get',
      params: query
    })
  }

// 查询专业管理列表
export function fieldmajorFun(query) {
    return request({
      url: '/system/major/list',
      method: 'get',
      params: query
    })
  }
 
// 查询年级管理列表
export function fieldgradeFun(query) {
    return request({
      url: '/system/grade/list',
      method: 'get',
      params: query
    })
  }
// 查询班级管理列表
export function fieldclassFun(query) {
    return request({
      url: '/system/class/list',
      method: 'get',
      params: query
    })
  }