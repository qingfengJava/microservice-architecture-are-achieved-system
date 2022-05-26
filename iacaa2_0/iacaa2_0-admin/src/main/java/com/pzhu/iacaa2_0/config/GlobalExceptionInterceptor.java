package com.pzhu.iacaa2_0.config;

import com.gapache.commons.model.SecurityException;
import com.pzhu.iacaa2_0.common.ActionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class GlobalExceptionInterceptor {

    /**
     * 捕获自定义异常，返回json信息
     */
    @ExceptionHandler({SecurityException.class})
    @ResponseBody
    public ActionResult errorHandle(SecurityException e){
        return ActionResult.ofFail(403,"没有权限");
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ActionResult errorHandle(Exception e){
        log.error("系统出错：",e);
        return ActionResult.ofFail("系统异常");
    }
}
