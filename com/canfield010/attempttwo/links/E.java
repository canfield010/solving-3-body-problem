package com.canfield010.attempttwo.links;

import java.util.Random;

public class E extends Link {

    @Override
    public double compute(Random r, int count) {
        return Math.E;
    }

    @Override
    public String getString() {
        return "E";
    }
}
