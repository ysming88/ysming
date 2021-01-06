package Servlet;

import Dao.deleteDao;
import Dao.insertDao;
import Dao.selectDao;
import Domain.Blog;
import Domain.Comment;
import Domain.register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/collectServlet")
public class CollectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("CollectServlet-get" );

        String blogger = req.getParameter("blogger");
        String blogid = req.getParameter("blogid");
        String collector = req.getParameter("visitor");
        String collect = req.getParameter("collect");
        System.out.println("blogger:" + blogger);
        System.out.println("blogid:" +  blogid);
        System.out.println("collector:" + collector);
        System.out.println("collect:" +  collect);

        if("收藏".equals(collect)){
            new insertDao().collect(blogger,blogid,collector);//存入收藏
            req.setAttribute("collect", "已收藏");
        }
        else {
            new deleteDao().delCollect(blogid,collector);//取消收藏
            req.setAttribute("collect", "收藏");
        }

        ArrayList<Blog> showblog=new selectDao().findShowblog(blogid);//查找id查找博客所有信息
        for(Blog Showblog:showblog)//将博客的相关信息传过去
        {
            req.setAttribute("title",Showblog.getTitle());
            req.setAttribute("category",Showblog.getCategory());
            req.setAttribute("label",Showblog.getLabel());
            req.setAttribute("date",Showblog.getDate());
            req.setAttribute("content",Showblog.getContent());
            req.setAttribute("original",Showblog.getOriginal());
            System.out.println("title:"+Showblog.getTitle());


            req.setAttribute("blogid",Showblog.getId());
            req.setAttribute("blogger",Showblog.getWriter());
            ArrayList<register> Writer=new selectDao().findRegister(Showblog.getWriter());
            for (register writer:Writer)
            {
                req.setAttribute("writerhead",writer.getHead());
                req.setAttribute("writername",writer.getUsername());
            }
            req.setAttribute("visitor",collector);
        }

        String great = req.getParameter("great");
        req.setAttribute("great", great);
        int count=new selectDao().greatcount(blogid);
        System.out.println("count:"+count);
        req.setAttribute("count",count);

        req.getRequestDispatcher("/showblog.jsp").forward(req, resp);

    }

}
