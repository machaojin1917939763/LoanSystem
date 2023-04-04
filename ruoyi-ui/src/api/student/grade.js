import request from '@/utils/request'

// 查询年级管理列表
export function listGrade(query) {
  return request({
    url: '/system/grade/list',
    method: 'get',
    params: query
  })
}

// 查询年级管理详细
export function getGrade(gradeId) {
  return request({
    url: '/system/grade/' + gradeId,
    method: 'get'
  })
}

// 新增年级管理
export function addGrade(data) {
  return request({
    url: '/system/grade',
    method: 'post',
    data: data
  })
}

// 修改年级管理
export function updateGrade(data) {
  return request({
    url: '/system/grade',
    method: 'put',
    data: data
  })
}

// 删除年级管理
export function delGrade(gradeId) {
  return request({
    url: '/system/grade/' + gradeId,
    method: 'delete'
  })
}
