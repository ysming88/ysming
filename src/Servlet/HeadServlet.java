package Servlet;

import Dao.updateDao;
import Domain.register;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@WebServlet("/headServlet")
public class HeadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("textml;charset=UTF-8");
        System.out.println("post");

        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("email");
        System.out.println("email:  " + email);//获取需要设置头像的用户邮箱

        SmartUpload smu = new SmartUpload();
        String rootPath = req.getSession().getServletContext().getRealPath("/resources/user/" + email + "/head");
        System.out.println("rootPath"+rootPath);//存放用户头像的地址

        File filePath = new File(rootPath);
        if (!filePath.exists())//判断用户是否自己设置头像
        {
            filePath.mkdirs();   //创建文件目录
        }
        try {
            smu.initialize(this.getServletConfig(), req, resp);
            smu.setCharset("UTF-8");
            smu.setAllowedFilesList("gif,jpg,png,bmp");
            smu.setMaxFileSize(30*1024*1024);
            smu.upload();//下载图片
            com.jspsmart.upload.File file = smu.getFiles().getFile(0);
            java.io.File realfile = new java.io.File(rootPath+"/"+file.getFileName());
            file.saveAs(realfile.toString());//保存图片
            String path = req.getContextPath();
            System.out.println("path:"+path);
            String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
            System.out.println("basePath"+basePath);

            String head = basePath+"resources/user/"+email+"/head/"+file.getFilePathName();
            new updateDao().updatehead( email, head);//将图片地址存入数据库
            session.setAttribute("head",head);

        } catch (SmartUploadException e) {
            resp.getWriter().write("error");
            e.printStackTrace();
        }

    }
}
