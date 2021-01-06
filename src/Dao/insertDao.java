package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertDao {
    //插入保存注册信息
    public  boolean  register(String username ,String email,String password,String head)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="insert into register values('"+username+"','"+email+"','"+password+"','"+head+"')";
            System.out.println( sql );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out .println(count) ;
            if(count>0)
            {
                System.out .println( "添加成功" );
            }
            else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
//修改保存个人信息
    public boolean information(String name ,String sex,String birthday,String job,String phone,String email){
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="insert into information values('"+name+"','"+sex+"','"+birthday+"','"+job+"','"+phone+"','"+email+"')";
            System.out.println( sql );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out .println(count) ;
            if(count>0)
            {
                System.out .println( "修改成功" );
            }
            else {
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

//保存博客信息
    public boolean blog(String writer ,String title,String content,String date,String label,String category,String original,String recommend ){
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="insert into blog values('"+writer+"','"+title+"','"+content+"','"+date+"','"+label+"','"+category+"','"+original+"','"+0+"','"+recommend+"')";
            System.out.println( sql );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out .println(count) ;
            if(count>0)
            {
                System.out .println( "添加成功" );
            }
            else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }
//保存评论信息
    public boolean comment(String commented ,String comment,String visitor,String blogid,String commentid,String time){
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="insert into comment values('"+commented+"','"+comment+"','"+visitor+"','"+blogid+"','"+commentid+"','"+time+"')";
            System.out.println( sql );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out .println(count) ;
            if(count>0)
            {
                System.out .println( "添加成功" );
            }
            else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

    //保存收藏信息
    public boolean collect(String blogger ,String blogid,String collector){
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="insert into collector values('"+blogger+"','"+blogid+"','"+collector+"')";
            System.out.println( sql );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out .println(count) ;
            if(count>0)
            {
                System.out .println( "添加成功" );
            }
            else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

    //保存点赞信息
    public boolean great(String blogid,String visitor){
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="insert into great values('"+blogid+"','"+visitor+"')";
            System.out.println( sql );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out .println("count:"+count) ;
            if(count>0)
            {
                System.out .println( "点赞成功" );
            }
            else {
                System.out.println("点赞失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

    //保存审核信息
    public boolean audit(String blogid ,String audit){
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="insert into audit values('"+blogid+"','"+audit+"')";
            System.out.println( sql );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out .println(count) ;
            if(count>0)
            {
                System.out .println( "添加成功" );
            }
            else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

    //保存添加标签信息
    public boolean addlabel(String label,String email){
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="insert into label values('"+label+"','"+0+"','"+email+"')";
            System.out.println( sql );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out .println(count) ;
            if(count>0)
            {
                System.out .println( "添加标签成功" );
            }
            else {
                System.out.println("添加标签失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

    //保存添加分类信息
    public boolean addcategory(String category){
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="insert into category values('"+category+"','"+0+"')";
            System.out.println( sql );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out .println(count) ;
            if(count>0)
            {
                System.out .println( "添加分类成功" );
            }
            else {
                System.out.println("添加分类失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  false;
    }

}
