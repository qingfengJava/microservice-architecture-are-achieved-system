package com.gapache.sentinel;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import org.springframework.context.ApplicationContext;

import java.util.List;

public interface ProtectingCaller {

    /**
     * 初始化保护调用者配置
     *
     * @param context Spring 上下文
     * @return 降级配置
     */
    List<DegradeRule> init(ApplicationContext context);
}
