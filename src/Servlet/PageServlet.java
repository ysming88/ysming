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

@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("pageServlet-get");

        Integer page = Integer.parseInt(req.getParameter("page") + "");//第i页
        String email = req.getParameter("email");
        System.out.println("第几页:" + page);
        System.out.println("email:" + email);
        req.setAttribute("p", page);

        ArrayList<Blog> recommendblog=new selectDao().findeRcommend("已推荐");

        int blogcount=0;
        ArrayList<Blog> allbloglist=new ArrayList<>();//所有过审并被推荐的博客集合
        for(Blog blog:recommendblog){
            String audit=new selectDao().findCheck(blog.getId());//从已推荐的博客中查找过审的
            if("已审核".equals(audit)){
                allbloglist.add(blog);
                blogcount++;
            }
        }
        System.out.println("blogcount:"+blogcount);//首页将展示出来的博客总数

        req.setAttribute("email", email);
        req.setAttribute("bgc", "推荐");

        int pag;
        if(blogcount%6==0){
            pag=blogcount/6;
        }
        else {
            pag=blogcount/6+1;
        }
        System.out.println("page:"+pag);//分页数
        req.setAttribute("page", pag);

        int i=1;
        ArrayList<Blog> bloglist=new ArrayList<>();//需要传过去的第i个分页集合
        for (Blog blog:allbloglist){
            if(i>(page-1)*6&&i<page*6+1){
                bloglist.add(blog);
            }
            i++;
        }
        System.out.println("2222");

        HttpSession session=req.getSession();
        session.setAttribute("bloglist",bloglist);

        req.getRequestDispatcher("/homePage.jsp").forward(req, resp);
    }
}
