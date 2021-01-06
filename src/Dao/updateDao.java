package Dao;

import java.sql.*;

public class updateDao {
//忘记密码，设置新密码
    public boolean updatepassword(String email, String password)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="update register set password='"+password+"' where email='"+email+"'";
            System .out .println(sql) ;
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out.println( count );
            if(count!=0)
            {
                return true;
            }
            else
            {
                return false ;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return  false ;
    }

    //设置头像，存入头像路径
    public boolean updatehead(String email, String head)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="update register set head='"+head+"' where email='"+email+"'";
            System .out .println(sql) ;
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out.println( count );
            if(count!=0)
            {
                return true;
            }
            else
            {
                return false ;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return  false ;
    }

    //根据邮箱修改注册信息
    public boolean updateRegister(String email,String username,String password)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="update register set username='"+username+"',password='"+password+"' where email='"+email+"'";
            System .out .println(sql) ;
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out.println( count );
            if(count!=0)
            {
                return true;
            }
            else
            {
                return false ;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return  false ;
    }

    //根据邮箱修改个人信息
    public boolean updateInformation(String email,String name ,String sex,String birthday,String job,String phone)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="update information set name='"+name+"',sex='"+sex+"',birthday='"+birthday+"',job='"+job+"',phone='"+phone+"' where email='"+email+"'";
            System .out .println(sql) ;
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out.println( count );
            if(count!=0)
            {
                return true;
            }
            else
            {
                return false ;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return  false ;
    }


    //根据id编辑修改博客
    public boolean updateblog(String id, String title,String content,String date,String label,String category,String original)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="update blog set title='"+title+"',content='"+content+"',date='"+date+"',label='"+label+"',category='"+category+"',original='"+original+"' where id='"+id+"'";
            System .out .println(sql) ;
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out.println( count );
            if(count!=0)
            {
                return true;
            }
            else
            {
                return false ;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return  false ;
    }

    //根据博客id设置推荐
    public boolean recommend(String id, String recommend)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="update blog set recommend='"+recommend+"' where id='"+id+"'";
            System .out .println(sql) ;
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out.println( count );
            if(count!=0)
            {
                return true;
            }
            else
            {
                return false ;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return  false ;
    }

    //根据博客id设置审核
    public boolean audit(String blogid, String audit)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="update audit set audit='"+audit+"' where blogid='"+blogid+"'";
            System .out .println(sql) ;
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out.println( count );
            if(count!=0)
            {
                return true;
            }
            else
            {
                return false ;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return  false ;
    }

    //根据标签id更改标签
    public boolean updatelabel(String id, String label)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="update label set label='"+label+"' where id='"+id+"'";
            System .out .println(sql) ;
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out.println( count );
            if(count!=0)
            {
                return true;
            }
            else
            {
                return false ;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return  false ;
    }

    //根据分类id更改标签
    public boolean updatecategory(String id, String category)
    {
        Statement statement=null;
        Connection connection=null;
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            String sql="update category set category='"+category+"' where id='"+id+"'";
            System .out .println(sql) ;
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement =connection.createStatement();
            int count=statement.executeUpdate( sql );
            System.out.println( count );
            if(count!=0)
            {
                return true;
            }
            else
            {
                return false ;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return  false ;
    }
}
