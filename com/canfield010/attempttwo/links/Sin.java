package com.canfield010.attempttwo.links;

import java.util.Random;

public class Sin extends Link {

    public Link link1;

    public Sin(Random r, float branchRate) {
        link1 = r.nextFloat()<branchRate ? Link.getRandomOperator(r, branchRate) :  Link.getRandomConstant(r);
    }

    @Override
    public double compute(Random r, int count) {
        return Math.sin(link1.compute(r, count));
    }

    @Override
    public String getString() {
        return "Sin("+link1.getString()+")";
    }
}
