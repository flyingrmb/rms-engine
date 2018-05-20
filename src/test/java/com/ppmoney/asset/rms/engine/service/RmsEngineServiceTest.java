package com.ppmoney.asset.rms.engine.service;

import com.alibaba.fastjson.JSONObject;
import com.ppmoney.asset.itest.annotation.DatabaseMockData;
import com.ppmoney.asset.itest.annotation.DatabaseMockItem;
import com.ppmoney.asset.itest.annotation.TestData;
import com.ppmoney.asset.itest.config.UnitTestConfiguration;
import com.ppmoney.asset.itest.data.TestDataLoader;
import com.ppmoney.asset.itest.runner.JpaMockRunner;
import com.ppmoney.asset.rms.engine.Application;
import com.ppmoney.asset.rms.engine.repositories.CfgRuleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by paul on 2018/5/20.
 */
@RunWith(JpaMockRunner.class)
@SpringBootTest(classes = {Application.class, UnitTestConfiguration.class})
@DatabaseMockData(@DatabaseMockItem(file = "classpath:entity/rules.json", repository = CfgRuleRepository.class))
@TestData("classpath:data/input.json")
@ActiveProfiles("dev")
public class RmsEngineServiceTest {
    @Autowired
    private RmsEngineService rmsEngineService = null;

    @Test
    public void shouldRunEngineRules() throws IOException {
        JSONObject data = TestDataLoader.loadTestData(JSONObject.class);
        JSONObject result = rmsEngineService.invoke(data);

        assertThat(result, is(notNullValue()));
    }
}