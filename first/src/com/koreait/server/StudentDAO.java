package com.koreait.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static void main(String[] args) {
        StudentVO param = new StudentVO();
        param.setSno(5);
        StudentVO vo = selStudent(param);
        System.out.println("sno : " + vo.getSno());
        System.out.println("nm : " + vo.getNm());
        System.out.println("age : " + vo.getAge());
        System.out.println("addr : " + vo.getAddr());
    }

    public static DbUtils dbUtils = DbUtils.getInstance();

    //INSERT 담당 메소드
    public static int insStudent(StudentVO vo) {
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
            return ps.executeUpdate(); //영향을 미친 행 수
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtils.close(con, ps);
        }
        return 0;
    }
    //SELECT 담당 메소드
    public static List<StudentVO> selStudentList() {
        List<StudentVO> list = new ArrayList();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT sno, nm FROM t_student2";

        try {
            con = dbUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentVO vo = new StudentVO();
                vo.setSno(rs.getInt("sno"));
                vo.setNm(rs.getString("nm"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtils.close(con, ps,  rs);
        }
        return list;
    }

    public static StudentVO selStudent(StudentVO vo) {
        StudentVO result = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM t_student2 WHERE sno = ?";
        try {
            con = dbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1, vo.getSno());
            rs = ps.executeQuery();
            if(rs.next()) {
                result = new StudentVO();
                result.setSno(rs.getInt("sno"));
                result.setNm(rs.getString("nm"));
                result.setAge(rs.getInt("age"));
                result.setAddr(rs.getString("addr"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            dbUtils.close(con, ps, rs);
        }
        return result;
    }
    //UPDATE 담당 메소드
    public static int updStudent (StudentVO vo){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE t_student2 " +
                " SET nm = ? " +
                " , age = ? " +
                " , addr = ? " +
                " WHERE sno = ? ";

        try {
            con = dbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setString(1, vo.getNm());
            ps.setInt(2, vo.getAge());
            ps.setString(3, vo.getAddr());
            ps.setInt(4, vo.getSno());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtils.close(con, ps);
        }

        return 0;
    }
    //DELETE 담당 메소드
    public static int delStudent(StudentVO vo) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE from t_student where sno = ? " +
                "";
        try {
            con = dbUtils.getCon();
            ps = con.prepareStatement(sql);
            ps.setInt(1,vo.getSno());
            return ps.executeUpdate();
        } catch(Exception e) {

        } finally {
            dbUtils.close(con, ps);
        }
    return 0;
    }
}
