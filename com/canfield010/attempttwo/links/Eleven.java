package com.canfield010.attempttwo.links;

import java.util.Random;

public class Eleven extends Link {

    @Override
    public double compute(Random r, int count) {
        return 11;
    }

    @Override
    public String getString() {
        return "Eleven";
    }

    @Override
    public int getCount() {
        return 1;
    }
}
