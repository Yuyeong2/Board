package com.koreait.basic.board;

import com.koreait.basic.Utils;
import com.koreait.basic.board.model.BoardDTO;
import com.koreait.basic.board.model.BoardVO;
import com.koreait.basic.dao.BoardDAO;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int iboard = Utils.getParameterInt(req, "iboard");
        BoardDTO param = new BoardDTO();
        param.setIboard(iboard);

        BoardVO data = BoardDAO.selBoardDetail(param);

        int loginUserPk = Utils.getLoginUserPk(req);
        if(data.getWriter() != loginUserPk) {
            BoardDAO.updBoardHitUp(param);
        }
        req.setAttribute("data", data);
        Utils.displayView(data.getTitle(), "board/detail", req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
