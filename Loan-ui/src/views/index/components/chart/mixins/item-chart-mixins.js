import * as echarts from 'echarts';
export default {
  methods: {
    getInstance(ele) {
      let instance = echarts.getInstanceByDom(ele)
      if (!instance) {
        instance = echarts.init(ele)
      }
      return instance
    }
  }
}
