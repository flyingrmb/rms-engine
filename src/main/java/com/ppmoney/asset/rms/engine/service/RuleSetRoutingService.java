package com.ppmoney.asset.rms.engine.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by paul on 2018/5/20.
 */
public interface RuleSetRoutingService {
    String routing(String businessType, JSONObject param);
}
