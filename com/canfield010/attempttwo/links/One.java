package com.canfield010.attempttwo.links;

import java.util.Random;

public class One extends Link {

    @Override
    public double compute(Random r, int count) {
        return 1;
    }

    @Override
    public String getString() {
        return "One";
    }

    @Override
    public int getCount() {
        return 1;
    }
}
