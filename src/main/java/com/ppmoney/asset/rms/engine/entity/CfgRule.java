package com.ppmoney.asset.rms.engine.entity;

import com.alibaba.fastjson.JSON;
import com.ppmoney.asset.irule.entity.Algorithm;
import com.ppmoney.asset.irule.entity.Milestone;
import com.ppmoney.asset.irule.entity.Rule;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by paul on 2018/5/19.
 */
@Setter
@Getter
@Entity
public class CfgRule {
    @Id
    private Long id;
    private String sel;
    @Column(length=1024)
    private String sources;
    private String alg;
    private String target;

    public Rule get() {
        Rule rule = new Rule();

        rule.setSel(JSON.parseArray(this.getSel()));
        rule.setSources(JSON.parseArray(this.getSources(), Milestone.class));
        rule.setAlg(JSON.parseObject(this.getAlg(), Algorithm.class));
        rule.setTarget(JSON.parseObject(this.getTarget(), Milestone.class));

        return rule;
    }
}
