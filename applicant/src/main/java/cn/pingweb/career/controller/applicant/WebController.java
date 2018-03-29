package cn.pingweb.career.controller.applicant;

import cn.pingweb.career.dto.EducationDto;
import cn.pingweb.career.dto.MyApplyDto2;
import cn.pingweb.career.dto.ProjectExperienceDto;
import cn.pingweb.career.dto.WorkExperienceDto;
import cn.pingweb.career.model.Apply;
import cn.pingweb.career.model.Work;
import cn.pingweb.career.service.*;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhuyuping
 * @date 2018/1/18.
 */
@Controller
@RequestMapping("/job")
public class WebController {

    @Autowired
    private EducationService educationService;

    @Autowired
    private WorkExperienceService workExperienceService;

    @Autowired
    private ProjectExperienceService projectExperienceService;

    @Autowired
    private SkillService skillService;

    @Autowired
    private SelfDescriptionService selfDescriptionService;

    @Autowired
    private ApplyService applyService;

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

    @RequestMapping("/register")
    public String reg() {
        return "register";
    }

    @RequestMapping("/resume")
    public String myResume(Model model, @RequestAttribute("userId") String userId) {
        model.addAttribute("educations", EducationDto.getDto(educationService.getByUserId(userId)));
        model.addAttribute("workExperience", WorkExperienceDto.getDtos(workExperienceService.findByUserId(userId)));
        model.addAttribute("projectExperience", ProjectExperienceDto.getDtos(projectExperienceService.findByUserId(userId)));
        model.addAttribute("selfDescription", selfDescriptionService.getSelfDescription(userId));
        model.addAttribute("skill", skillService.getSkillContent(userId));
        return "resume";
    }

    @Autowired
    private WorkService workService;
    @RequestMapping("/my_apply")
    public String myApply(Model model, @RequestAttribute("userId")String userId) {
        List<Apply>applies = applyService.findByUserId(userId);
        List<MyApplyDto2> applyDtos = new ArrayList<>();
        for(Apply apply : applies) {
            Work work = workService.findById(apply.getWorkId());
            applyDtos.add(new MyApplyDto2(apply.getTime(), work.getName(), "等待面试"));

        }
        model.addAttribute("apply_list",applyDtos);
        return "my_apply";
    }

    @RequestMapping("/joblist")
    public String joblist(Model model) {
        model.addAttribute("joblist", workService.findAll());
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

//    @RequestMapping("/resume")
//    public String resume() {
//        return "resume";
//    }

}

