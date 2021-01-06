package Servlet;

import Dao.selectDao;
import Dao.updateDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/recommendServlet")
public class RecommendServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("post");

        String id = req.getParameter("id");
        System.out.println("id:"+id);

        String recommend =new selectDao().findRecommend(id);
        System.out.println("recommend:"+recommend);


        if ("推荐".equals(recommend)){
            new updateDao().recommend(id,"已推荐");
        }
        else {
            new updateDao().recommend(id,"推荐");
        }

    }
}
