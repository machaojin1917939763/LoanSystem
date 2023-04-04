import request from '@/utils/request'

// 查询专业管理列表
export function listMajor(query) {
  return request({
    url: '/system/major/list',
    method: 'get',
    params: query
  })
}

// 查询专业管理详细
export function getMajor(majorId) {
  return request({
    url: '/system/major/' + majorId,
    method: 'get'
  })
}

// 新增专业管理
export function addMajor(data) {
  return request({
    url: '/system/major',
    method: 'post',
    data: data
  })
}

// 修改专业管理
export function updateMajor(data) {
  return request({
    url: '/system/major',
    method: 'put',
    data: data
  })
}

// 删除专业管理
export function delMajor(majorId) {
  return request({
    url: '/system/major/' + majorId,
    method: 'delete'
  })
}
