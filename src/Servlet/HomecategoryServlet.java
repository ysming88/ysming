package Servlet;

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

@WebServlet("/homecategoryServlet")
public class HomecategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );

        String category = req.getParameter("category");
        String email = req.getParameter("1email");
        System.out.println("category:" + category);
        System.out.println("email:" + email);

        if("推荐".equals(category)){
            ArrayList<Blog> recommendblog=new selectDao().findeRcommend("已推荐");
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

            HttpSession session=req.getSession();
            session.setAttribute("bloglist",bloglist);

            req.setAttribute("bgc", "推荐");
            req.setAttribute("p", "1");
            req.setAttribute("email", email);
            req.getRequestDispatcher("/homePage.jsp").forward(req, resp);
        }
        else {
            ArrayList<Blog> categorybloglist=new selectDao().findCategory(category);//查找该分类的所有博客
            ArrayList<Blog> bloglist=new ArrayList<>();//所有过审的该分类博客集合

            for(Blog blog:categorybloglist){
                String audit=new selectDao().findCheck(blog.getId());//从该分类的博客中查找过审的
                if("已审核".equals(audit)){
                    bloglist.add(blog);
                }
            }
            HttpSession session=req.getSession();
            session.setAttribute("bloglist",bloglist);

            req.setAttribute("page", "1");
            req.setAttribute("p", "1");
            req.setAttribute("bgc",category);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/homePage.jsp").forward(req, resp);
        }

    }
}
