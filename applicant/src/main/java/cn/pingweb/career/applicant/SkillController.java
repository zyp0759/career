package cn.pingweb.career.applicant;

import cn.pingweb.career.model.Skill;
import cn.pingweb.career.service.SkillService;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/resume/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @RequestMapping("/save")
    @ResponseBody
    public VO saveSkill(@RequestParam("param1") String content, @RequestAttribute("userId")String userId){
        if(StringUtils.isEmpty(content)) {
            return new VO(4003, "信息不完整", null);
        }
        Skill skill = new Skill(userId, content);
        skillService.save(skill);
        return VO.SUCCESS;

    }

    @RequestMapping("/delete")
    @ResponseBody
    public VO saveSkill(@RequestAttribute("userId")String userId){
        skillService.remove(userId);
        return VO.SUCCESS;

    }

}
