package com.example.colorclub.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.colorclub.model.FileInfo;
import com.example.colorclub.model.FileShare;
import com.example.colorclub.model.UserInfo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者：Rocky23318
 * 时间：2024.2024/7/14.21:00
 * 项目名：colorclub
 */
@Configuration
public class BeanProxy {
    @Bean
    public static ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public LambdaQueryWrapper<UserInfo> userInfoLqw() {
        return new LambdaQueryWrapper<>();
    }
    @Bean
    public LambdaQueryWrapper<FileInfo> fileInfoLqw() {
        return new LambdaQueryWrapper<>();
    }
    @Bean
    public LambdaQueryWrapper<FileShare> fileShareLqw() {
        return new LambdaQueryWrapper<>();
    }
}
