package cn.pingweb.career.applicant;

import cn.pingweb.career.service.FileService;
import cn.pingweb.career.vo.VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/resume/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/upload")
    @ResponseBody
    public VO saveSkill( MultipartFile file,
                        @RequestAttribute("userId")String userId){
//        if(file == null) {
//            return new VO(4003, "信息不完整", null);
//        }
//        String name = file.getOriginalFilename();
//        long filesize  = file.getSize();
//        if(filesize>200000) {//判断图片大小
//        }
        fileService.save("","",file,userId);
        return VO.SUCCESS;

    }

}
