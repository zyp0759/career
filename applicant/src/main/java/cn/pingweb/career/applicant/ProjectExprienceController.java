package cn.pingweb.career.applicant;

import cn.pingweb.career.model.ProjectExperience;
import cn.pingweb.career.model.WorkExperience;
import cn.pingweb.career.service.ProjectExperienceService;
import cn.pingweb.career.service.WorkExperienceService;
import cn.pingweb.career.util.MyUtil;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/resume/projectExperience")
public class ProjectExprienceController {

    @Autowired
    private ProjectExperienceService projectExperienceService;

    @ResponseBody
    @RequestMapping("/save")
    public VO saveProjectExperience(@RequestAttribute("userId")String userId,
                                 @RequestParam("param1") String company,
                                 @RequestParam("param2") String position,
                                 @RequestParam("param3") String start,
                                 @RequestParam("param4") String end,
                                 @RequestParam("param5") String desc,
                                 @RequestParam("param6") String projectExperienceId) {
        if (projectExperienceId == null || desc == null || start == null || position == null || company == null) {
            return new VO(4003, "信息不完整", null);
        }
        String id = StringUtils.isEmpty(projectExperienceId)? MyUtil.getKeyId(userId):projectExperienceId;
        ProjectExperience projectExperience = new ProjectExperience(id, userId, company, position, start, end, desc);
        projectExperienceService.save(projectExperience);
        Map<String, String> map = new HashMap<>();
        map.put("project_id", projectExperience.getId());
        return new VO(map);

    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public VO deleteProject(@RequestAttribute("userId") String userId, @RequestParam("projectExperienceId") String projectExperienceId) {

        if (projectExperienceId == null) {
            return VO.INVALID_TOKEN;
        }
        projectExperienceService.remove(projectExperienceId);
        return VO.SUCCESS;
    }

}
