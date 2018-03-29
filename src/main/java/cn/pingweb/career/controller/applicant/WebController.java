package cn.pingweb.career.controller.applicant;

import cn.pingweb.career.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/myapply")
    @ResponseBody
    public List<Job> getMyApply(){
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("1","2","3"));
        jobs.add(new Job("2","2","3"));
        jobs.add(new Job("3","2","3"));
        return jobs;
    }

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
    public String joblist(Model model) {
        model.addAttribute("user", "1589510939@qq.com");
        return "joblist";
    }

    @RequestMapping("/member_pwd")
    public String member_pwd() {
        return "member_pwd";
    }

    @RequestMapping("/header")
    public String header() {
        return "header";
    }

}

class Job {
    public String job_name;
    public String create_time;
    public String state;

    public Job() {
    }

    public Job(String job_name, String create_time, String state) {
        this.job_name = job_name;
        this.create_time = create_time;
        this.state = state;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}