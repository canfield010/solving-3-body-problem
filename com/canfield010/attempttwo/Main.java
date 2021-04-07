package com.canfield010.attempttwo;

import com.canfield010.attempttwo.links.Link;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static final double goal = Math.PI;

    /*
    * I feel a lot more confident with this design. However, after running this for a few minutes, I haven't found the solution to PI yet!
    * I know there is a good solution to pi which should theoretically work, but maybe I need to do more testing. It's pretty late right now, so I'm gonna get some sleep.
    * Also, I don't know how good it is to run this program, because it says that it's using almost 90% of my cpu power (I don't have a gpu in my computer)! Also, it causes the fan to go crazy. It's probably not that bad though.
    * If I can get this to the point where it can find pi, I'll actually have it work on a solution to the three body problem. Also, PI will be a constant it will be able to use.
    * When running for the three body problem, I'm planning on googling for a more accurate version of a double so I can take much smaller timesteps in my calculations for the three bodies, because if I'm comparing it to an inaccurate answer, I will get an inaccurate equation.
    * It's been about 5 minutes though and still no PI. Gotta figure out whats up with that.
    * */

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        IntStream.range(0, 500).parallel().forEach(i -> {
            Random r = new Random();
            r.setSeed(i);
            while (true) {
                Link operations = Link.getRandomOperator(r, Link.INITIAL_BRANCH_RATE);
                double value = 0;
                for (int count = 0; count < 100; count++) {
                    value += operations.compute(r, count);
                }
                if (Math.abs(value-goal)<0.0000001) {
                    System.out.println("Found value "+value+", close to "+goal+", in a total of "+((double)(System.currentTimeMillis()-t)/1000D)+" seconds");
                    System.out.println(operations.getString());
                    break;
                }
            }
        });
    }
}
