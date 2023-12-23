import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '@/layout'

// 固定路由
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true // 隠しフラグ
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true // 隠しフラグ
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: 'ホームページ', icon: 'dashboard' } // メタデータ
    }]
  },

  {
    path: '/example',
    component: Layout,
    redirect: '/example',
    name: 'Example',
    meta: { title: 'クラスと生徒の管理', icon: 'el-icon-s-help' }, // メタデータ
    children: [
      {
        path: 'classes',
        name: 'Classes',
        component: () => import('@/views/classes'),
        meta: { title: 'クラスの管理', icon: 'el-icon-menu' } // メタデータ
      },
      {
        path: 'student',
        name: 'Student',
        component: () => import('@/views/student'),
        meta: { title: '生徒の管理', icon: 'el-icon-user-solid' } // メタデータ
      }
    ]
  },
  {
    path: '/system',
    component: Layout,
    redirect: '/system',
    name: 'System',
    meta: { title: 'システム情報の管理', icon: 'el-icon-s-tools' }, // メタデータ
    children: [
      {
        path: 'dept',
        name: 'Dept',
        component: () => import('@/views/dept'),
        meta: { title: '部門の管理', icon: 'el-icon-menu' } // メタデータ
      },
      {
        path: 'emp',
        name: 'Emp',
        component: () => import('@/views/emp'),
        meta: { title: '従業員の管理', icon: 'el-icon-user-solid' } // メタデータ
      }
    ]
  },


  {
    path: '/report',
    component: Layout,
    redirect: '/report',
    name: 'Report',
    meta: { title: 'データ統計の管理', icon: 'el-icon-s-tools' }, // メタデータ
    children: [
      {
        path: 'emp-report',
        name: 'emp-report',
        component: () => import('@/views/emp-report'),
        meta: { title: '従業員情報の統計', icon: 'el-icon-s-data' } // メタデータ
      },
      {
        path: 'student-report',
        name: 'student-report',
        component: () => import('@/views/student-report'),
        meta: { title: '生徒情報の統計', icon: 'el-icon-s-data' } // メタデータ
      }
    ]
  },


  // 404ページは最後に配置する必要があります!!!
  { path: '*', redirect: '/404', hidden: true } // 隠しフラグ
]

const createRouter = () => new Router({
  // mode: 'history', // サービスのサポートが必要です
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // ルーターをリセット
}

export default router
