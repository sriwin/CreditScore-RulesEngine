package com.sriwin.test;

import com.sriwin.rule.ExceptionalScoreRule;
import com.sriwin.rule.FairScoreRule;
import com.sriwin.rule.VeryGoodScoreRule;
import com.sriwin.rule.VeryPoorScoreRule;
import com.sriwin.rule.GoodScoreRule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineParameters;

import java.sql.SQLOutput;

public class CreditScoreTest {
  public static void main(String[] args) {
    // create Rule Engine Parameters
    RulesEngineParameters parameters = new RulesEngineParameters()
        .skipOnFirstAppliedRule(true)
        .skipOnFirstFailedRule(true)
        .skipOnFirstNonTriggeredRule(false);

    // Creating a Rule Engine
    RulesEngine rulesEngine = new DefaultRulesEngine(parameters);

    // create rules
    Rules rules = new Rules();
    rules.register(new VeryPoorScoreRule());
    rules.register(new FairScoreRule());
    rules.register(new GoodScoreRule());
    rules.register(new VeryGoodScoreRule());
    rules.register(new ExceptionalScoreRule());

    // Fair
    int[] scores = {620, 720, 780, 820};
    for (int score : scores) {
      Facts facts = new Facts();
      System.out.println("Score Point = " + score);
      facts.put("score", score);
      rulesEngine.fire(rules, facts);
      System.out.println();
    }
  }
}
