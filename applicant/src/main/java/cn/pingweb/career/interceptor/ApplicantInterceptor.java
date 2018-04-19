package cn.pingweb.career.interceptor;

import cn.pingweb.career.model.User;
import cn.pingweb.career.service.UserService;
import cn.pingweb.career.util.GsonUtils;
import cn.pingweb.career.util.JedisUtils;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by wpc on 2017/5/21.
 */
public class ApplicantInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        String uid;
        String path = request.getServletPath();

        if (path.startsWith("/user/login")) {
            return true;
        }
        if (path.startsWith("/user/register")) {
            return true;
        }
        if (path.startsWith("/user/logout")) {
            return true;
        }

        if (token == null || (uid = JedisUtils.get(token)) == null) {
            response.getWriter().print(GsonUtils.toJson(VO.INVALID_TOKEN));
            return false;
        }

        uid = JedisUtils.get(token);
        if (path.startsWith("user")) {
            User user = userService.getUserById(uid);
            if (user != null ) {
                request.setAttribute("userId", uid);
                return true;
            } else {
                response.getWriter().print(GsonUtils.toJson(VO.INVALID_TOKEN));
                return false;
            }
        } else {
            request.setAttribute("userId", uid);
            return true;
        }

    }
}
