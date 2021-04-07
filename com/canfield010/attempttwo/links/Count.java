package com.canfield010.attempttwo.links;

import java.util.Random;

public class Count extends Link {

    @Override
    public double compute(Random r, int count) {
        return count;
    }

    @Override
    public String getString() {
        return "Count";
    }

    @Override
    public int getCount() {
        return 1;
    }
}
