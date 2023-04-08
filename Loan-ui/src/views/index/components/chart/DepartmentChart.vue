<template>
  <el-card
    class="flex-sub chart-item-container"
    :body-style="{padding: 0}"
    shadow="never"
  >
    <template #header>
      <div class="text-bold">
        各省贷款金额占比
      </div>
    </template>
    <div
      ref="departmentChart"
      class="chart-item"
    >
    </div>
  </el-card>

</template>

<script>
import itemChartMixins from './mixins/item-chart-mixins'
import * as echarts from 'echarts';
require('echarts/theme/macarons') // echarts theme
export default {
  name: 'DepartmentChart',
  mixins: [itemChartMixins],
  mounted() {
    this.init()
  },
  beforeDestroy() {
    this.chart.dispose(this.getInstance(this.$refs.departmentChart))
  },
  methods: {
    init() {
      const option = {
        tooltip: {
          trigger: 'item'
        },
        radar: {
          name: {
            textStyle: {
              color: '#333',
              fontSize: 10,
              backgroundColor: '#f5f5f5',
              borderRadius: 3,
              padding: [3, 5]
            }
          },
          indicator: [
            { name: '贵州', max: 50 },
            { name: '云南', max: 5 },
            { name: '四川', max: 4 },
            { name: '西藏', max: 3 }
          ],
          radius: 60,
          nameGap: 8
        },
        series: [{
          name: '贷款总金额（单位：亿元）',
          type: 'radar',
          data: [
            {
              value: [30, 3, 4, 3],
              itemStyle: {
                color: '#a8efeb'
              },
              areaStyle: {
                opacity: 0.8,
                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                  {
                    offset: 0,
                    color: 'rgba(234, 214, 238, 1)'
                  },
                  {
                    offset: 1,
                    color: 'rgba(168, 239, 235, 1)'
                  }
                ])
              }
            }
          ]
        }]
      }
      this.getInstance(this.$refs.departmentChart).setOption(option)
    },
    updateChart() {
      this.getInstance(this.$refs.departmentChart).resize()
    }
  }
}
</script>

<style lang="scss" scoped>
.chart-item-container {
  width: 100%;
  height: 215px;
  .chart-item {
    height: 180px;
  }
}
</style>
