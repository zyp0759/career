package cn.pingweb.career.applicant;

import cn.pingweb.career.model.User;
import cn.pingweb.career.service.UserService;
import cn.pingweb.career.util.JedisUtils;
import cn.pingweb.career.util.MyUtil;
import cn.pingweb.career.util.TokenUtil;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class ApplicantController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public VO register(@RequestParam("param1") String email, @RequestParam("param2") String pwd) {
        if (email == null || pwd == null) {
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
    public VO login(@RequestParam("emailAddr") String email, @RequestParam("passwd") String pwd,
                    @RequestParam("zidong") String zidong, HttpSession session) {
        if (email == null || pwd == null ) {
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
//        User dto = new User(" ", " ", " ");
//        dto.setType(user.getType());
//        dto.setUserId(user.getUserId());
//
//        VO vo = new VO(200, token, dto);
//        return vo;
//    }

    @RequestMapping(value = "/reset_pwd")
    public VO resetUserPwd(@RequestAttribute("userId")String userId,
                           @RequestParam("oldPwd")String oldPwd,
                           @RequestParam("newPwd")String newPwd) {
        if(StringUtils.isEmpty(oldPwd) || StringUtils.isEmpty(newPwd)) {
            return new VO(4003, "输入不能为空", null);
        }
        User user = userService.getUserById(userId);
        if (!user.getPwd().equals(oldPwd)) {
            return new VO<>(1002, "密码错误", null);
        }
        user.setPwd(newPwd);
        userService.saveUser(user);
        return VO.SUCCESS;
    }


}
