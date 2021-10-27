package com.koreait.server;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public static void main(String[] args) {
        StudentVO vo = new StudentVO();
        vo.setNm("가나다");
        vo.setAge(10);
        vo.setAddr("대구");

        insStudent(vo);
    }
    public static DbUtils dbUtils = DbUtils.getInstance();

    //레코드 insert 담당 메소드
    public static int insStudent(StudentVO vo) {
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO t_student2" +
                "(nm, age, addr)" +
                "VALUES" +
                "(?, ?, ?)";
        try {
            con = dbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNm());
            ps.setInt(2, vo.getAge());
            ps.setString(3, vo.getAddr());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtils.close(con, ps);
        }
        return  result;
    }
}
