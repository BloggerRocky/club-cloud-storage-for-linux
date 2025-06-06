package com.example.colorclub.services.implement;

import com.example.colorclub.dto.redis.RedisUseSpaceDTO;
import com.example.colorclub.mapper.FileInfoMapper;
import com.example.colorclub.mapper.UserInfoMapper;
import com.example.colorclub.model.UserInfo;
import com.example.colorclub.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static com.example.colorclub.constants.NormalConstants.REDIS_DEFAULT_EXPIRE_TIME;
import static com.example.colorclub.constants.NormalConstants.REDIS_USER_SPACE_PREFIX;

/**
 * 作者：Rocky23318
 * 时间：2024.2024/7/18.22:33
 * 项目名：colorclub
 */
public class CommonServiceImpl {
    @Autowired
    FileInfoMapper fileInfoMapper;
    @Autowired
    RedisUtils<RedisUseSpaceDTO> redisUtilsForUserSpace;
    @Autowired
    UserInfoMapper userInfoMapper;
    //刷新内存信息
    void refreshUseSpace(String userId) {
        //计算已用内存总量
        Long useSpace = fileInfoMapper.getSizeByUserId(userId);
        useSpace = useSpace==null?0:useSpace;
        //更新redis缓存
        RedisUseSpaceDTO redisUseSpaceDTO = redisUtilsForUserSpace.get(REDIS_USER_SPACE_PREFIX+userId);
        redisUseSpaceDTO.setUseSpace(useSpace);
        redisUtilsForUserSpace.setex(REDIS_USER_SPACE_PREFIX+userId,redisUseSpaceDTO,REDIS_DEFAULT_EXPIRE_TIME);
        //更新数据库
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUseSpace(useSpace);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
