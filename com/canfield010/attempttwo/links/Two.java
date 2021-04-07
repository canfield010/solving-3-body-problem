package com.canfield010.attempttwo.links;

import java.util.Random;

public class Two extends Link {

    @Override
    public double compute(Random r, int count) {
        return 2;
    }

    @Override
    public String getString() {
        return "Two";
    }

    @Override
    public int getCount() {
        return 1;
    }
}
