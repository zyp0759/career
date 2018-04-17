package cn.pingweb.career.controller;

import cn.pingweb.career.model.Apply;
import cn.pingweb.career.model.Recruitment;
import cn.pingweb.career.model.Work;
import cn.pingweb.career.service.ApplyService;
import cn.pingweb.career.service.RecruitmentService;
import cn.pingweb.career.service.WorkService;
import cn.pingweb.career.util.MyUtil;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class RecruitmentController {

    private RecruitmentService recruitmentService;

    @Autowired
    private WorkService workService;

    @Autowired
    private ApplyService applyService;

    @Autowired
    public RecruitmentController(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }

    @RequestMapping(value = "/company/saveRecruitment", method = RequestMethod.POST)
    public VO addRecruitment(@RequestParam("endTime") String endTime,
                             @RequestParam("startTime") String startTime,
                             @RequestParam("name") String position,
                             @RequestParam("workCity") String workCity,
                             @RequestParam("workType") String workType,
                             @RequestParam("id")String id,
                             @RequestAttribute("userId") String userId
    ) {
        if (endTime == null || position == null || workCity == null || workType == null || userId == null) {
            return VO.INVALID_TOKEN;
        }

        Date endDate = null;
        Date startDate = null;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            endDate = format1.parse(endTime);
            startDate = format1.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String wordId = StringUtils.isEmpty(id)?MyUtil.getStringID():id;
        Work work = new Work(wordId, userId, startDate, endDate, workType, position, workCity);
        workService.save(work);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneRecruitment", method = RequestMethod.POST)
    public VO oneRecruitment(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Recruitment recruitment = recruitmentService.getById(id);

        return new VO(recruitment);
    }

    @RequestMapping(value = "/company/allRecruitment", method = RequestMethod.POST)
    public VO allRecruitment() {

        List<Work> recruitments = workService.findAll();

        return new VO(recruitments);
    }

    @RequestMapping(value = "/company/recruitments", method = RequestMethod.POST)
    public VO recruitments(@RequestAttribute("userId") String userId) {

        List<Work> recruitments = workService.findAll();

        return new VO(recruitments);
    }

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public VO company(@RequestAttribute("userId") String userId, @RequestParam("company") String company) {

        if (company == null) {
            return VO.INVALID_TOKEN;
        }
        List<Recruitment> recruitments = recruitmentService.findByCompany(company);

        return new VO(recruitments);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public VO post(@RequestAttribute("userId") String userId, @RequestParam("post") String post) {

        if (post == null) {
            return VO.INVALID_TOKEN;
        }
        List<Recruitment> recruitments = recruitmentService.findByPost(post);

        return new VO(recruitments);
    }

    @RequestMapping(value = "/company/deleteRecruitment", method = RequestMethod.POST)
    public VO deleteRecruitment(@RequestAttribute("userId") String userId, @RequestParam("recruitmentId") String recruitmentId) {

        if (recruitmentId == null) {
            return VO.INVALID_TOKEN;
        }
        workService.remove(recruitmentId);
        return VO.SUCCESS;
    }

}
