package Servlet;

import Dao.selectDao;
import Domain.Blog;
import Domain.register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println("email:" + email);
        System.out.println("password:" + password);
        //根据账号查询数据库，如果没有结果，说明用户不存在
        //如果查询到了，在对比密码，密码不对，返回错误提示
        //密码正确，返回系统主页

        if("666666".equals(email)&&"666666".equals(password))//先判断是否为管理员
        {
            System.out.println("管理员");
            //查找所有博客信息给管理员
            ArrayList<Blog> allblog=new selectDao().allBlog();
            HttpSession session=req.getSession();
            session.setAttribute("bloglist",allblog);

            System.out.println("-----------------------------");
            req.getRequestDispatcher("/administrator.jsp").forward(req, resp);
        }
        else {
            if (new selectDao().login(email,password)) {
                //密码正确，返回博客主页
                ArrayList<Blog> recommendblog=new selectDao().findeRcommend("已推荐");//查找已推荐的博客集合

                ArrayList<Blog> allbloglist=new ArrayList<>();//所有过审并被推荐的博客集合
                int blogcount=0;
                for(Blog blog:recommendblog){
                    String audit=new selectDao().findCheck(blog.getId());//从已推荐的博客中查找过审的
                    if("已审核".equals(audit)){
                        allbloglist.add(blog);
                        blogcount++;
                    }
                }
                System.out.println("blogcount:"+blogcount);//首页将展示出来的博客总数

                int page;
                if(blogcount%6==0){
                    page=blogcount/6;
                }
                else {
                    page=blogcount/6+1;
                }
                System.out.println("page:"+page);//分页数
                req.setAttribute("page", page);

                int i=1;
                ArrayList<Blog> bloglist=new ArrayList<>();//需要传过去的第一个分页集合
                for (Blog blog:allbloglist){
                    System.out.println("blogid:"+blog.getId());
                    bloglist.add(blog);
                    if(i>=6)
                        break;
                    i++;
                    System.out.println("i:"+i);
                }
                req.setAttribute("p", "1");

                HttpSession session=req.getSession();
                session.setAttribute("bloglist",bloglist);


                ArrayList<register> user=new selectDao().findRegister(email);//查用户信息
                for(register blogger:user){
                    session.setAttribute("head",blogger.getHead());//传头像路径
                }
                System.out.println("-----------------------------");
                req.setAttribute("email", email);//传用户email
                req.setAttribute("bgc", "推荐");
                req.getRequestDispatcher("/homePage.jsp").forward(req, resp);

            } else {
                //账号或密码错误
                req.setAttribute("email", email);
                req.setAttribute("error", "邮箱号或密码错误，请重新输入！");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }


    }

}


