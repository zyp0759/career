package cn.pingweb.career.controller.applicant;

import cn.pingweb.career.dto.UserDto;
import cn.pingweb.career.model.Staff;
import cn.pingweb.career.service.StaffService;
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
    private StaffService staffService;


    @RequestMapping(value = "/addStaff", method = RequestMethod.POST)
    public VO register(@RequestParam("id") String email, @RequestParam("pwd") String pwd, @RequestParam("type") String type) {
        if (email == null || pwd == null || type == null) {
            return new VO(4003, "输入不能为空", null);
        }
        if (!(email.trim().length() > 0 && pwd.trim().length() > 0)) {
            return new VO(4003, "输入不能为空", null);
        }

        Staff staff = staffService.getStaffByEmail(email);

        if (staff != null) {
            return new VO(4005, "此账号已添加", null);
        }

        Staff staff1 = new Staff(MyUtil.getKeyId(email), email, pwd);
        if (type.equals(Staff.COMPANY)) {
            staff1.setType(Staff.COMPANY);
        } else if (type.equals(Staff.ADMIN)) {
            staff1.setType(Staff.ADMIN);
        }
        staffService.saveStaff(staff1);
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

        //User user = userService.getUserById(userId);
        Staff staff = staffService.getStaffByEmail(email);

        if (staff == null) {
            return new VO(4005, "此账号不存在", null);
        }

        if (!staff.getPwd().equals(pwd)) {
            return new VO<>(1002, "密码错误", null);
        }

        if (!staff.getType().equals(type)) {
            return new VO<>(1002, "账号类型错误", null);
        }

        String token = TokenUtil.genToken(staff.getId());
        JedisUtils.set(token, staff.getId());
        session.setAttribute("currentUser", staff.getId());
        session.setAttribute("token", token);
        return new VO(200, "success", token);
    }

    @RequestMapping(value = "/logout")
    public VO logout(HttpSession session) {

        session.invalidate();

        return VO.SUCCESS;
    }

    @RequestMapping(value = "/info")
    public VO userInfo(HttpSession session) {

        String token = (String) session.getAttribute("token");

        String uid = JedisUtils.get(token);
        Staff staff = staffService.getStaffById(uid);
        UserDto dto = new UserDto(staff.getEmail(), staff.getType());
        VO vo = new VO(200, token, dto);
        return vo;
    }

}
