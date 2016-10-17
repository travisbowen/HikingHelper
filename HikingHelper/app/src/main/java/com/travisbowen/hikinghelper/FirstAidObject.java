package com.travisbowen.hikinghelper;


public class FirstAidObject {

    String name;
    String steps1;
    String steps2;
    String steps3;
    String steps4;
    String steps5;
    String steps6;

    public FirstAidObject(String name, String steps1, String steps2, String steps3, String steps4, String steps5, String steps6) {
        this.name = name;
        this.steps1 = steps1;
        this.steps2 = steps2;
        this.steps3 = steps3;
        this.steps4 = steps4;
        this.steps5 = steps5;
        this.steps6 = steps6;
    }

    public String getName() {
        return name;
    }

    public String getSteps1() {
        return steps1;
    }

    public String getSteps2() {
        return steps2;
    }

    public String getSteps3() {
        return steps3;
    }

    public String getSteps4() {
        return steps4;
    }

    public String getSteps5() {
        return steps5;
    }

    public String getSteps6() {
        return steps6;
    }

    @Override
    public String toString() {
        return name;
    }
}
