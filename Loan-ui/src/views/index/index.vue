<template>
  <div class="app-container">
    <el-row :gutter="5">
      <el-col
        v-for="(item, index) of dataList"
        :key="index"
        :xs="24"
        :sm="12"
        :md="6"
        class="item-wrapper"
      >
        <DataItem :data-model="item">
          <template
            v-if="index === 0"
            #extra="{ extra }"
          >
            <div class="margin-top">
              <div class="text-gray">
                较上学年增加：{{ extra.data }}
                <i class="el-icon-caret-top text-green"></i>
              </div>
            </div>
          </template>
          <!-- <template
            v-else-if="index === 1"
            #extra="{ extra }"
          >
            <div
              class="margin-top"
              style="position: relative"
            >
              <div class="text-gray">
                较昨日新增：{{ extra.data }}
                <i class="el-icon-caret-top text-green"></i>
              </div>
              <div class="text-gray margin-top-sm">
                较上周新增：{{ extra.data1 }}
                <i class="el-icon-caret-top text-blue"></i>
              </div>
              <div class="stack-avatar-wrapper">
                <StackAvatar />
              </div>
            </div>
          </template> -->
          <template
            v-else-if="index === 2"
            #extra="{ extra }"
          >
            <el-progress
              :text-inside="true"
              :stroke-width="20"
              :percentage="extra.data"
              status="exception"
            />
          </template>
          <template
            v-else-if="index === 3"
            #extra
          >
            <OrderChart ref="mOrderChart" />
          </template>
        </DataItem>
      </el-col>
    </el-row>
    <el-row
      :gutter="5"
      class="margin-top-xs"
    >
      <el-col
        :xs="24"
        :sm="24"
        :md="6"
      >
        <div class="flex flex-direction">
          <SalesChart ref="salesChart" />
          <StudentChart
            ref="studentChart"
            class="margin-top-xs"
          />
        </div>
      </el-col>
      <el-col
        :xs="24"
        :sm="24"
        :md="12"
        class="map-margin-tb"
      >
        <div>
          <SchoolChart ref="schoolChart" />
        </div>
      </el-col>
      <el-col
        :xs="24"
        :sm="24"
        :md="6"
      >
        <div class="flex flex-direction">
          <EnrollmentChannelsChart ref="enrollmentChannelsChart" />
          <DepartmentChart
            ref="departmentChart"
            class="margin-top-xs"
          />
        </div>
      </el-col>
    </el-row>
    <!-- <el-row
      :gutter="5"
      class="margin-top-xs"
    >
      <el-col :span="24">
        <FullYearSalesChart ref="fullYearSalesChart" />
      </el-col>
    </el-row> -->
  </div>
</template>

<script>
import DataItem from './components/DataItem'
import OrderChart from './components/chart/OrderChart'
import SalesChart from './components/chart/SalesChart'
import StudentChart from './components/chart/StudentChart'
import EnrollmentChannelsChart from './components/chart/EnrollmentChannelsChart'
import DepartmentChart from './components/chart/DepartmentChart'
import SchoolChart from './components/chart/SchoolChart'
// import FullYearSalesChart from './components/chart/FullYearSalesChart'
// import StackAvatar from '@/components/common/StackAvatar'
import ResizeMixin from '@/mixins/ResizeMixin'
import { mapState } from 'vuex'
import layoutStore from "@/store/modules/user";
export default {
  name: 'StudentMy',
  components: {
    DataItem,
    OrderChart,
    SchoolChart,
    SalesChart,
    StudentChart,
    EnrollmentChannelsChart,
    DepartmentChart
    // FullYearSalesChart
    // StackAvatar
  },
  mixins: [ResizeMixin],
  data() {
    return {
      dataList: [
        {
          title: '当前学年贷款金额',
          data: '12000元',
          bottomTitle: '去年贷款金额',
          totalSum: '8000元',
          extra: {
            data: 6000
          }
        },
        {
          title: '当前学年需缴学费金额',
          data: '学杂费住宿费共6300元',
          bottomTitle: '未缴费用',
          totalSum: '6300'
          // extra: {
          //   data: 700,
          //   data1: 968
          // }
        },
        {
          title: '本学年贷款详情',
          data: '总贷款12000元',
          bottomTitle: '剩余金额',
          totalSum: '6700',
          extra: {
            data: 54
          }
        },
        {
          title: '学年贷款余量走势',
          data: '本学年6700元',
          bottomTitle: '累计贷款金额',
          totalSum: '38000',
          extra: {
            data: 80
          }
        }
      ]
    }
  },
  computed: {
    collapse() {
      return layoutStore.state.isCollapse
    },
    ...mapState({
      layoutStore: state => state.layoutStore
    })
  },
  watch: {
    collapse(newVal) {
      setTimeout(() => {
        this.onResize()
      }, 500)
    }
  },
  methods: {
    onResize(width) {
      this.$refs.mOrderChart[0].updateChart()
      this.$refs.salesChart.updateChart()
      this.$refs.departmentChart.updateChart()
      this.$refs.enrollmentChannelsChart.updateChart()
      this.$refs.schoolChart.updateChart()
      this.$refs.studentChart.updateChart()
      // this.$refs.fullYearSalesChart.updateChart()
    }
  }
}
</script>

<style lang="scss" scoped> /* General Styles */
.app-container {
  font-family: Arial, sans-serif;
  padding: 15px;
}

.text-gray {
  color: #666;
}

.margin-top {
  margin-top: 10px;
}

.margin-top-xs {
  margin-top: 5px;
}

.margin-top-sm {
  margin-top: 15px;
}

.flex {
  display: flex;
}

.flex-direction {
  flex-direction: column;
}

.map-margin-tb {
  margin-top: 10px;
  margin-bottom: 10px;
}

/* Colors */
.text-green {
  color: #32CD32;
}

.text-blue {
  color: #1E90FF;
}

/* Grid */
.item-wrapper {
  padding: 15px;
  background-color: #fff;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  margin-bottom: 15px;
}

.el-row {
  margin-right: -5px;
  margin-left: -5px;
}

.el-col {
  padding-right: 5px;
  padding-left: 5px;
}
.el-progress__text {
  font-size: 20px;
  color: #333;
}

.el-progress-bar__inner {
  background-color: #0077ff;
}

.el-progress--exception .el-progress-bar__inner {
  background-color: #ff4949;
}

.el-progress__text .el-icon {
  font-size: 16px;
  margin-left: 5px;
  vertical-align: middle;
  color: #07c160;
  animation: icon-bounce 1s infinite;
}

@keyframes icon-bounce {
  0% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-10px);
  }
  100% {
    transform: translateY(0);
  }
}

.order-chart-container {
  height: 200px;
}

.sales-chart-container {
  width: calc(50% - 10px);
  height: 200px;
}

.student-chart-container {
  width: calc(50% - 10px);
  height: 200px;
}

.school-chart-container {
  height: 400px;
}

.enrollment-channels-chart-container {
  width: calc(50% - 10px);
  height: 200px;
}

.department-chart-container {
  width: calc(50% - 10px);
  height: 200px;
}

.chart-title {
  font-size: 18px;
  font-weight: 500;
  margin-bottom: 10px;
}

/* Charts */
.sales-chart,
.student-chart,
.school-chart,
.enrollment-channels-chart,
.department-chart {
  width: 100%;
  height: 300px;
}</style>
