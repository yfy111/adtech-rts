package com.adtech.rts.service;

import com.adtech.rts.enums.CodeEnum;
import com.adtech.rts.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 用户登录
 */
@Service
public class LoginService {

    /**
     * 登录实现
     * @param userName
     * @param password
     * @return
     */
    public Result login(String userName,String password){
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)) return new Result(CodeEnum.SIGN_ERROR);
        else if(!userName.equals("admin")||!password.equals("123456"))return new Result((CodeEnum.SIGN_ERROR));
        return  new Result((CodeEnum.SIGN_SUCCESS));
    }
}
