package com.koreait.server;

import java.sql.*;

public class DbUtils {
    public static DbUtils dbUtils = null;
    private DbUtils() {}
    public static DbUtils getInstance() {
        if(dbUtils == null) {
            dbUtils = new DbUtils();
        }
        return dbUtils;
    }

    public Connection getCon() {
        final String URL = "jdbc:mysql://localhost:3308/test";
        final String USER_NAME="root";
        final String USER_PW = "koreait";
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER_NAME, USER_PW);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 연결 실패!");
        }
        System.out.println("DB 연결 성공!");
        return con;
    }

    public void close(Connection con, PreparedStatement ps) {
        close(con, ps, null);
    }

    public void close(Connection con, PreparedStatement ps, ResultSet rs) {

        if(rs != null) {
            try { rs.close(); }
            catch (Exception e) { e.printStackTrace(); }
        }
        if(ps != null) {
            try { ps.close(); }
            catch (Exception e) { e.printStackTrace(); }
        }
        if(con != null) {
            try { con.close(); }
            catch (Exception e) { e.printStackTrace(); }
        } // 하나가 예외가 터지면 다른 게 안 닫히기 때문에 따로 적는다
    }
}
