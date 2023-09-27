package cartSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutCartServlet", value = "/LogoutCartServlet")
public class LogoutCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 获取购物车对象
            bookCart cart = (bookCart) session.getAttribute("cart");
            if (cart != null) {
                cart.clear(); // 清除购物车内容
            }
            session.invalidate(); // 使会话失效

        }
//        response.sendRedirect("/CookieSession/shopping.html");
        response.sendRedirect("/CookieSession/loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
