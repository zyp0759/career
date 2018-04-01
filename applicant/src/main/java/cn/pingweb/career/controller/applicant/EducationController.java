package cn.pingweb.career.controller.applicant;

import cn.pingweb.career.enums.EducationDegree;
import cn.pingweb.career.model.Education;
import cn.pingweb.career.service.EducationService;
import cn.pingweb.career.util.MyUtil;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/resume/education")
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public VO addEducation(@RequestParam("param1") String school,@RequestParam("param2") String degree,
                           @RequestParam("param3") String major, @RequestParam("param4") String start,
                           @RequestParam("param5") String end,
                           @RequestParam("param7") String educationId,
                           @RequestAttribute("userId") String userId
    ) {
        if (start == null || end == null || school == null || major == null || degree == null) {
            return new VO(4003, "信息不完整", null);
        }
        String eduId = StringUtils.isEmpty(educationId)?MyUtil.getKeyId(userId):educationId;
        Education education = new Education(eduId, userId, start, end, school, major, EducationDegree.getDegreeNameByValue(degree));

        educationService.save(education);
        Map<String, String>map = new HashMap<>();
        map.put("education_id", education.getEducationId());
        return new VO(map);

    }

    @RequestMapping(value = "/oneEducation", method = RequestMethod.POST)
    public VO findOne(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Education education = educationService.getById(id);

        return new VO(education);
    }

    @RequestMapping(value = "/company/allEducation", method = RequestMethod.POST)
    public VO allEducation(@RequestAttribute("userId") String userId) {

        List<Education> educations = educationService.getAll();

        return new VO(educations);
    }

    @RequestMapping(value = "/educations", method = RequestMethod.POST)
    public VO educations(@RequestAttribute("userId") String userId) {

        List<Education> educations = educationService.getByUserId(userId);

        return new VO(educations);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public VO deleteEducation(@RequestAttribute("userId") String userId, @RequestParam("educationId") String educationId) {

        if (educationId == null) {
            return VO.INVALID_TOKEN;
        }
        educationService.remove(educationId);
        return VO.SUCCESS;
    }

}
