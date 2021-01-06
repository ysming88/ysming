package Servlet;

import Dao.selectDao;
import Domain.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/editblogServlet")
public class EditblogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );

        String writer = req.getParameter("writer");
        String title = req.getParameter("title");
        String id = req.getParameter("id");
        ArrayList<Blog> showblog=new selectDao().findShowblog(id);//查找id查找博客所有信息
        for(Blog Showblog:showblog)//将博客的内容传过去
        {
            req.setAttribute("content",Showblog.getContent());
        }
        req.setAttribute("writer",writer);
        req.setAttribute("title",title);
        req.setAttribute("id",id);
        req.getRequestDispatcher("/editblog.jsp").forward(req, resp);
    }
}
