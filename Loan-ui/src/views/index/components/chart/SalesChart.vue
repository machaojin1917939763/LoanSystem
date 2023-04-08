<template>
  <el-card
    class="flex-sub chart-item-container"
    :body-style="{padding: 0}"
    shadow="never"
  >
    <template #header>
      <div class="text-bold">
        在校期间贷款走势
      </div>
    </template>
    <div
      ref="salesChart"
      class="chart-item"
    >
    </div>
  </el-card>

</template>

<script>
import ItemChartMixins from './mixins/item-chart-mixins'
import * as echarts from 'echarts';
require('echarts/theme/macarons') // echarts theme
export default {
  name: 'SalesChart',
  mixins: [ItemChartMixins],
  mounted() {
    this.init()
  },
  beforeDestroy() {
    echarts.dispose(this.getInstance(this.$refs.salesChart))
  },
  methods: {
    init() {
      if (!this.$refs.salesChart) {
        return
      }
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
        xAxis: {
          type: 'category',
          data: ['2020~2021', '2021~2022', '2022~2023'],
          boundaryGap: false,
          splitLine: { show: false }
        },
        yAxis: {
          type: 'value',
          boundaryGap: false,
          splitLine: { show: false }
        },
        series: [
          {
            data: [6000, 8000, 12000],
            type: 'line',
            smooth: true,
            showSymbol: false,
            lineStyle: {
              width: 0
            },
            areaStyle: {
              opacity: 0.8,
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                {
                  offset: 0,
                  color: 'rgba(55, 162, 255)'
                },
                {
                  offset: 1,
                  color: 'rgba(116, 21, 219)'
                }
              ])
            }
          }
        ]
      }
      this.getInstance(this.$refs.salesChart).setOption(option)
    },
    updateChart() {
      this.getInstance(this.$refs.salesChart).resize()
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
