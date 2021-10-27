package com.koreait.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*1. /world?addr=hahaha&phone=01030249887&gender=w*/

@WebServlet("/world")   //url 쿼리스트링 -> get방식
public class WorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String addr = req.getParameter("addr");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");

        System.out.println("addr : " + addr);
        System.out.println("phone : " + phone);
        System.out.println("gender : " + gender);


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String data = Utils.getJson(req);

        Gson gson = new Gson();
        TestVO vo = gson.fromJson(data, TestVO.class);

        System.out.println("name : " + vo.getName());
        System.out.println("age : " + vo.getAge());

    }
}
