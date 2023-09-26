package loginSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IndexServlet", value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 创建或获取保存用户信息的Session对象
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.getWriter().write("您还没有登录，请点击<a href='/CookieSession/loginServlet'>登录</a>");

        } else {
            response.getWriter().write("您已登录，欢迎您" + user.getUsername() + "!" + "<br>");
            response.getWriter().write("<a href='shopping.html'>进入图书购买界面</a><br>");
            response.getWriter().write("<a href='/CookieSession/logoutServlet'>退出</a>");
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            if (user.getFreeStatus().equals("free")) {
                cookie.setMaxAge(60*2);
            } else {
                cookie.setMaxAge(-1);
            }
            cookie.setPath("/CookieSession");
            response.addCookie(cookie);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
