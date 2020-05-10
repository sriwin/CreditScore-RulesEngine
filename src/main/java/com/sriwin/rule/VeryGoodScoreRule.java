package com.sriwin.rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule
public class VeryGoodScoreRule {

  @Condition
  public boolean evaluate(@Fact("score") Integer score) {
    return score >= 740 && score <= 799;
  }

  @Action
  public void printScore(@Fact("score") Integer score) {
    System.out.print("Credit Score => Very Good");
  }
}
