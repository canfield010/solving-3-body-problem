package com.canfield010.attempttwo.links;

import java.util.Random;

public class Three extends Link {

    @Override
    public double compute(Random r, int count) {
        return 3;
    }

    @Override
    public String getString() {
        return "Three";
    }

    @Override
    public int getCount() {
        return 1;
    }
}
