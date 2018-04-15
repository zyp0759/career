package cn.pingweb.career.applicant;

import cn.pingweb.career.model.BaseInfo;
import cn.pingweb.career.service.BaseInfoService;
import cn.pingweb.career.service.FileService;
import cn.pingweb.career.util.MyUtil;
import cn.pingweb.career.vo.VO;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
        //fileService.save("","",file,userId);
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
        String fileName = MyUtil.getKeyId(userId);
        fileService.save("D://image//",".png",file,userId, fileName);
        BaseInfo baseInfo = baseInfoService.getbyId(userId);
        if(StringUtils.isEmpty(baseInfo.getId())) {
            baseInfo = new BaseInfo(MyUtil.getKeyId(userId));
        }
        baseInfo.setHeadIcon(fileName);
        baseInfoService.save(baseInfo);
        Map<String, String> map = new HashMap<>();
        map.put("fileName", fileName);
        return new VO(map);

    }

    @RequestMapping(value = "/headIcon/get/{fileName}", method = RequestMethod.GET)
    @ResponseBody
    public void getHeadIcon(HttpServletResponse response,
                            @RequestAttribute("userId")String userId,
                            @PathVariable String fileName) throws IOException {
//        if(file == null) {
//            return new VO(4003, "信息不完整", null);
//        }
//        String name = file.getOriginalFilename();
//        long filesize  = file.getSize();
//        if(filesize>200000) {//判断图片大小
//        }

        //File name = fileService.download("D://image//", fileName);
        File file=new File("D://image//"+fileName);
        if(file.exists()){
            //设置MIME类型
            response.setContentType("application/octet-stream");
            //或者为response.setContentType("application/x-msdownload");

            //设置头信息,设置文件下载时的默认文件名，同时解决中文名乱码问题
            response.addHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes(), "ISO-8859-1"));

            InputStream inputStream=new FileInputStream(file);
            ServletOutputStream outputStream=response.getOutputStream();
            byte[] bs=new byte[1024];
            while((inputStream.read(bs)>0)){
                outputStream.write(bs);
            }
            outputStream.close();
            inputStream.close();
        }

    }

}
