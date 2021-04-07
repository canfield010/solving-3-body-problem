package com.canfield010.attempttwo.links;

import java.util.Random;

public class Seven extends Link {

    @Override
    public double compute(Random r, int count) {
        return 7;
    }

    @Override
    public String getString() {
        return "Seven";
    }

    @Override
    public int getCount() {
        return 1;
    }
}
