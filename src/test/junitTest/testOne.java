package test.junitTest;

import Demo.RandomName;
import Demo.RandomNum;
import org.junit.Test;

import java.sql.*;

//测试博客的增删查改
public class testOne {
    @Test
    public void testInsert() throws Exception {//测试添加博客
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
        System.out.println("连接数据库成功");
        Statement stmt=conn.createStatement();

        String writer="1319161135@qq.com";
        String title="尺取";
        String content="**尺取：**\n" +
                "一般用于在给定的一组数据中找到不大于某个上限的“ 最优连续子序列 ”。\n" +
                "\n" +
                "**尺取思想：**\n" +
                "1，可以先定义左右端点为零；\n" +
                "2，移动右端点到满足条件，获取区间内所需信息；\n" +
                "3，再移动左端点到一定情况；\n" +
                "4，如果右端点没到数据末则返回步骤2。\n" +
                "\n" +
                "**举例：**\n" +
                "\n" +
                "输入两个整数n,m。n为数据个数，m指连续子序列的长度。\n" +
                "求连续m个数的最大值。\n" +
                "\n" +
                "**代码实现：**\n" +
                "\n" +
                "```c\n" +
                "\tint n ,m，x[500000];\n" +
                "\twhile(scanf(\"%d%d\",&n,&m)!=EOF)\n" +
                "    {\n" +
                "        int i;\n" +
                "        for(i=0;i<n;i++)\n" +
                "        scanf(\"%d\",&x[i]);\n" +
                "        int head=0,end=0,k=0;\n" +
                "        int  sum=0,max=0;\n" +
                "        while(head<n)\n" +
                "        {\n" +
                "            while(k-head<m)\n" +
                "            {\n" +
                "                sum+=x[end];\n" +
                "                end++;\n" +
                "                k++;\n" +
                "            }\n" +
                "            if(max<sum)\n" +
                "            {\n" +
                "                max=sum;\n" +
                "            }\n" +
                "            sum-=x[head];\n" +
                "            head++;\n" +
                "        }\n" +
                "        printf(\"%d\\n\",max);\n" +
                "\n" +
                "```\n";
        String date="2020-10-07   23:30";
        String label="Java";
        String category="Java";
        String original="原创";
        String recommend="已推荐";
        String sql="insert into blog values('"+writer+"','"+title+"','"+content+"','"+date+"','"+label+"','"+category+"','"+original+"','"+0+"','"+recommend+"')";

        int count=stmt.executeUpdate( sql );
        if(count>0)
        {
            System.out .println( "添加成功" );
        }
        else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void test10000() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
        System.out.println("连接数据库成功");
        Statement stmt=conn.createStatement();

        for(int i=0;i<10000;i++){
            String name=new RandomName().getRandomName();
            String  RandomNum=new RandomNum().getRandomNumCode(10);//生成4位数验证码给x
            String email=RandomNum+"@qq.com";
            String password=new RandomNum().getRandomNumCode(8);
            String head="pic/灰太狼.jpg";

            String sql="insert into register values('"+name+"','"+email+"','"+password+"','"+head+"')";
            int count=stmt.executeUpdate( sql );
        }

    }


//    @Test
//    public void testDetele(String id) throws Exception{//测试通过博客id删除博客
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
//        System.out.println("连接数据库成功");
//        Statement stmt=conn.createStatement();
//
//        String sql = "delete from blog where id='" + id + "'";
//        int count = stmt.executeUpdate(sql);
//        System.out.println(count);
//        if (count > 0) {
//            System.out .println( "删除成功" );
//        } else {
//            System.out.println("删除失败");
//        }
//    }
//
//    @Test
//    public void testSelect(String id) throws Exception{//测试通过博客id查找博客所有内容
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
//        System.out.println("连接数据库成功");
//        Statement stmt=conn.createStatement();
//
//        String sql="select * from blog where id= '" +id+"'";
//        ResultSet resultSet=stmt.executeQuery( sql );
//        while (resultSet.next()) {
//            System.out.println("writer:"+resultSet.getString("writer"));
//            System.out.println("title:"+resultSet.getString("title"));
//            System.out.println("content:"+resultSet.getString("content"));
//            System.out.println("date:"+resultSet.getString("date"));
//            System.out.println("label:"+resultSet.getString("label"));
//            System.out.println("category:"+resultSet.getString("category"));
//        }
//    }
//
//    @Test
//    public void testUpdate(String id) throws Exception{//通过博客id修改博客属性
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
//        System.out.println("连接数据库成功");
//        Statement stmt=conn.createStatement();
//
//        String writer="1319161135@qq.com";
//        String title="尺取";
//        String content="无";//修改内容
//        String date="2020-10-07   23:30";
//        String label="Java";
//        String category="Java";
//        String original="原创";
//        String recommend="已推荐";
//        String sql="update blog set title='"+title+"',content='"+content+"',date='"+date+"',label='"+label+"',category='"+category+"',original='"+original+"' where id='"+id+"'";
//
//        int count=stmt.executeUpdate( sql );
//        if (count > 0) {
//            System.out .println( "修改成功" );
//        } else {
//            System.out.println("修改失败");
//        }
//    }

}
