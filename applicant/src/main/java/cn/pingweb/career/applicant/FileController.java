package cn.pingweb.career.applicant;

import cn.pingweb.career.model.BaseInfo;
import cn.pingweb.career.service.BaseInfoService;
import cn.pingweb.career.service.FileService;
import cn.pingweb.career.vo.VO;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/resume")
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private BaseInfoService baseInfoService;

    @RequestMapping("/file/upload")
    @ResponseBody
    public VO saveFile(@RequestParam("file") MultipartFile file,
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

    @RequestMapping("/headIcon/upload")
    @ResponseBody
    public VO saveHeadIcon(@RequestParam("fileToUpload") MultipartFile file,
                           @RequestAttribute("userId")String userId){
//        if(file == null) {
//            return new VO(4003, "信息不完整", null);
//        }
//        String name = file.getOriginalFilename();
//        long filesize  = file.getSize();
//        if(filesize>200000) {//判断图片大小
//        }

        String name = fileService.save("D://image//",".png",file,userId);
        BaseInfo baseInfo = baseInfoService.getbyId(userId);
        baseInfo.setHeadIcon(name);
        baseInfoService.save(baseInfo);
        return VO.SUCCESS;

    }

}
