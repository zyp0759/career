package cn.pingweb.career.applicant;

import cn.pingweb.career.vo.VO;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/keyword")
    @ResponseBody
    public VO getKeyWords(@RequestParam("param1") String kw){
        List<Map<String,String>> result = new ArrayList<>();
        Map<String, String>map = new HashMap<>();
        map.put("node_name", "test1");
        result.add(map);
        result.add(map);
        return new VO(result);

    }

    @RequestMapping("/save")
    @ResponseBody
    public VO saveSkill(@RequestParam("param1") String kw, @RequestAttribute("userId")String userId){
        System.out.println(kw);
        return VO.SUCCESS;

    }

}
