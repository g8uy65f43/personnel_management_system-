package com.tian.personnel_management_system.interceptor;


import com.alibaba.fastjson2.JSONObject;
import com.tian.personnel_management_system.pojo.Result;
import com.tian.personnel_management_system.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override //ログイン状態　true　通過, false　ログイン画面に
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //1.リクエストしたURLをGET
        String url = req.getRequestURL().toString();
        log.info("請求されたurl: {}",url);

        //2.もしURLはログイン画面へなら、通過させます。
        if(url.contains("login")){
            log.info("ログインへ, 通過...");
            return true;
        }

        //3.リクエストHandのTokenを検索（token）。
        String jwt = req.getHeader("token");

        //4.Tokenが存在するかどうかを判断する
        if(!StringUtils.hasLength(jwt)){
            log.info("tokenがないため、ログイン画面へ");
            Result error = Result.error("Not＿Login");
            // Object--json -------->fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        //5.解析token，失敗したらreturn　false。
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {//jwt解析失败
            e.printStackTrace();
            log.info("Token解析失敗, エラーメッセージをリスポンス");
            Result error = Result.error("NOT_LOGIN");
            // Object--json -------->fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return false;
        }

        //6.通過。
        log.info("Token検証完了, 通過");
        return true;
    }

    @Override //目標実行後作動
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle ...");
        return;
    }

    @Override //画面がRender後作動
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...");
    }
}
