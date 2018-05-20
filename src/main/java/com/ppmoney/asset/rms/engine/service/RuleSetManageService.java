package com.ppmoney.asset.rms.engine.service;

import com.ppmoney.asset.rms.engine.model.RuleSet;

/**
 * Created by paul on 2018/5/20.
 */
public interface RuleSetManageService {
    RuleSet getRuleSet(String businessType, String ruleSetCode);
}
