import axios from 'axios'
import store from '@/store'
import Router from '@/router'
import { removeToken, getToken } from '@/utils/auth'

// axiosの設定
const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API, // url = ベースURL + リクエストURL
  withCredentials: true, // クレデンシャル情報をサーバーに送信する
  timeout: 500000 // タイムアウト時間
})


// axiosリクエストのインターセプター
service.interceptors.request.use(
  config => {
    let token = getToken();
    if (token) {
      config.headers['token'] = token; // ヘッダーにトークンを追加
    }
    return config;
  },
  error => {
    console.log(error)
    return Promise.reject(error)
  }
)


// axiosレスポンスのインターセプター
service.interceptors.response.use(
  res => {
    if (res.data.code === 0 && res.data.msg === 'NOT_LOGIN') { // ログインしていない場合、ログインページにリダイレクト
      console.log('ユーザーがログインしていません。ログインページに直接リダイレクトします。');
      removeToken();
      Router.replace('/login');
      return res;
    } else {
      return res;
    }
  },
  error => {
    console.log('err' + error)
    let { message } = error;
    if (message == "Network Error") {
      message = "バックエンドインターフェースの接続エラー";
    }
    else if (message.includes("timeout")) {
      message = "システムのインターフェースリクエストがタイムアウトしました";
    }
    else if (message.includes("Request failed with status code")) {
      message = "システムのインターフェース" + message.substr(message.length - 3) + "が異常終了しました";
    }
    return Promise.reject(error)
  }
)

export default service
