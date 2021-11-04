package com.koreait.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    public static int insBoard(BoardVO vo) {
        Connection con = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO t_board" +
                " (title, ctnt, writer)" +
                " VALUES " +
                "(?, ?, ?)";

        try{
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getTitle());
            ps.setString(2, vo.getCtnt());
            ps.setString(3, vo.getWriter());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }
    public static List<BoardVO> selBoardList() {
        BoardVO[] list2 = new BoardVO[10];

        List<BoardVO> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from t_board";
        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return list;
    }

    public static BoardVO selBoard(BoardVO param) {
        BoardVO vo = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " select * from t_board where iboard = ? ";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            rs = ps.executeQuery();

            if(rs.next()) {
                vo = new BoardVO();
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setCtnt(rs.getString("ctnt"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return vo;
    }
    public static int updBoard(BoardVO param) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update t_board set " +
                " title = ? ," +
                " ctnt = ? ," +
                " writer = ? " +
                " where iboard = ?";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, param.getTitle());
            ps.setString(2, param.getCtnt());
            ps.setString(3, param.getWriter());
            ps.setInt(4, param.getIboard());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }

    public static int delBoard(BoardVO param) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from t_board where iboard = ?";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, param.getIboard());
            return ps.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps);
        }
        return 0;
    }


}
