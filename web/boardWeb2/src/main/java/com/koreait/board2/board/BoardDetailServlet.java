package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;
import com.koreait.board2.model.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = MyUtils.getParameterInt(req, "iboard");

        BoardVO vo = new BoardVO();
        vo.setIboard(iboard);
        BoardVO data = BoardDAO.selDetailList(vo);
        int prev = BoardDAO.prev(vo);
        int next = BoardDAO.next(vo);

        req.setAttribute("data", data);
        req.setAttribute("prev", prev);
        req.setAttribute("next", next);

        MyUtils.disForward(req, res, "board/detail");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
