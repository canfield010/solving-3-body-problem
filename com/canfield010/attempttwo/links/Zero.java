package com.canfield010.attempttwo.links;

import java.util.Random;

public class Zero extends Link {

    @Override
    public double compute(Random r, int count) {
        return 0;
    }

    @Override
    public String getString() {
        return "Zero";
    }
}
