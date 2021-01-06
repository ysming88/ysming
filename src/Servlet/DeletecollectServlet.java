package Servlet;

import Dao.deleteDao;
import Dao.selectDao;
import Domain.Blog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/deletecollectServlet")
public class DeletecollectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("Deletecollect-get" );

        String blogger = req.getParameter("blogger");
        String blogid = req.getParameter("blogid");
        String collector = req.getParameter("visitor");
        System.out.println("blogger:" + blogger);
        System.out.println("blogid:" +  blogid);
        System.out.println("collector:" + collector);

        if(new deleteDao().delCollect(blogid,collector)){
            //通过收藏者查找他所收藏的所有博客id
            ArrayList<String> idlist=new selectDao().findcollect(collector);
            ArrayList<Blog> bloglist=new ArrayList<>();
            for(String i:idlist){
                System.out.println(i);
                bloglist.add(new selectDao().idfindblog(i));
            }
            HttpSession session=req.getSession();
            session.setAttribute("bloglist",bloglist);

            req.setAttribute("email", collector);
            req.getRequestDispatcher("/mycollect.jsp").forward(req, resp);
        }
    }
}
