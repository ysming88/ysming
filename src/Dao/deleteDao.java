package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteDao {
    //通过id删除博客
    public boolean delBlog(String id) {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "delete from blog where id='" + id + "'";
            System.out.println(sql);
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","123456");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count != 0) {
                return true;
            } else {
                return false;
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
        return true;
    }
    //通过email删除注册信息
    public boolean delRegister(String email) {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "delete from register where email='" + email + "'";
            System.out.println(sql);
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","123456");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count != 0) {
                return true;
            } else {
                return false;
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
        return true;
    }
    //通过email删除个人信息
    public boolean delInformation(String email) {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "delete from information where email='" + email + "'";
            System.out.println(sql);
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","123456");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count != 0) {
                return true;
            } else {
                return false;
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
        return true;
    }

    //通过收藏者和博客id删除取消收藏
    public boolean delCollect(String blogid,String collector) {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "delete from collector where blogid='" + blogid + "' and collector='" + collector + "'";
            System.out.println(sql);
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","123456");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count != 0) {
                return true;
            } else {
                return false;
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
        return true;
    }

    //通过点赞者和博客id删除取消点赞
    public boolean delGreat(String blogid,String visitor) {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "delete from great where blogid='" + blogid + "' and visitor='" + visitor + "'";
            System.out.println(sql);
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","123456");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count != 0) {
                return true;
            } else {
                return false;
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
        return true;
    }

    //删除标签
    public boolean delelabel(String label,String email) {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "delete from label where label='" + label + "'  and email='" + email + "'";
            System.out.println(sql);
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","123456");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count != 0) {
                return true;
            } else {
                return false;
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
        return true;
    }

    //删除分类专栏
    public boolean delecategory(String category) {
        Statement statement = null;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "delete from category where category='" + category + "'";
            System.out.println(sql);
            //获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","123456");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if (count != 0) {
                return true;
            } else {
                return false;
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
        return true;
    }

}
