package com.example.synu.service.impl;

import com.example.synu.mapper.PictureMapper;
import com.example.synu.pojo.Picture;
import com.example.synu.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    PictureMapper pictureMapper;

    @Override
    public int pictureInsert(Picture picture) {
        return pictureMapper.PictureInsert(picture);
    }
}
