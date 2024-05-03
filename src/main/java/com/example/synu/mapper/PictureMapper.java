package com.example.synu.mapper;

import com.example.synu.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PictureMapper {
    int PictureInsert(Picture picture);
}
