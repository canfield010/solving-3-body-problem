package com.canfield010.attempttwo.links;

import java.util.Random;

public class Five extends Link {

    @Override
    public double compute(Random r, int count) {
        return 5;
    }

    @Override
    public String getString() {
        return "Five";
    }

    @Override
    public int getCount() {
        return 1;
    }
}
