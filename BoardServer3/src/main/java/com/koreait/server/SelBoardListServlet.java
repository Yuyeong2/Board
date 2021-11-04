package com.koreait.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class SelBoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<BoardVO> list = BoardDAO.selBoardList();
        Gson gson = new Gson();
        String json = gson.toJson(list);

        res.setContentType("text/plain;charset=UTF-8");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.print(json);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
