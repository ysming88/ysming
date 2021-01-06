package Servlet;

import Dao.deleteDao;
import Dao.insertDao;
import Dao.selectDao;
import Domain.Blog;
import Domain.register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/greatServlet")
public class GreatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("greatServlet-get" );

        String blogid = req.getParameter("blogid");
        String visitor = req.getParameter("visitor");
        String great = req.getParameter("great");
        System.out.println("blogid:" +  blogid);
        System.out.println("visitor:" + visitor);
        System.out.println(" great:" +  great);

        int count;
        if("点赞".equals(great)){
            new insertDao().great(blogid,visitor);//存入点赞
            req.setAttribute("great","已点赞");

            count=new selectDao().greatcount(blogid);
            System.out.println("count:"+count);
            req.setAttribute("count",count);
        }
        else {
            new deleteDao().delGreat(blogid,visitor);//取消点赞
            req.setAttribute("great","点赞");

            count=new selectDao().greatcount(blogid);
            System.out.println("count:"+count);
            req.setAttribute("count",count);
        }


        ArrayList<Blog> showblog=new selectDao().findShowblog(blogid);//查找id查找博客所有信息
        for(Blog Showblog:showblog)//将博客的相关信息传过去
        {
            req.setAttribute("title",Showblog.getTitle());
            req.setAttribute("category",Showblog.getCategory());
            req.setAttribute("label",Showblog.getLabel());
            req.setAttribute("content",Showblog.getContent());
            req.setAttribute("date",Showblog.getDate());
            req.setAttribute("original",Showblog.getOriginal());
            System.out.println("title:"+Showblog.getTitle());

            req.setAttribute("blogid",Showblog.getId());
            req.setAttribute("blogger",Showblog.getWriter());

            req.setAttribute("visitor",visitor);
            ArrayList<register> Writer=new selectDao().findRegister(Showblog.getWriter());
            for (register writer:Writer)
            {
                req.setAttribute("writerhead",writer.getHead());
                req.setAttribute("writername",writer.getUsername());
            }

        }

        String collect = req.getParameter("collect");
        req.setAttribute("collect", collect);
        req.setAttribute("visitor",visitor );
        req.getRequestDispatcher("/showblog.jsp").forward(req, resp);
    }
}
