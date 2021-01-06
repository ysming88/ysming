package Servlet;

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

@WebServlet("/showblogServlet")
public class ShowblogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("showblogServlet-get");

        String title = req.getParameter("title");
        String id = req.getParameter("id");
        String email = req.getParameter("email");
        System.out.println("email:"+email);

        req.setAttribute("visitor",email);
        req.setAttribute("title",title);

        ArrayList<Blog> showblog=new selectDao().findShowblog(id);//查找id查找博客所有信息
        for(Blog Showblog:showblog)//将博客的相关信息传过去
        {
            req.setAttribute("category",Showblog.getCategory());
            req.setAttribute("label",Showblog.getLabel());
            req.setAttribute("content",Showblog.getContent());
            req.setAttribute("original",Showblog.getOriginal());
            req.setAttribute("date",Showblog.getDate());

            req.setAttribute("blogid",Showblog.getId());
            req.setAttribute("blogger",Showblog.getWriter());
            ArrayList<register> Writer=new selectDao().findRegister(Showblog.getWriter());
            for (register writer:Writer)
            {
                req.setAttribute("writerhead",writer.getHead());
                req.setAttribute("writername",writer.getUsername());
            }

            //查找博客评论
            HttpSession session=req.getSession();
            ArrayList<Comment> blogcomment=new selectDao().findComment(Showblog.getId(),Showblog.getId());//父级评论
            session.setAttribute("commentlist",blogcomment);

        }

        if("0".equals(email)){
            System.out.println("管理员查看博客");
            req.setAttribute("aa","AA");
            req.setAttribute("bb","BB");
            System.out.println("--------------------------------");
            req.getRequestDispatcher("/showblog.jsp").forward(req, resp);
        }
        else {
            String collect;
            if(new selectDao().collect(id,email)){
                collect ="已收藏";
            }
            else {
                collect ="收藏";
            }
            req.setAttribute("collect",collect);

            int count=new selectDao().greatcount(id);
            System.out.println("count:"+count);
            req.setAttribute("count",count);

            String great;
            if(new selectDao().great(id,email))
            {
                great = "已点赞";
            }
            else {
                great = "点赞";
            }
            req.setAttribute("great",great);

            System.out.println("--------------------------------");
            req.getRequestDispatcher("/showblog.jsp").forward(req, resp);
        }

    }
}
