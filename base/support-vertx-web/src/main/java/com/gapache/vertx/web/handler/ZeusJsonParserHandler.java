package com.gapache.vertx.web.handler;

import com.gapache.vertx.web.zeus.Constants;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.springframework.util.StringUtils;

public class ZeusJsonParserHandler implements Handler<RoutingContext> {

    @Override
    public void handle(RoutingContext context) {
        String time = context.request().getHeader(Constants.FROM_ZEUS_HEADER);

        if (StringUtils.hasText(time)) {
            context.put("parseByArgOrder", true);
        }

        context.next();
    }
}
