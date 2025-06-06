package com.example.colorclub.controller;

import com.example.colorclub.dto.session.SessionWebUserDTO;

import javax.servlet.http.HttpSession;

import static com.example.colorclub.constants.NormalConstants.SESSION_USER_INFO_KEY;

/**
 * 作者：Rocky23318
 * 时间：2024.2024/7/18.14:02
 * 项目名：colorclub
 */
public class CommonController {
    String getUserIdBySession(HttpSession session) {
        SessionWebUserDTO userInfo = (SessionWebUserDTO) session.getAttribute(SESSION_USER_INFO_KEY);
        String userId = userInfo.getUserId();
        return userId;
    }
}
