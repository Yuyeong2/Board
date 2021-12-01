package com.koreait.board2.board;

import com.koreait.board2.MyUtils;
import com.koreait.board2.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(MyUtils.isLogout(req)) {
            res.sendRedirect("/user/login");
            return;
        }

        if(req.getAttribute("data") == null) {
            int iboard = MyUtils.getParameterInt(req, "iboard");

            BoardVO vo = new BoardVO();
            vo.setIboard(iboard);

            req.setAttribute("data", BoardDAO.selDetailList(vo));
        }
        MyUtils.disForward(req, res, "board/mod");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = MyUtils.getParameterInt(req, "iboard");
        String title = req.getParameter("title");
        String ctnt = req.getParameter("ctnt");

        BoardVO param = new BoardVO();
        param.setIboard(iboard);
        param.setTitle(title);
        param.setCtnt(ctnt);
        param.setWriter(MyUtils.getLoginUserPk(req));

        int result = BoardDAO.modBoard(param);
        switch (result) {
            case 1:
                res.sendRedirect("/board/detail?iboard="+ iboard);
                break;
            case 0:
                req.setAttribute("err", "글 수정에 실패하였습니다.");
                req.setAttribute("data", param);
                doGet(req, res);
                break;
        }
    }
}
