package com.ppmoney.asset.rms.engine.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Created by paul on 2018/5/20.
 */
public interface RmsEngineService {
    JSONObject invoke(JSONObject data);
}
