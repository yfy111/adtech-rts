package com.adtech.rts.controller;

import com.adtech.rts.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "/human", tags = "获取患者信息")
@Controller
@RequestMapping("/human")
public class HumanController {

    @ApiOperation(value = "或者患者详情信息")
    @GetMapping("/getHumanInfo")
    public Result getHumanInfo(String idCird){

        return new Result();
    }
}
