package com.ppmoney.asset.rms.engine.service;

import com.alibaba.fastjson.JSONObject;
import com.ppmoney.asset.rms.engine.model.RuleSet;

/**
 * Created by paul on 2018/5/20.
 */
public interface RuleSetRunnerService {
    JSONObject run(JSONObject data, RuleSet ruleSet);
}
