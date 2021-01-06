package Servlet;

import Dao.insertDao;
import Demo.RandomNum;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/commentServlet")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("commentServlet-get" );

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(new Date());
        System.out.println("time1:"+time);
        time = time.substring(0, 4)+"-"+time.substring(4, 6)+"-"+time.substring(6, 8)+"   "+time.substring(8, 10)+":"+time.substring(10, 12)+":"+time.substring(13,14);
        System.out.println("time:"+time);
        String  commentid=new RandomNum().getRandomNumCode(4);//生成4位数为博客id

        String commented = req.getParameter("commented");
        String comment = req.getParameter("comment");
        String visitor = req.getParameter("visitor");
        String blogid = req.getParameter("blogid");
        System.out.println("commented:" + commented);
        System.out.println("comment:" + comment);
        System.out.println("visitor:" + visitor);
        System.out.println("blogid:" +  blogid);

        new insertDao().comment(commented,comment,visitor,blogid,commentid,time);//存入评论

//        ArrayList<Comment> blogcomment=new selectDao().findComment(blogid);//通过id查找该博客的所有评论
//        HttpSession session=req.getSession();
//        session.setAttribute("commentlist",blogcomment);

        req.getRequestDispatcher("/showblog.jsp").forward(req, resp);
    }
}
