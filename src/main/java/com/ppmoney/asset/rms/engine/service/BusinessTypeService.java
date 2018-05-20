package com.ppmoney.asset.rms.engine.service;

import com.alibaba.fastjson.JSONObject;

/**
 * This is the base class that will use the input param to decide which business type it belongs to.
 * Created by paul on 2018/5/20.
 */
public interface BusinessTypeService {
    String getBusinessType(JSONObject param);
}
