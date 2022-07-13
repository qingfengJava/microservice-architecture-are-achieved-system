package com.qingfeng.analysis.controller;

import com.qingfeng.analysis.service.CheckLinkService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 清风学Java
 * @date 2022-07-12 23:39:45
 */
@RestController
@Api(value = "提供客户才能相关接口", tags = "考核环节模块")
@RequestMapping("analysis/checklink")
@CrossOrigin
public class CheckLinkController {
    @Autowired
    private CheckLinkService checkLinkService;
}
