package cn.pingweb.career.service.impl;

import cn.pingweb.career.service.FileService;
import cn.pingweb.career.util.MyUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String save(String path, String fileType, MultipartFile file, String userId) {
//        FileOutputStream fs = null;
//        try {
//            fs = new FileOutputStream();
//            byte[] buffer = new byte[1024 * 1024];
//            int bytesum = 0;
//            int byteread = 0;
//            while ((byteread = stream.read(buffer)) != -1) {
//                bytesum += byteread;
//                fs.write(buffer, 0, byteread);
//                fs.flush();
//            }
//            fs.close();
//            stream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(path+ MyUtil.getKeyId(userId)+fileType)));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，因为文件是空的.";
        }

    }

    @Override
    public void download() {

    }
}
