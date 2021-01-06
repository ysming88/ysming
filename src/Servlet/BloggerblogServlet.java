package Servlet;

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
import java.util.ArrayList;

@WebServlet("/bloggerblogServlet")
public class BloggerblogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("bloggerblogServlet-post");

        String writer = req.getParameter("writer");
        System.out.println("writer:" + writer);
        String email = req.getParameter("email");
        System.out.println("email:" + email);

        ArrayList<Blog> bloggerallblog=new selectDao().findBlog(writer);//查找该博主的所有博客
        ArrayList<Blog> bloggerbloglist=new ArrayList<>();//该博主所有过审的博客集合
        for(Blog blog: bloggerallblog)
        {
            String audit=new selectDao().findCheck(blog.getId());//从博客中查找过审的
            if("已审核".equals(audit)){
                bloggerbloglist.add(blog);
                System.out.println(blog.getId());
            }
        }
        HttpSession session=req.getSession();
        session.setAttribute("bloggerbloglist",bloggerbloglist);

        ArrayList<register> searchblogger=new ArrayList<>();
        session.setAttribute("bloggerlist",searchblogger);

        req.setAttribute("email", email);
        req.getRequestDispatcher("/searchblogger.jsp").forward(req, resp);
    }
}
