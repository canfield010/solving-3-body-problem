package com.canfield010.attempttwo.links;

import java.util.Random;

public abstract class Link {

    public static final float INITIAL_BRANCH_RATE = 0.9F;
    public static final float BRANCH_REDUCTION = 0.85F;
    public static final int THREAD_COUNT = 10;
    public static final int ATTEMPT_COMPUTATIONS = 1_000;
    public static final double ATTEMPT_ACCEPTED_ACCURACY = 0.01;
    public static final double ATTEMPT_VERY_GOOD_ACCURACY = 0.000001;

    public abstract double compute(Random r, int count);

    public abstract String getString();

    public abstract int getCount();

    // if I ever add or remove operators or constants, I can change it here and it will affect my code everywhere!
    public static Link getRandomOperator(Random r, float branchRate) {
        switch(r.nextInt(10)) {
            case 0:
                return new Add(r, branchRate*BRANCH_REDUCTION);
            case 1:
                return new Subtract(r, branchRate*BRANCH_REDUCTION);
            case 2:
                return new Multiply(r, branchRate*BRANCH_REDUCTION);
            case 3:
                return new Divide(r, branchRate*BRANCH_REDUCTION);
            case 4:
                return new Modulo(r, branchRate*BRANCH_REDUCTION);
            case 5:
                return new Sin(r, branchRate*BRANCH_REDUCTION);
            case 6:
                return new Cos(r, branchRate*BRANCH_REDUCTION);
            case 7:
                return new Tan(r, branchRate*BRANCH_REDUCTION);
            case 8:
                return new Pow(r, branchRate*BRANCH_REDUCTION);
            case 9:
                return new Invert(r, branchRate*BRANCH_REDUCTION);
            default:
                System.err.println("We have a problem with the operators");
                return null;
        }
    }

    public static Link getRandomConstant(Random r) {
        switch(r.nextInt(9)) {
            case 0:
                return new E();
            case 1:
                return new Zero();
            case 2:
                return new One();
            case 3:
                return new Two();
            case 4:
                return new Three();
            case 5:
                return new Five();
            case 6:
                return new Seven();
            case 7:
                return new Eleven();
            case 8:
                return new Count();
            default:
                System.err.println("We have a problem with the constants");
                return null;
        }
    }

}
