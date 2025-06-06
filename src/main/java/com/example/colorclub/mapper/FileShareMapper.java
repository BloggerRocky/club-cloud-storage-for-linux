package com.example.colorclub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.colorclub.model.FileShare;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileShareMapper extends BaseMapper<FileShare> {
    int deleteByPrimaryKey(String shareId);

    int insert(FileShare record);

    int insertSelective(FileShare record);

    FileShare selectByPrimaryKey(String shareId);

    int updateByPrimaryKeySelective(FileShare record);

    int updateByPrimaryKey(FileShare record);
}
