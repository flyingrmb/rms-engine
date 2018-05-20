package com.ppmoney.rms.engine.repositories;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ppmoney.asset.irule.entity.Milestone;
import com.ppmoney.asset.irule.entity.Rule;
import com.ppmoney.asset.rms.engine.Application;
import com.ppmoney.asset.rms.engine.entity.CfgRule;
import com.ppmoney.asset.rms.engine.repositories.CfgRuleRepository;
import com.ppmoney.asset.itest.annotation.DatabaseMockData;
import com.ppmoney.asset.itest.annotation.DatabaseMockItem;
import com.ppmoney.asset.itest.config.UnitTestConfiguration;
import com.ppmoney.asset.itest.runner.JpaMockRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by paul on 2018/5/19.
 */
@RunWith(JpaMockRunner.class)
@SpringBootTest(classes = {Application.class, UnitTestConfiguration.class})
@DatabaseMockData(@DatabaseMockItem(file = "classpath:entity/rules.json", repository = CfgRuleRepository.class))
@ActiveProfiles("dev")
public class CfgRuleRepositoryTest {
    @Autowired(required = false)
    private CfgRuleRepository repositories = null;

    @Test
    public void shouldGetRuleInformation() throws IOException {
        CfgRule cfgRule = repositories.findById(10010L).get();
        assertThat(cfgRule, is(notNullValue()));

        JSONArray array = JSON.parseArray(cfgRule.getSel());
        assertThat(array, is(notNullValue()));

        Rule rule = new Rule();
        rule.setSel(array);

        List<Milestone> milestones = JSON.parseArray(cfgRule.getSources(), Milestone.class);
        assertThat(milestones, is(notNullValue()));

        rule.setSources(milestones);

        rule = cfgRule.get();
        assertThat(rule, is(notNullValue()));
    }
}