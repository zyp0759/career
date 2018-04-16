package cn.pingweb.career.controller.applicant;

import cn.pingweb.career.dto.UserDto;
import cn.pingweb.career.model.User;
import cn.pingweb.career.service.UserService;
import cn.pingweb.career.util.JedisUtils;
import cn.pingweb.career.util.MyUtil;
import cn.pingweb.career.util.TokenUtil;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public VO register(@RequestParam("id") String email,
                       @RequestParam("pwd") String pwd,
                       @RequestParam("type") String type) {
        if (email == null || pwd == null || type == null) {
            return new VO(4003, "输入不能为空", null);
        }
        if (!(email.trim().length() > 0 && pwd.trim().length() > 0)) {
            return new VO(4003, "输入不能为空", null);
        }
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return new VO(4005, "此账号已注册", null);
        }
        User user1 = new User(MyUtil.getKeyId(email), email, pwd);
        userService.saveUser(user1);
        return VO.SUCCESS;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public VO login(@RequestParam("id") String email, @RequestParam("pwd") String pwd, @RequestParam("type") String type, HttpSession session) {
        if (email == null || pwd == null || type == null) {
            return new VO(4003, "输入不能为空", null);
        }
        if (!(email.trim().length() > 0 && pwd.trim().length() > 0)) {
            return new VO(4003, "输入不能为空", null);
        }

        User user = userService.getUserByEmail(email);

        if (user == null) {
            return new VO(4005, "此账号不存在", null);
        }

        if (!user.getPwd().equals(pwd)) {
            return new VO<>(1002, "密码错误", null);
        }

//        if (!user.getType().equals(type)) {
//            return new VO<>(1002, "账号类型错误", null);
//        }

        String token = TokenUtil.genToken(user.getUserId());
        JedisUtils.set(token, user.getUserId());
        session.setAttribute("currentUser", user.getUserId());
        session.setAttribute("token", token);
        return new VO(200, "success", token);
    }

    @RequestMapping(value = "/logout")
    public VO logout(HttpSession session) {

        session.invalidate();

        return VO.SUCCESS;
    }

//    @RequestMapping(value = "/info")
//    public VO userInfo(HttpSession session) {
//
//        String token = (String) session.getAttribute("token");
//
//        String uid = JedisUtils.get(token);
//        User user = userService.getUserById(uid);
//        UserDto dto = new UserDto(" ", " ", " ");
//        dto.setType(user.getType());
//        dto.setUserId(user.getUserId());
//
//        VO vo = new VO(200, token, dto);
//        return vo;
//    }

}
