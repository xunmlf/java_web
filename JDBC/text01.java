package JDBC;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *当前程序存在问题
 * 用户名：fdsa
 * 密码：fdsa'or'1'='1
 * 登录成功
 *
 * 这种现象称为sql注入（安全隐患）
 *
 */
public class text01 {
    public static void main(String[] args) {
        //初始化一个界面
       Map<String,String> userLoginInfo=initUI();

       //验证用户登录信息
        boolean loginSuccess=login(userLoginInfo);

        //输出结果
        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }


    /**
     * 用户登录
     * @param userLoginInfo  用户登录信息
     * @return  false表示失败  true表示成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {

        boolean loginSuccess=false;
        String loginName=userLoginInfo.get("loginName");
        String loginPwd=userLoginInfo.get("loginPwd");

        //jdbc代码
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;


        try {
            //1：注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2:获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026");
            //3：获取操作对象
            stmt=conn.createStatement();
            //4：执行SQL
            String sql="select * from t_jdbc where loginName='"+loginName+"' and loginPwd='"+loginPwd+"'";

            rs=stmt.executeQuery(sql);
            //5：处理查询结果集

            if (rs.next()){
                //登录成功
                loginSuccess=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6：释放资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return loginSuccess;
    }


    /**
     * 初始化用户界面
     * @return  用户输入的用户名和密码等登录信息
     */
    private static Map<String, String> initUI() {

        Scanner s=new Scanner(System.in);
        System.out.print("用户名：");
        String loginName=s.nextLine();

        System.out.print("密码：");
        String loginPwd=s.nextLine();

        Map<String ,String> userLoginInfo=new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);

        return  userLoginInfo;
    }
}
