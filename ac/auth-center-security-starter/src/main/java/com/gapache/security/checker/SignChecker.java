package com.gapache.security.checker;

import com.alibaba.fastjson.JSONObject;

public interface SignChecker {

    boolean checkSign(JSONObject body, String clientId);
}
