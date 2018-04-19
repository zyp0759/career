package cn.pingweb.career.controller;

import cn.pingweb.career.model.*;
import cn.pingweb.career.service.*;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AllInfoController {

    private BaseInfoService baseInfoService;
    private EducationService educationService;
    //private PracticeService practiceService;
    private WorkService workService;
    private ScholarshipService scholarshipService;
    private MatchesService matchesService;
    private OtherInfoService otherInfoService;
    @Autowired
    private ProjectExperienceService projectExperienceService;
    @Autowired
    private WorkExperienceService workExperienceService;
    @Autowired
    private SelfDescriptionService selfDescriptionService;
    @Autowired
    private SkillService skillService;

    @Autowired
    public AllInfoController(BaseInfoService baseInfoService, EducationService educationService, WorkService workService, ScholarshipService scholarshipService, MatchesService matchesService, OtherInfoService otherInfoService) {
        this.baseInfoService = baseInfoService;
        this.educationService = educationService;
        //this.practiceService = practiceService;
        this.workService = workService;
        this.scholarshipService = scholarshipService;
        this.matchesService = matchesService;
        this.otherInfoService = otherInfoService;
    }

    @RequestMapping(value = "/company/all", method = RequestMethod.POST)
    public VO all(@RequestParam("userId") String userId) {

        if (userId == null) {
            return VO.INVALID_TOKEN;
        }

        List<BaseInfo> baseInfos = new ArrayList<>();
        List<Education> educations = new ArrayList<>();
        List<ProjectExperience> practices = new ArrayList<>();
        List<WorkExperience> works = new ArrayList<>();
        List<Scholarship> scholarships = new ArrayList<>();
        List<Matches> matches = new ArrayList<>();
        List<OtherInfo> otherInfos = new ArrayList<>();
        List<Skill>skills = new ArrayList<>();
        List<SelfDescription>selfDescriptions = new ArrayList<>();

        BaseInfo baseInfo = baseInfoService.getbyId(userId);
        baseInfos.add(baseInfo);

        educations = educationService.getByUserId(userId);
        practices = projectExperienceService.findByUserId(userId);
        works = workExperienceService.findByUserId(userId);
        //scholarships = scholarshipService.findByUserId(userId);
        //matches = matchesService.findByUserId(userId);
        //otherInfos = otherInfoService.findByUserId(userId);
        skills.add(skillService.findById(userId));
        selfDescriptions.add(selfDescriptionService.findById(userId));

        Map<String, Object> map = new HashMap<>();
        map.put("baseInfos", baseInfos);
        map.put("educations", educations);
        map.put("projectExperience", practices);
        map.put("workExperience", works);
        map.put("scholarships", scholarships);
        map.put("matches", matches);
        map.put("otherInfos", otherInfos);
        map.put("skillDescription", skills);
        map.put("selfDescription", selfDescriptions);

        return new VO(200, "success", map);

    }

}
