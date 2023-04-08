<template>
  <div
    ref="orderChartWrapper"
    style="height: 100%; width: 100%"
  >
  </div>
</template>

<script>
import ItemChartMixins from './mixins/item-chart-mixins'
import * as echarts from 'echarts';
require('echarts/theme/macarons') // echarts theme
export default {
  name: 'OrderChart',
  mixins: [ItemChartMixins],
  mounted() {
    this.init()
  },
  beforeDestroy() {
    echarts.dispose(this.getInstance(this.$refs.orderChartWrapper))
  },
  methods: {
    init() {
      const option = {
        tooltip: {
          trigger: 'item',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          }
        },
        grid: {
          x: '-5%',
          y: 0,
          x2: '-5%',
          y2: 0
        },
        xAxis: {
          type: 'category',
          splitLine: { show: false }
        },
        yAxis: [
          {
            type: 'value',
            splitLine: { show: false }
          }
        ],
        series: [
          {
            data: [0, 1700, 5700],
            type: 'line',
            smooth: true,
            lineStyle: {
              width: 0
            },
            showSymbol: false,
            areaStyle: {
              opacity: 0.8,
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                {
                  offset: 0,
                  color: 'rgba(128, 255, 165)'
                },
                {
                  offset: 1,
                  color: 'rgba(1, 191, 236)'
                }
              ])
            }
          }
        ]
      }
      this.getInstance(this.$refs.orderChartWrapper).setOption(option)
    },
    updateChart() {
      this.getInstance(this.$refs.orderChartWrapper).resize()
    }
  }
}
</script>
