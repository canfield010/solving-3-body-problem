package com.canfield010.attempttwo.links;

import java.util.Random;

public class Tan extends Link {

    public Link link1;

    public Tan(Random r, float branchRate) {
        link1 = r.nextFloat()<branchRate ? Link.getRandomOperator(r, branchRate) :  Link.getRandomConstant(r);
    }

    @Override
    public double compute(Random r, int count) {
        return Math.tan(link1.compute(r, count));
    }

    @Override
    public String getString() {
        return "Tan("+link1.getString()+")";
    }

    @Override
    public int getCount() {
        return 1+link1.getCount();
    }
}
