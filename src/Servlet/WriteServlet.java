package Servlet;


import Dao.insertDao;
import Dao.selectDao;
import Domain.Blog;
import Domain.register;

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


@WebServlet("/writeServlet")
public class WriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("writeServlet-post");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(new Date());
        date = date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8)+"   "+date.substring(8, 10)+":"+date.substring(10, 12);

        String[] arr=req.getParameterValues("label");
        String category = req.getParameter("category");
        String original = req.getParameter("original");
        String writer = req.getParameter("writer");
        String title = req.getParameter("title");
        String content = req.getParameter("test");

        System.out.println("writer:"+writer);
        System.out.println("title:"+title);
        System.out.println("content:"+content);
        System.out.println("category:"+category);
        System.out.println("original:"+original);
        String label=" ";
        System.out.println("label");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            label=label+arr[i]+" ";
        }
        System.out.println("-------------------");


        new insertDao().blog(writer,title,content,date,label,category,original,"推荐");//保存博客
        String blogid =new selectDao().selectid();
        System.out.println("blogid:"+blogid);
        new insertDao().audit(blogid,"未审核");

        ArrayList<Blog>  myblog=new selectDao().findBlog(writer);//查找该用户的所有博客
        HttpSession session=req.getSession();
        session.setAttribute("bloglist",myblog);

        req.setAttribute("email", writer);
        req.getRequestDispatcher("/myblog.jsp").forward(req, resp);
    }
}
