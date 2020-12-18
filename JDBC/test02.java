package JDBC;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 解决SQL注入问题
 */
public class test02 {
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
        PreparedStatement ps=null;  //PreparedStatement预编译的数据库操作对象
        ResultSet rs=null;


        try {
            //1：注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2:获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/class9","root","ning1026");
            //3：获取预编译的数据库操作对象
            String sql="select * from t_jdbc where loginName= ? and loginPwd= ?"; //sql语句框架   ？代表占位符不能用单引号
            ps=conn.prepareStatement(sql);

            //给占位符？传值（第一个？下标是1，第二个？下标是2 jdbc中所有下标从1开始）
            ps.setString(1,loginName);
            ps.setString(2,loginPwd);




            //4：执行SQL
            rs=ps.executeQuery();
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
            if(ps!=null){
                try {
                    ps.close();
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
