package com.example.synu.controller;

import com.example.synu.pojo.Picture;
import com.example.synu.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/picture")
public class PictureConller {

    @Value("E:\\SYNU\\Graduation Project\\synu-pro\\src\\assets\\uploadImgs\\")
    private String pictureurl;

    //    注入业务逻辑层
    @Autowired
    PictureService pictureService;

    //    单文件上传
    @PostMapping("/pictureInsert")
    public void upload(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File saveFile = new File(pictureurl);
        if (!saveFile.exists()) {
            //若不存在该目录，则创建目录
            saveFile.mkdir();
        }
        //new一个实体类
        Picture picture = new Picture();
        //拼接url，采用随机数，保证每个图片的url不同
        UUID uuid = UUID.randomUUID();
        //拼接后的url
        String url = file.getOriginalFilename().replace(".","")+uuid;
        //图片名称
        String name =file.getOriginalFilename();
        //将url和name 分别set
        picture.setPictureUrl(url);
        picture.setPictureName(name);
        //存入数据库，这里可以加if判断
        pictureService.pictureInsert(picture);
        try {
            //将文件保存指定目录
            file.transferTo(new File(pictureurl + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
