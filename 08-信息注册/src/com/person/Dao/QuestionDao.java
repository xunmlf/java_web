package com.person.Dao;

import com.person.entity.Question;
import com.person.util.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XUN~MLF
 */
public class QuestionDao {
    JDBC util = new JDBC();
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public int add(Question question){
        int result=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            String sql=" insert into question(title, optionA, optionB, optionC, optionD, answer) values(?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            result=ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.Close(conn,ps,null);
        }


        return result;
    }

    public List<Question> findAll(){
        List<Question> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            String sql= "select * from question";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int questionId= rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Question question=new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                list.add(question);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.Close(conn,ps,rs);
        }
        return list;
    }

    public int deleteQuestion(int questionId) {
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2:获取连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            //3：获取操作对象
            String sql = "delete from question where questionId=?";

            ps = conn.prepareStatement(sql);

            ps.setInt(1, questionId);

            result = ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.Close(conn, ps, null);
        }
        return result;
    }

    public Question findById(int questionId){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Question question=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2:获取连接
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            //3：获取操作对象
            String sql="select * from question where questionId=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,questionId);
            rs=ps.executeQuery();
            while (rs.next()){
                questionId= rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                question=new Question(questionId,title,optionA,optionB,optionC,optionD,answer);

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.Close(conn,ps,rs);
        }
        return question;
    }

    public int update(Question question){
        int result=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            String sql="update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,question.getTitle());
            ps.setString(2,question.getOptionA());
            ps.setString(3,question.getOptionB());
            ps.setString(4,question.getOptionC());
            ps.setString(5,question.getOptionD());
            ps.setString(6,question.getAnswer());
            ps.setInt(7,question.getQuestionId());
            result=ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.Close(conn,ps,null);
        }
        return  result;

    }

    public List findRand(){

        List<Question> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9?serverTimezone=GMT", "root", "123456");
            String sql= "select * from question order by rand() limit 0,4";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int questionId= rs.getInt("questionId");
                String title = rs.getString("title");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String answer = rs.getString("answer");
                Question question=new Question(questionId,title,optionA,optionB,optionC,optionD,answer);
                list.add(question);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.Close(conn,ps,rs);
        }
        return list;
    }



}
