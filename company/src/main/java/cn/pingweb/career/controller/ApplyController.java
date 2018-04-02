package cn.pingweb.career.controller;

import cn.pingweb.career.dto.ApplyDto;
import cn.pingweb.career.dto.CompanyApplyDTO;
import cn.pingweb.career.dto.MyApplyDTO;
import cn.pingweb.career.model.Apply;
import cn.pingweb.career.model.BaseInfo;
import cn.pingweb.career.model.Recruitment;
import cn.pingweb.career.model.Work;
import cn.pingweb.career.service.ApplyService;
import cn.pingweb.career.service.BaseInfoService;
import cn.pingweb.career.service.RecruitmentService;
import cn.pingweb.career.service.WorkService;
import cn.pingweb.career.util.MyUtil;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ApplyController {

    private ApplyService applyService;
    private RecruitmentService recruitmentService;
    private BaseInfoService baseInfoService;

    @Autowired
    private WorkService workService;

    @Autowired
    public ApplyController(ApplyService applyService, RecruitmentService recruitmentService, BaseInfoService baseInfoService) {
        this.applyService = applyService;
        this.recruitmentService = recruitmentService;
        this.baseInfoService = baseInfoService;
    }

    @RequestMapping(value = "/addApply", method = RequestMethod.POST)
    public VO addApply(@RequestParam("workId") String workId,
                       @RequestAttribute("userId") String userId
    ) {
        if (workId == null || userId == null) {
            return VO.INVALID_TOKEN;
        }

        Apply apply = new Apply(MyUtil.getStringID(), userId, workId, new Date());

        applyService.save(apply);

        return VO.SUCCESS;

    }

    @RequestMapping(value = "/oneApply", method = RequestMethod.POST)
    public VO oneApply(@RequestAttribute("userId") String userId, @RequestParam("id") String id) {

        if (id == null) {
            return VO.INVALID_TOKEN;
        }
        Apply apply = applyService.findById(id);

        return new VO(apply);
    }

    @RequestMapping(value = "/company/allApply", method = RequestMethod.POST)
    public VO allApply(@RequestAttribute("userId") String userId) {

        List<Apply> applies = applyService.findAll();
        List<ApplyDto> applyDtos = new ArrayList<>();
        for(Apply apply : applies) {
            BaseInfo baseInfo = baseInfoService.getbyId(apply.getUserId());
            Work work = workService.findById(apply.getWorkId());
            applyDtos.add(new ApplyDto(apply, work, baseInfo));
        }

        return new VO(applyDtos);
    }


}
