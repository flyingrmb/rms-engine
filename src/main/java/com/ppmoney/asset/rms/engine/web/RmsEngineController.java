package com.ppmoney.asset.rms.engine.web;

import com.alibaba.fastjson.JSONObject;
import com.ppmoney.asset.rms.engine.service.RmsEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paul on 2018/5/20.
 */
@RestController
public class RmsEngineController {
    @Autowired
    private RmsEngineService rmsEngineService;

    @RequestMapping("/invoke")
    public JSONObject invoke(JSONObject data) {
        return rmsEngineService.invoke(data);
    }
}
