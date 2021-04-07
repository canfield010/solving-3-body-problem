package com.canfield010.attempttwo.links;

import java.util.Random;

public class Pow extends Link {

    public Link link1;
    public Link link2;

    public Pow(Random r, float branchRate) {
        link1 = r.nextFloat()<branchRate ? Link.getRandomOperator(r, branchRate) :  Link.getRandomConstant(r);
        link2 = r.nextFloat()<branchRate ? Link.getRandomOperator(r, branchRate) :  Link.getRandomConstant(r);
    }

    @Override
    public double compute(Random r, int count) {
        return Math.pow(link1.compute(r, count), link2.compute(r, count));
    }

    @Override
    public String getString() {
        return "Pow("+link1.getString()+", "+link2.getString()+")";
    }

}
