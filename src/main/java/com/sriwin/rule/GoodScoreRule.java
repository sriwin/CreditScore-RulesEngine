package com.sriwin.rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Priority;
import org.jeasy.rules.annotation.Rule;

@Rule
public class GoodScoreRule {

  @Condition
  public boolean evaluate(@Fact("score") Integer score) {
    return score >= 670 && score <= 739;
  }

  @Action
  public void printScore(@Fact("score") Integer score) {
    System.out.print("Credit Score => Good");
  }
}
