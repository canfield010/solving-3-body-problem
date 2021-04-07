package com.canfield010.attempttwo;

import com.canfield010.attempttwo.links.Link;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static final double goal = 2.0;

    /*
    * I feel a lot more confident with this design. However, after running this for a few minutes, I haven't found the solution to PI yet!
    * I know there is a good solution to pi which should theoretically work, but maybe I need to do more testing. It's pretty late right now, so I'm gonna get some sleep.
    * Also, I don't know how good it is to run this program, because it says that it's using almost 90% of my cpu power (I don't have a gpu in my computer)! Also, it causes the fan to go crazy. It's probably not that bad though.
    * If I can get this to the point where it can find pi, I'll actually have it work on a solution to the three body problem. Also, PI will be a constant it will be able to use.
    * When running for the three body problem, I'm planning on googling for a more accurate version of a double so I can take much smaller timesteps in my calculations for the three bodies, because if I'm comparing it to an inaccurate answer, I will get an inaccurate equation.
    * It's been about 5 minutes though and still no PI. Gotta figure out whats up with that.
    *
    * Progress update: At Gannon, adding some gui features. It now sends updates every minute, and after the first 10 seconds.
    * something interesting I found is that only 4 threads run at a time. I guess it's supposed to be a gpu feature where each thread is run for a very short time, not to be used as individual threads that last a while, but still I would have expected it to do more.
    * Can't wait to get home and test it on my PC where it might allocate more threads, we'll have to see.
    * */

    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        System.out.println("Operation started. Collecting data for 10 seconds.\n");

        final DataKeeper dataKeeper = new DataKeeper();
        dataKeeper.start();

        IntStream.range(0, Link.THREAD_COUNT).parallel().forEach(i -> {
            Random r = new Random();
            r.setSeed(i);
            //boolean firstTime = true;
            //long timer;
            //int operationCounter;
            //float averageOperationLength;
            int operationCount = 0;
            while (true) {

                //if (firstTime) {
                    //if (System.currentTimeMillis()-t>10000) {
                        //firstTime = false;

                        //System.out.println("");

                    //}
                //}

                Link operations = Link.getRandomOperator(r, Link.INITIAL_BRANCH_RATE);
                double value = 0;
                for (int count = 0; count < Link.ATTEMPT_COMPUTATIONS; count++) {
                    value += operations.compute(r, count);
                }

                operationCount++;
                //System.out.println("really did something");
                if (operationCount%10==0) {
                    //System.out.println("did something");
                    dataKeeper.updateData(i, operations.getCount());
                }

                if (Math.abs(value-goal)<Link.ATTEMPT_ACCEPTED_ACCURACY) {
                    if (Math.abs(value-goal)<Link.ATTEMPT_VERY_GOOD_ACCURACY) {
                        //System.err.println("\n\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        //System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        //System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\nFound answer "+value+", close enough to "+goal+", in a total of "+((double)(System.currentTimeMillis()-t)/1000D)+" seconds");
                        System.err.println(operations.getString()+"\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        //System.err.println(":@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        //System.out.println(":@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        //System.err.println(":@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n\n");

                        dataKeeper.runningThreads--;
                        break;
                    }
                    System.err.println("Found value "+value+", close to "+goal+", in a total of "+((double)(System.currentTimeMillis()-t)/1000D)+" seconds");
                    System.err.println(operations.getString()+"\n");
                    dataKeeper.runningThreads--;
                    break;
                }



            }
        });
    }
}
