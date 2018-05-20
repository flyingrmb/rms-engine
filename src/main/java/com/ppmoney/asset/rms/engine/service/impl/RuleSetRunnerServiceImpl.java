package com.ppmoney.asset.rms.engine.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ppmoney.asset.rms.engine.model.RuleSet;
import com.ppmoney.asset.rms.engine.service.RuleSetRunnerService;
import org.springframework.stereotype.Service;

/**
 * Created by paul on 2018/5/20.
 */
@Service
public class RuleSetRunnerServiceImpl implements RuleSetRunnerService {
    @Override
    public JSONObject run(JSONObject data, RuleSet ruleSet) {
        return null;
    }
}
