import request from '@/utils/request'

// 查询合同信息管理列表
export function listContract(query) {
  return request({
    url: '/system/contract/list',
    method: 'get',
    params: query
  })
}

// 查询合同信息管理详细
export function getContract(id) {
  return request({
    url: '/system/contract/' + id,
    method: 'get'
  })
}

// 新增合同信息管理
export function addContract(data) {
  return request({
    url: '/system/contract',
    method: 'post',
    data: data
  })
}

export function addContractPact(data) {
  return request({
    url: '/system/contract/pact',
    method: 'post',
    data: data
  })
}

// 修改合同信息管理
export function updateContract(data) {
  return request({
    url: '/system/contract',
    method: 'put',
    data: data
  })
}

// 删除合同信息管理
export function delContract(id) {
  return request({
    url: '/system/contract/' + id,
    method: 'delete'
  })
}
