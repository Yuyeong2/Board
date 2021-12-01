package com.koreait.board2;

import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyUtils {

    public static void disForward(HttpServletRequest req, HttpServletResponse res, String jsp) throws ServletException, IOException {
        String path = "/WEB-INF/view/"+ jsp +".jsp";
        req.getRequestDispatcher(path).forward(req, res);
    }
    public static int parseStringToInt (String str) {
        return parseStringToInt(str, 0);
    }

    public static int parseStringToInt (String str, int defVal) {
        //Wrapper 클래스
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {}
        return defVal;
    }

    public static int getParameterInt(HttpServletRequest req, String key) {
        return  parseStringToInt(req.getParameter(key));
    }
    public static int getParameterInt(HttpServletRequest req, String key, int defVal) {
        /*
        String strVal = req.getParameter(key);
        int intVal = parseStringToInt(strVal);
        return intVal;
        */
         return parseStringToInt(req.getParameter(key), defVal);
    }
    //로그인 했으면 return pk값, 아니면 return 0
    public static int getLoginUserPk(HttpServletRequest req) {
        UserVO loginUser = getLoginUser(req);
        return loginUser == null ? 0 : loginUser.getIuser();
    }

    //로그인 했으면 return true, 아니면 return false
    public static boolean isLogin(HttpServletRequest req){
        return getLoginUser(req) != null;
    }
    public static boolean isLogout(HttpServletRequest req) {
        return getLoginUser(req) == null;
    }

    //로그인 했으면 UserVO 객체 주소값, 아니면 return null
    public static UserVO getLoginUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return (UserVO) session.getAttribute("loginUser");
    }
}
