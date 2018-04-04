package cn.pingweb.career.applicant;

import cn.pingweb.career.enums.EducationDegree;
import cn.pingweb.career.model.BaseInfo;
import cn.pingweb.career.service.BaseInfoService;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/resume/selfInfo")
public class SelfInfoController {

    @Autowired
    private BaseInfoService baseInfoService;

    @RequestMapping("/save")
    public VO saveSkill(@RequestParam("param1") String name, @RequestParam("param2") String gender,
                        @RequestParam("param3") String degree, @RequestParam("param4") String workYear,
                        @RequestParam("param5") String phone, @RequestParam("param6") String email,
                        @RequestParam("param7") String birthday, @RequestAttribute("userId")String userId){
        if(StringUtils.isEmpty(name)||StringUtils.isEmpty(gender)
                ||StringUtils.isEmpty(degree)||StringUtils.isEmpty(workYear)
                ||StringUtils.isEmpty(phone)||StringUtils.isEmpty(email)
                ||StringUtils.isEmpty(birthday)) {
            return new VO(4003, "信息不完整", null);
        }
        BaseInfo baseInfo = new BaseInfo(userId, name, gender,birthday,
                phone, email, EducationDegree.getDegreeNameByValue(degree), workYear);
        baseInfoService.save(baseInfo);
        return VO.SUCCESS;
    }

}
