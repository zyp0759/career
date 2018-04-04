package cn.pingweb.career.applicant;

import cn.pingweb.career.model.SelfDescription;
import cn.pingweb.career.service.SelfDescriptionService;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume/selfDescription")
public class SelfDescriptionController {

    @Autowired
    private SelfDescriptionService selfDescriptionService;

    @RequestMapping("/save")
    public VO saveSelfDescription(@RequestParam("param1") String content, @RequestAttribute("userId")String userId){
        if(StringUtils.isEmpty(content)) {
            return new VO(4003, "信息不完整", null);
        }
        SelfDescription selfDescription = new SelfDescription(userId, content);
        selfDescriptionService.save(selfDescription);
        return VO.SUCCESS;
    }

    @RequestMapping("/delete")
    public VO deleteSelfDescription(@RequestAttribute("userId")String userId){
        selfDescriptionService.remove(userId);
        return VO.SUCCESS;

    }

}
