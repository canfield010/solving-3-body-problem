package com.canfield010.attempttwo.links;

import java.util.Random;

public class Invert extends Link {

    public Link link1;

    int phase;
    int offset;

    public Invert(Random r, float branchRate) {
        link1 = r.nextFloat()<branchRate ? Link.getRandomOperator(r, branchRate) :  Link.getRandomConstant(r);
        phase = r.nextInt(2)+1;
        offset = r.nextInt(phase);
    }

    @Override
    public double compute(Random r, int count) {
        return (count+offset)%phase==0 ? -link1.compute(r, count) : link1.compute(r, count);
    }

    @Override
    public String getString() {
        return "Invert("+link1.getString()+", phase: "+phase+", offset: "+offset+")";
    }

    @Override
    public int getCount() {
        return 1+link1.getCount();
    }

}
