package cn.pingweb.career.applicant;

import cn.pingweb.career.model.Apply;
import cn.pingweb.career.service.ApplyService;
import cn.pingweb.career.service.RecruitmentService;
import cn.pingweb.career.service.WorkService;
import cn.pingweb.career.util.MyUtil;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    ApplyService applyService;

    @Autowired
    WorkService workService;

    @ResponseBody
    @RequestMapping(value = "/apply", method = RequestMethod.POST)
    public VO addApply(@RequestParam("workId") String workId,
                       @RequestAttribute("userId") String userId
    ) {
        if (workId == null || userId == null) {
            return VO.INVALID_TOKEN;
        }

        Apply apply = new Apply(MyUtil.getKeyId(userId), userId, workId, new Date());

        applyService.save(apply);

        return VO.SUCCESS;

    }


}
