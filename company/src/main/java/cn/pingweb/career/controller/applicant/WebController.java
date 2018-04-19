package cn.pingweb.career.controller.applicant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuyuping
 * @date 2018/1/18.
 */
@Controller
@RequestMapping("/job")
public class WebController {

//    @RequestMapping("/user")
//    public String getUser(){
//        return "user";
//    }


    @RequestMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @RequestMapping("/error")
    public String fail() {
        return "404";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/agreement")
    public String agreement() {
        return "agreement";
    }

    @RequestMapping("/company")
    public String company() {
        return "company";
    }

    @RequestMapping("/detail_company")
    public String detail_company() {
        return "detail_company";
    }

    @RequestMapping("/forget")
    public String forget() {
        return "forget";
    }

    @RequestMapping("/index")
    public String index() {
        return "company_index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/reg")
    public String reg() {
        return "reg";
    }

    @RequestMapping("/resume")
    public String resume() {
        return "resume";
    }

    @RequestMapping("/my_resume")
    public String myResume() {
        return "my_resume";
    }

    @RequestMapping("/my_apply")
    public String myApply() {
        return "my_apply";
    }

    @RequestMapping("/joblist")
    public String joblist() {
        return "joblist";
    }

    @RequestMapping("/member_pwd")
    public String member_pwd() {
        return "member_pwd";
    }

}
