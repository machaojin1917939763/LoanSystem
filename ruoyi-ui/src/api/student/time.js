import request from '@/utils/request'

// 查询放款时间列表
export function listTime(query) {
  return request({
    url: '/system/time/list',
    method: 'get',
    params: query
  })
}

// 查询放款时间详细
export function getTime(timeId) {
  return request({
    url: '/system/time/' + timeId,
    method: 'get'
  })
}

// 新增放款时间
export function addTime(data) {
  return request({
    url: '/system/time',
    method: 'post',
    data: data
  })
}

// 修改放款时间
export function updateTime(data) {
  return request({
    url: '/system/time',
    method: 'put',
    data: data
  })
}

// 删除放款时间
export function delTime(timeId) {
  return request({
    url: '/system/time/' + timeId,
    method: 'delete'
  })
}
