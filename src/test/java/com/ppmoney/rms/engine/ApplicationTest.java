package com.ppmoney.rms.engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppmoney.asset.irule.entity.Rule;
import com.ppmoney.asset.itest.config.UnitTestConfiguration;
import com.ppmoney.asset.itest.runner.JpaMockRunner;
import com.ppmoney.asset.rms.engine.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by paul on 2018/5/15.
 */
@RunWith(JpaMockRunner.class)
@SpringBootTest(classes = {Application.class, UnitTestConfiguration.class})
@ActiveProfiles("dev")
public class ApplicationTest {
    @Autowired(required = false)
    private ApplicationContext ctx;

    @Test
    public void shouldStartWithApplicationContext() {
        assertThat(ctx, is(notNullValue()));
    }

    @Test
    public void shouldDeserializeRule() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:data/rule.json");

        Rule rule = mapper.readValue(resource.getFile(), Rule.class);
        assertThat(rule, is(notNullValue()));
    }
}