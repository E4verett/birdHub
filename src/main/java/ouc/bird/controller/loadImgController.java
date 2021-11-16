package ouc.bird.controller;


import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

@Controller
public class loadImgController {
    //图片上传
    @PostMapping(value = "/uploadImg")
//    @RequestMapping(value = "/uploadImg", method = {RequestMethod.POST})
    public ModelAndView uploadImage(@RequestParam(value = "image") MultipartFile file) throws IOException {

        // 获取文件名
        String fileName = file.getOriginalFilename();
        //加个时间戳，尽量避免文件名称重复
        fileName = System.currentTimeMillis() + "_" + fileName;
        //读取配置文件中图片的保存位置
        Properties properties = PropertiesLoaderUtils.loadAllProperties("path.properties");
        String savePath =  properties.getProperty("imagePath");
        //目录
        File destPath = new File(savePath);
        //判断图片保存目录是否存在
        if (!destPath.exists()) {
            destPath.mkdir();
        }
        //创建文件路径
        File imgPath = new File(destPath.getPath() +"/"+ fileName);
        file.transferTo(imgPath); //保存文件

        System.out.println("图片"+ fileName +"上传成功");
        System.out.println(imgPath.getPath());
        System.out.println(imgPath.getAbsolutePath());
        return new ModelAndView(new RedirectView("https://www.baidu.com"));
    }
}
