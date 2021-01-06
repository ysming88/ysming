package Servlet;

import Dao.insertDao;
import Dao.selectDao;
import Domain.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/transpondServlet")
public class TranspondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("transpondServlet-get");

        String blogid = req.getParameter("blogid");
        String writer = req.getParameter("visitor");
        System.out.println("blogid:"+blogid);
        System.out.println("writer:"+writer);

        String title;
        String content;
        String label;
        String category;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(new Date());
        date = date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8)+"   "+date.substring(8, 10)+":"+date.substring(10, 12);

        ArrayList<Blog> showblog=new selectDao().findShowblog(blogid);
        for(Blog Showblog:showblog){
            title=Showblog.getTitle();
            content=Showblog.getContent();
            label=Showblog.getLabel();
            category=Showblog.getCategory();

            new insertDao().blog(writer,title,content,date,label,category,"转发","推荐");//保存博客

            ArrayList<Blog>  myblog=new selectDao().findBlog(writer);//查找该转发者的所有博客

            HttpSession session=req.getSession();
            session.setAttribute("bloglist",myblog);

            req.setAttribute("email",writer);
            req.getRequestDispatcher("/myblog.jsp").forward(req, resp);
    }
}}
