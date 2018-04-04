package cn.pingweb.career.applicant;

import cn.pingweb.career.model.WorkExperience;
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
@RequestMapping("/resume/workExperience")
public class WorkExprienceController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @ResponseBody
    @RequestMapping("/save")
    public VO saveWorkExperience(@RequestAttribute("userId")String userId,
                                 @RequestParam("param1") String company,
                                 @RequestParam("param2") String position,
                                 @RequestParam("param3") String start,
                                 @RequestParam("param4") String end,
                                 @RequestParam("param7") String desc,
                                 @RequestParam("param8") String workExperienceId) {
        if (workExperienceId == null || desc == null || start == null || position == null || company == null) {
            return new VO(4003, "信息不完整", null);
        }
        String id = StringUtils.isEmpty(workExperienceId)? MyUtil.getKeyId(userId):workExperienceId;
        WorkExperience workExperience = new WorkExperience(id, userId, company, position, start, end, desc);
        workExperienceService.save(workExperience);
        Map<String, String> map = new HashMap<>();
        map.put("work_id", workExperience.getId());
        return new VO(map);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public VO deleteEducation(@RequestAttribute("userId") String userId, @RequestParam("workExperienceId") String workExperienceId) {

        if (workExperienceId == null) {
            return VO.INVALID_TOKEN;
        }
        workExperienceService.remove(workExperienceId);
        return VO.SUCCESS;
    }

}
