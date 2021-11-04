package com.koreait.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ins")
public class InsBoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String json = Utils.getJson(req);
        System.out.println("json :" + json);

        Gson gson = new Gson();
        BoardVO param = gson.fromJson(json, BoardVO.class);
        System.out.println(param.getTitle());
        System.out.println(param.getCtnt());
        System.out.println(param.getWriter());

        int result = BoardDAO.insBoard(param);
        System.out.println("result : " + result);
    }
}
