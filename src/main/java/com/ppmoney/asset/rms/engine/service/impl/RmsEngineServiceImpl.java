package com.ppmoney.asset.rms.engine.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ppmoney.asset.rms.engine.model.RuleSet;
import com.ppmoney.asset.rms.engine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by paul on 2018/5/20.
 */
@Service
public class RmsEngineServiceImpl implements RmsEngineService {
    public static final String PARAM_CODE = "param";

    @Autowired
    private BusinessTypeService businessTypeService = null;

    @Autowired
    private RuleSetRoutingService ruleSetRoutingService = null;

    @Autowired
    private RuleSetManageService ruleSetManageService = null;

    @Autowired
    private RuleSetRunnerService ruleSetRunnerService = null;

    @Override
    public JSONObject invoke(JSONObject data) {
        Assert.notNull(data, "data should not be null.");
        JSONObject param = getParameter(data);
        Assert.notNull(param, "param in data should not be null.");

        String businessType = businessTypeService.getBusinessType(param);
        Assert.notNull(businessType, "We can't understand which business type it belongs to, please check the input data.");

        String ruleSetCode = ruleSetRoutingService.routing(businessType, param);
        Assert.notNull(ruleSetCode, "We con't understand which rule set should be used, please check the input data.");

        RuleSet ruleSet = ruleSetManageService.getRuleSet(businessType, ruleSetCode);

        return ruleSetRunnerService.run(data, ruleSet);
    }

    private JSONObject getParameter(JSONObject data) {
        Assert.notNull(data, "data should not be null.");
        return data.getJSONObject("param");
    }
}
