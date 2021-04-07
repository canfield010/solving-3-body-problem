package com.canfield010.attempttwo.links;

import java.util.Random;

public class Cos extends Link {

    public Link link1;

    public Cos(Random r, float branchRate) {
        link1 = r.nextFloat()<branchRate ? Link.getRandomOperator(r, branchRate) :  Link.getRandomConstant(r);
    }

    @Override
    public double compute(Random r, int count) {
        return Math.cos(link1.compute(r, count));
    }

    @Override
    public String getString() {
        return "Cos("+link1.getString()+")";
    }

    @Override
    public int getCount() {
        return 1+link1.getCount();
    }
}
