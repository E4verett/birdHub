package ouc.bird.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ouc.bird.service.ImageService;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

@Controller
public class ImageController {

    @Autowired
    @Qualifier(value = "imageServiceImpl")
    private ImageService imageService;


    //图片上传
    @PostMapping(value = "/imgUpload")
    public void  uploadImage(@RequestParam(value = "image") MultipartFile file) throws IOException {
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

        //更新当日图片上传数量
        imageService.imageUpload(new Date(System.currentTimeMillis()));
        System.out.println("图片"+ fileName +"上传成功");

    }
}
