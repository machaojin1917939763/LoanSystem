<template>
  <el-card
    class="flex-sub chart-item-container"
    :body-style="{padding: 0}"
    shadow="never"
  >
    <template #header>
      <div class="text-bold">
        国开行近四年出纳对比图（单位：亿元）
      </div>
    </template>
    <div
      ref="studentChart"
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
  name: 'StudentChart',
  mixins: [itemChartMixins],
  mounted() {
    this.init()
  },
  beforeDestroy() {
    echarts.dispose(this.getInstance(this.$refs.studentChart))
  },
  methods: {
    init() {
      const option = {
        grid: {
          left: '2%',
          right: '5%',
          top: '5%',
          bottom: '3%',
          containLabel: true
        },
        tooltip: {
          trigger: 'axis'
        },
        yAxis: {
          type: 'category',
          data: ['2019', '2020', '2021', '2022', '2023'],
          boundaryGap: 0,
          axisTick: {
            show: false
          }
        },
        xAxis: {
          type: 'value',
          boundaryGap: 0
        },
        series: [
          {
            data: [480, 289, 711, 618, 393, 571, 470],
            type: 'bar',
            smooth: true,
            showSymbol: false,
            barWidth: 'auto',
            itemStyle: {
              borderRadius: [0, 15, 15, 0],
              opacity: 0.8,
              color: new echarts.graphic.LinearGradient(1, 0, 0, 1, [
                {
                  offset: 0,
                  color: 'rgba(12, 124, 182)'
                },
                {
                  offset: 1,
                  color: 'rgba(244, 187, 236)'
                }
              ])
            }
          }
        ]
      }
      this.getInstance(this.$refs.studentChart).setOption(option)
    },
    updateChart() {
      this.getInstance(this.$refs.studentChart).resize()
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
