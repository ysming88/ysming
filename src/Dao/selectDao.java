package Dao;

import Domain.*;

import java.sql.*;
import java.util.ArrayList;

public class selectDao {
//登录查找
    public boolean login(String email, String password){
        String sql="select * from register where email= '" +email+"' and password='"+password+"'";
        System.out.println( sql );
        Connection connection=null;
        ResultSet resultSet=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement=connection.createStatement();
            resultSet =statement .executeQuery( sql);
            return  resultSet.next();
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
                resultSet.close();
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
//查找邮箱号是否已被注册
    public boolean register(String email){
        String sql="select * from register where email= '" +email+"'";
        System.out.println( sql );
        Connection connection=null;
        ResultSet resultSet=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement=connection.createStatement();
            resultSet =statement .executeQuery( sql);
            return  resultSet.next();
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
                resultSet.close();
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

    //通过邮箱查找用户是否设置过个人信息
    public boolean information(String email){
        String sql="select * from information where email= '" +email+"'";
        System.out.println( sql );
        Connection connection=null;
        ResultSet resultSet=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement=connection.createStatement();
            resultSet =statement .executeQuery( sql);
            return  resultSet.next();
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
                resultSet.close();
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

//查找邮箱查找返回注册信息
    public ArrayList<register> findRegister(String email){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<register> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from register where email= '" +email+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            register user=null;
            list = new ArrayList<register>();
            while (resultSet.next()) {
                String username= resultSet.getString( "username" );
                String password= resultSet.getString( "password" );
                String head= resultSet.getString( "head" );
                //创建对象
               user = new register(username,email,password,head);
                list.add( user );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

//查找邮箱查找返回个人信息
    public ArrayList<Information> findInformation(String email){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Information> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from information where email= '" +email+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            Information information=null;
            list = new ArrayList<Information>();
            while (resultSet.next()) {
                String name= resultSet.getString( "name" );
                String sex= resultSet.getString( "sex" );
                String birthday= resultSet.getString( "birthday" );
                String job= resultSet.getString( "job" );
                String phone= resultSet.getString( "phone" );

                //创建对象
                information = new Information(name,sex,birthday,job,phone,email);
                list.add( information );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

//通过邮箱查找该用户所有博客信息
    public ArrayList<Blog> findBlog(String email){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Blog> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from blog where writer= '" +email+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            Blog myblog=null;
            list = new ArrayList<Blog>();
            while (resultSet.next()) {
                String writer= resultSet.getString( "writer" );
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String date= resultSet.getString( "date" );
                String label= resultSet.getString( "label" );
                String category= resultSet.getString( "category" );
                String original= resultSet.getString( "original" );
                String id= resultSet.getString( "id" );
                String recommend= resultSet.getString( "recommend" );
                //创建对象
                myblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
                list.add( myblog );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

//通过博客id查找博客所有信息
public ArrayList<Blog> findShowblog(String id){
    Connection connection=null;
    ResultSet resultSet=null;
    Statement statement=null;
    ArrayList<Blog> list = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        //2,注册驱动
        connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
        String sql="select * from blog where id= '" +id+"'";
        System.out.println( sql );
        statement=connection.createStatement();
        resultSet =statement .executeQuery( sql);
        Blog showblog=null;
        list = new ArrayList<Blog>();
        while (resultSet.next()) {
            String writer= resultSet.getString( "writer" );
            String title= resultSet.getString( "title" );
            String content= resultSet.getString( "content" );
            String date= resultSet.getString( "date" );
            String label= resultSet.getString( "label" );
            String category= resultSet.getString( "category" );
            String original= resultSet.getString( "original" );
            String recommend= resultSet.getString( "recommend" );
            //创建对象
            showblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
            list.add( showblog );
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
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return list;
  }

//通过博客id查找博客所有父级评论
public ArrayList<Comment> findComment(String commented,String blogid){
    Statement statement = null;
    Connection connection = null;
    ResultSet resultSet = null;
    ArrayList<Comment> list = null;
    try {
        //注册驱动
        Class.forName( "com.mysql.jdbc.Driver" );
        //获取连接
        connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
        //定义sql对象
        String sql="select * from comment where commented= '" +commented+"' and blogid= '" +blogid+"'";
        System.out.println( sql );
        //获取sql对象
        statement = connection.createStatement();
        //执行sql
        resultSet = statement.executeQuery( sql );
        //遍历结果集，封装对象，装载集合
        Comment blogcomment=null;
        list = new ArrayList<Comment>();
        while (resultSet.next()) {
            String comment= resultSet.getString( "comment" );
            String visitor= resultSet.getString( "visitor" );
            String commentid= resultSet.getString( "commentid" );
            String time= resultSet.getString( "time" );
            //创建对象
            blogcomment = new Comment(commented,comment,visitor,blogid,commentid,time);
            list.add( blogcomment );
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    return list;
   }

    //通过分类查找所有博客信息
    public ArrayList<Blog> findCategory(String category){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Blog> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from blog where category= '" +category+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            Blog myblog=null;
            list = new ArrayList<Blog>();
            while (resultSet.next()) {
                String writer= resultSet.getString( "writer" );
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String date= resultSet.getString( "date" );
                String label= resultSet.getString( "label" );
                String original= resultSet.getString( "original" );
                String id= resultSet.getString( "id" );
                String recommend= resultSet.getString( "recommend" );
                //创建对象
                myblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
                list.add( myblog );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    //通过邮箱和分类查找该邮箱用户所有博客信息
    public ArrayList<Blog> findMycategory(String writer,String category){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Blog> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from blog where writer= '" +writer+"'and category= '" +category+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            Blog myblog=null;
            list = new ArrayList<Blog>();
            while (resultSet.next()) {
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String date= resultSet.getString( "date" );
                String label= resultSet.getString( "label" );
                String original= resultSet.getString( "original" );
                String id= resultSet.getString( "id" );
                String recommend= resultSet.getString( "recommend" );
                //创建对象
                myblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
                list.add( myblog );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    //通过邮箱和是否原创查找该邮箱用户所有博客信息
    public ArrayList<Blog> findMyoriginal(String writer,String original){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Blog> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from blog where writer= '" +writer+"'and original= '" +original+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            Blog myblog=null;
            list = new ArrayList<Blog>();
            while (resultSet.next()) {
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String date= resultSet.getString( "date" );
                String label= resultSet.getString( "label" );
                String category= resultSet.getString( "category" );
                String id= resultSet.getString( "id" );
                String recommend= resultSet.getString( "recommend" );
                //创建对象
                myblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
                list.add( myblog );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    //关键字搜索博客
    public ArrayList<Blog> findKeyword(String keyword){
        ArrayList<Blog> list = null;

        Connection connection=null;
        ResultSet resultSet=null;
        PreparedStatement presta = null;
        Statement statement=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //搜索标题 内容 标签 分类
            String sql="select * from blog where title like ? or label like ?  or category like?";
            presta = connection.prepareStatement(sql);
            presta.setString(1, "%"+keyword+"%");
            presta.setString(2, "%"+keyword+"%");
            presta.setString(3, "%"+keyword+"%");
            resultSet=presta.executeQuery();

            Blog searchblog=null;
            list = new ArrayList<Blog>();

            while (resultSet.next()) {
                String writer= resultSet.getString( "writer" );
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String date= resultSet.getString( "date" );
                String label= resultSet.getString( "label" );
                String category= resultSet.getString( "category" );
                String original= resultSet.getString( "original" );
                String id= resultSet.getString( "id" );
                String recommend= resultSet.getString( "recommend" );
                //创建对象
                searchblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
                list.add( searchblog );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    //通过邮箱和时间搜索博客
    public ArrayList<Blog> findTime(String writer,String date){
        ArrayList<Blog> list = null;

        Connection connection=null;
        ResultSet resultSet=null;
        PreparedStatement presta = null;
        Statement statement=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //搜索标题 内容 标签 分类
            String sql="select * from blog where writer= '" +writer+"' and date like ?";

            presta = connection.prepareStatement(sql);
            presta.setString(1, "%"+date+"%");
            resultSet=presta.executeQuery();

            System.out.println("date---"+date);
            System.out.println("writer---"+writer);

            Blog searchblog=null;
            list = new ArrayList<Blog>();

            while (resultSet.next()) {
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String label= resultSet.getString( "label" );
                String category= resultSet.getString( "category" );
                String original= resultSet.getString( "original" );
                String id= resultSet.getString( "id" );
                String recommend= resultSet.getString( "recommend" );
                //创建对象
                searchblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
                list.add( searchblog );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    //关键字搜索博主
    public ArrayList<register> findBlogger(String keyword){
        ArrayList<register> list = null;

        Connection connection=null;
        ResultSet resultSet=null;
        PreparedStatement presta = null;
        Statement statement=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //搜索标题 内容 标签 分类
            String sql="select * from register where username like ? or email like ?";
            presta = connection.prepareStatement(sql);
            presta.setString(1, "%"+keyword+"%");
            presta.setString(2, "%"+keyword+"%");
            resultSet=presta.executeQuery();

            register searchblogger=null;
            list = new ArrayList<register>();

            while (resultSet.next()) {
                String username= resultSet.getString( "username" );
                String email= resultSet.getString( "email" );
                String password= resultSet.getString( "password" );
                String head= resultSet.getString( "head" );
                //创建对象
                searchblogger = new register(username,email,password,head);
                list.add( searchblogger );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    //通过查找所有博客信息给管理员
    public ArrayList<Blog> allBlog(){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Blog> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from blog ";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合

            Blog myblog=null;
            list = new ArrayList<Blog>();

            while (resultSet.next()) {
                String writer= resultSet.getString( "writer" );
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String date= resultSet.getString( "date" );
                String label= resultSet.getString( "label" );
                String category= resultSet.getString( "category" );
                String original= resultSet.getString( "original" );
                String id= resultSet.getString( "id" );
                String recommend= resultSet.getString( "recommend" );
                //创建对象
                myblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
                list.add( myblog );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    //查找所有注册信息给管理员
    public ArrayList<register> allUser(){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<register> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from register";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            register user=null;
            list = new ArrayList<register>();
            while (resultSet.next()) {
                String username= resultSet.getString( "username" );
                String email= resultSet.getString( "email" );
                String password= resultSet.getString( "password" );
                String head= resultSet.getString( "head" );
                //创建对象
                user = new register(username,email,password,head);
                list.add( user );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    //通过email查找该用户所有收藏博客的id
    public ArrayList<String> findcollect(String collector){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from collector where collector= '" +collector+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            list = new ArrayList<String>();
            while (resultSet.next()) {
                String blogid= resultSet.getString( "blogid" );
                //创建对象

                list.add(blogid);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    //通过博客id查找该博客所有信息
    public Blog idfindblog(String id){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        Blog myblog=null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from blog where id= '" +id+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            while (resultSet.next()) {
                String writer= resultSet.getString( "writer" );
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String date= resultSet.getString( "date" );
                String label= resultSet.getString( "label" );
                String original= resultSet.getString( "original" );
                String category= resultSet.getString( "category" );
                String recommend= resultSet.getString( "recommend" );
                //创建对象
                myblog = new Blog(writer,title,content,date,label,category,original,id,recommend);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return myblog ;
    }


    //进入首页通过推荐查找所有被推荐博客
    public ArrayList<Blog> findeRcommend(String recommend){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Blog> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from blog where recommend= '" +recommend+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            Blog myblog=null;
            list = new ArrayList<Blog>();
            while (resultSet.next()) {
                String writer= resultSet.getString( "writer" );
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String date= resultSet.getString( "date" );
                String label= resultSet.getString( "label" );
                String category= resultSet.getString( "category" );
                String original= resultSet.getString( "original" );
                String id= resultSet.getString( "id" );
                //创建对象
                myblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
                list.add( myblog );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    //查找博客id查找是否被推荐
    public String findRecommend(String id){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String recommend=null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from blog where id= '" +id+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合

            while (resultSet.next()) {
                recommend= resultSet.getString( "recommend" );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return recommend;
    }

    //通过博客id查找是否被审核
    public String findCheck(String blogid){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String audit=null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from audit where blogid= '" +blogid+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合

            while (resultSet.next()) {
                audit= resultSet.getString( "audit" );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("public String findCheck(String blogid)");
        return audit;
    }

    //查找是否收藏
    public boolean collect(String blogid, String collector){
        String sql="select * from collector where blogid= '" +blogid+"' and collector='"+collector+"'";
        System.out.println( sql );
        Connection connection=null;
        ResultSet resultSet=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement=connection.createStatement();
            resultSet =statement .executeQuery( sql);
            return  resultSet.next();
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
                resultSet.close();
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

    //查找是否点赞
    public boolean great(String blogid, String visitor){
        String sql="select * from great where blogid= '" +blogid+"' and visitor='"+visitor+"'";
        System.out.println( sql );
        Connection connection=null;
        ResultSet resultSet=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement=connection.createStatement();
            resultSet =statement .executeQuery( sql);
            return  resultSet.next();
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
                resultSet.close();
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

    //查找某篇博客点赞数
    public int greatcount(String blogid){
        Connection connection=null;
        ResultSet resultSet=null;
        Statement statement=null;
        int count=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            String sql="select count(*) from great where blogid= '" +blogid+"' ";
            System.out.println( sql );
            statement=connection.createStatement();
            resultSet =statement .executeQuery( sql);
            while(resultSet.next()) {
                count = resultSet.getInt(1);
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
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  count;
    }

    //查找总博客数
    public int blogcount(){
        Connection connection=null;
        ResultSet resultSet=null;
        Statement statement=null;
        int count=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            String sql="select count(*) from blog ";
            System.out.println( sql );
            statement=connection.createStatement();
            resultSet =statement .executeQuery( sql);
            while(resultSet.next()) {
                count = resultSet.getInt(1);
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
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  count;
    }

    //查找blog表中最新的自增id
    public String selectid(){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String blogid=null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select max(id) from blog";
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            while(resultSet.next()) {
                blogid = resultSet.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("找自增id");
        return blogid;
    }

    //通过评论id查找评论者
    public String findvisitor(String commentid){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        String visitor=null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from comment where commentid= '" +commentid+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合

            while (resultSet.next()) {
                visitor= resultSet.getString( "visitor" );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("public String findvisitor(String commentid)");
        return visitor;
    }

    //根据email查找标签
    public ArrayList<Label> label(String email){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Label> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from label where email= '" +email+"'";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            Label allLabel=null;
            list = new ArrayList<Label>();
            while (resultSet.next()) {
                String label= resultSet.getString( "label" );
                String id= resultSet.getString( "id" );
                //创建对象
                allLabel = new Label(label,id,email);
                list.add(allLabel);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
       return list;
    }

    //通过邮箱和标签搜索博客
    public ArrayList<Blog> findLabel(String writer,String label){
        ArrayList<Blog> list = null;

        Connection connection=null;
        ResultSet resultSet=null;
        PreparedStatement presta = null;
        Statement statement=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //搜索标题 内容 标签 分类
            String sql="select * from blog where writer= '" +writer+"' and label like ?";

            presta = connection.prepareStatement(sql);
            presta.setString(1, "%"+label+"%");
            resultSet=presta.executeQuery();

            System.out.println("label---"+label);
            System.out.println("writer---"+writer);

            Blog searchblog=null;
            list = new ArrayList<Blog>();

            while (resultSet.next()) {
                String title= resultSet.getString( "title" );
                String content= resultSet.getString( "content" );
                String date= resultSet.getString( "date" );
                String category= resultSet.getString( "category" );
                String original= resultSet.getString( "original" );
                String id= resultSet.getString( "id" );
                String recommend= resultSet.getString( "recommend" );
                //创建对象
                searchblog = new Blog(writer,title,content,date,label,category,original,id,recommend);
                list.add( searchblog );
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }


    //查找所有分类
    public ArrayList<Category> category(){
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<Category> list = null;
        try {
            //注册驱动
            Class.forName( "com.mysql.jdbc.Driver" );
            //获取连接
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            //定义sql对象
            String sql="select * from category";
            System.out.println( sql );
            //获取sql对象
            statement = connection.createStatement();
            //执行sql
            resultSet = statement.executeQuery( sql );
            //遍历结果集，封装对象，装载集合
            Category allCategory=null;
            list = new ArrayList<Category>();
            while (resultSet.next()) {
                String category= resultSet.getString( "category" );
                String id= resultSet.getString( "id" );
                //创建对象
                allCategory = new Category(category,id);
                list.add(allCategory);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    //查找要添加的分类专栏是否存在
    public boolean findcategory(String category){
        String sql="select * from category where category= '" +category+"'";
        System.out.println( sql );
        Connection connection=null;
        ResultSet resultSet=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement=connection.createStatement();
            resultSet =statement .executeQuery( sql);
            return  resultSet.next();
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
                resultSet.close();
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

    //根据email查找要添加的标签是否存在
    public boolean findlabel(String label,String email){
        String sql="select * from label where label= '" +label+"' and email='"+email+"'";
        System.out.println( sql );
        Connection connection=null;
        ResultSet resultSet=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2,注册驱动
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/blog","root","123456"  );
            statement=connection.createStatement();
            resultSet =statement .executeQuery( sql);
            return  resultSet.next();
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
                resultSet.close();
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
