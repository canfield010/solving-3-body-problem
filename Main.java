/*import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        solvePI();
    }

    public static enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        MODULO,
        SIN,
        COS,
        TAN,
        EXP,
        INVERT
    }
    public static enum Constants {
        //PI,
        E,
        ZERO,
        ONE,
        TWO,
        THREE,
        FIVE,
        SEVEN,
        ELEVEN,
        COUNT
    }
    //public static double[] constants = {Math.PI, Math.E, 0, 1, 2, 3, 5, 7, 11};

    public static void solvePI() {
        //IntStream.range(0, 500).parallel().forEach(i -> {
            int i = 0;
            long t = System.currentTimeMillis();
            Random r = new Random();
            r.setSeed(i);
            while (true) {
                double opOverConstant = 0.95;
                ArrayList<Enum> theMath = new ArrayList<>();
                ArrayList<Boolean> isOp = new ArrayList<>();
                generateOperations(theMath, isOp, r, opOverConstant);
                double value = doOperations(theMath, isOp);
                if (Math.abs(value-Math.PI)<0.0000000001) {
                    System.out.println("Found the solution in " + (System.currentTimeMillis()-t)/1000 +" seconds!");
                    System.out.println("Value found is " + value + ".");
                    break;
                }
            }

        //});
    }

    public static void generateOperations(ArrayList<Enum> theMath, ArrayList<Boolean> isOp, Random r, double opOverConstant) {
        if (r.nextDouble()>opOverConstant) {
            switch (r.nextInt(9)) {
                 //case 0:
                    //theMath.add(Constants.PI);
                case 0:
                    theMath.add(Constants.E);
                case 1:
                    theMath.add(Constants.ZERO);
                case 2:
                    theMath.add(Constants.ONE);
                case 3:
                    theMath.add(Constants.TWO);
                case 4:
                    theMath.add(Constants.THREE);
                case 5:
                    theMath.add(Constants.FIVE);
                case 6:
                    theMath.add(Constants.SEVEN);
                case 7:
                    theMath.add(Constants.ELEVEN);
                case 8:
                    theMath.add(Constants.COUNT);
            }
            isOp.add(false);
        } else {
            opOverConstant *= 0.75;
            switch (r.nextInt(10)) {
                case 0:
                    theMath.add(Operation.ADD);
                    generateOperations(theMath, isOp, r, opOverConstant);
                    generateOperations(theMath, isOp, r, opOverConstant);
                case 1:
                    theMath.add(Operation.SUBTRACT);
                    generateOperations(theMath, isOp, r, opOverConstant);
                    generateOperations(theMath, isOp, r, opOverConstant);
                case 2:
                    theMath.add(Operation.MULTIPLY);
                    generateOperations(theMath, isOp, r, opOverConstant);
                    generateOperations(theMath, isOp, r, opOverConstant);
                case 3:
                    theMath.add(Operation.DIVIDE);
                    generateOperations(theMath, isOp, r, opOverConstant);
                    generateOperations(theMath, isOp, r, opOverConstant);
                case 4:
                    theMath.add(Operation.MODULO);
                    generateOperations(theMath, isOp, r, opOverConstant);
                    generateOperations(theMath, isOp, r, opOverConstant);
                case 5:
                    theMath.add(Operation.SIN);
                    generateOperations(theMath, isOp, r, opOverConstant);
                case 6:
                    theMath.add(Operation.COS);
                    generateOperations(theMath, isOp, r, opOverConstant);
                case 7:
                    theMath.add(Operation.TAN);
                    generateOperations(theMath, isOp, r, opOverConstant);
                case 8:
                    theMath.add(Operation.EXP);
                    generateOperations(theMath, isOp, r, opOverConstant);
                    generateOperations(theMath, isOp, r, opOverConstant);
                case 9:
                    theMath.add(Operation.INVERT);
                    generateOperations(theMath, isOp, r, opOverConstant);// value to be inverted.
                    generateOperations(theMath, isOp, r, opOverConstant);// how often it repeats.
                    generateOperations(theMath, isOp, r, opOverConstant);// the offset of the repetition.
            }
            isOp.add(true);
        }
    }

    public static double doOperations(ArrayList<Enum> theMath, ArrayList<Boolean> isOp) {
        double value = 0.0;
        for(int i = 0; i<100;i++) {
            value += doOperation(theMath, isOp, 0, i);
        }
        return value;
    }
    private static double doOperation(ArrayList<Enum> theMath, ArrayList<Boolean> isOp, int index, int count) {
        if (isOp.get(index)) {
            switch ((Operation)theMath.get(index)) {
                case ADD:
                    return doOperation(theMath, isOp, index+1, count) + doOperation(theMath, isOp, index+2, count);
                case SUBTRACT:
                    return doOperation(theMath, isOp, index+1, count) - doOperation(theMath, isOp, index+2, count);
                case MULTIPLY:
                    return doOperation(theMath, isOp, index+1, count) * doOperation(theMath, isOp, index+2, count);
                case DIVIDE:
                    return doOperation(theMath, isOp, index+1, count) / doOperation(theMath, isOp, index+2, count);
                case MODULO:
                    return doOperation(theMath, isOp, index+1, count) % doOperation(theMath, isOp, index+2, count);
                case SIN:
                    return Math.sin(doOperation(theMath, isOp, index+1, count));
                case COS:
                    return Math.cos(doOperation(theMath, isOp, index+1, count));
                case TAN:
                    return Math.tan(doOperation(theMath, isOp, index+1, count));
                case EXP:
                    return Math.pow(doOperation(theMath, isOp, index+1, count), doOperation(theMath, isOp, index+2, count));
                case INVERT:
                    if ((count+doOperation(theMath, isOp, index+3, count))%doOperation(theMath, isOp, index+2, count)==0) {
                        return -doOperation(theMath, isOp, index+1, count);
                    } else {
                        return doOperation(theMath, isOp, index+1, count);
                    }
            }
        } else {
            return switch ((Constants)theMath.get(index)) {
                //case PI -> Math.PI;
                case E -> Math.E;
                case ZERO -> 0;
                case ONE -> 1;
                case TWO -> 2;
                case THREE -> 3;
                case FIVE -> 5;
                case SEVEN -> 7;
                case ELEVEN -> 11;
                case COUNT -> count;
            };
        }
        System.err.println("BIG PROBLEM!!! ILLEGIBLE OPERATION/CONSTANT");
        return 0.0;
    }

}
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        solvePI();
    }

    public static enum Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        MODULO,
        SIN,
        COS,
        TAN,
        EXP,
        INVERT,
        E,
        ZERO,
        ONE,
        TWO,
        THREE,
        FIVE,
        SEVEN,
        ELEVEN,
        COUNT
    }

    public static double lookingFor = Math.PI;
    //public static enum Constants {
        //PI,
        //E,
        //ZERO,
        //ONE,
        //TWO,
        //THREE,
        //FIVE,
        //SEVEN,
        //ELEVEN,
        //COUNT
    //}
    //public static double[] constants = {Math.PI, Math.E, 0, 1, 2, 3, 5, 7, 11};

    public static void solvePI() {
        //IntStream.range(0, 500).parallel().forEach(i -> {
        int i = 0;
        long t = System.currentTimeMillis();
        Random r = new Random();
        r.setSeed(i);
        while (true) {
            double opOverConstant = 0.95;
            ArrayList<Operation> theMath = new ArrayList<>();
            ArrayList<Boolean> isOp = new ArrayList<>();
            String string = "";
            string = generateOperations(theMath, isOp, r, opOverConstant, string);

            Operation[] operationArray = {Operation.INVERT, Operation.DIVIDE, Operation.MULTIPLY, Operation.TWO, Operation.TWO, Operation.ADD, Operation.ONE, Operation.MULTIPLY, Operation.COUNT, Operation.TWO, Operation.ONE, Operation.ONE};
            boolean[] booleanArray = {true, true, true, false, false, true, false, true, false, false, false, false};
            theMath = new ArrayList<>();
            for (Operation operation: operationArray) {
                theMath.add(operation);
            }
            isOp = new ArrayList<>();
            for (boolean bool: booleanArray) {
                isOp.add(bool);
            }
            //System.out.println();
            //System.out.println("Here are the values:");
            //for (int printI = 0; printI<theMath.size();printI++) {
                //System.out.println(theMath.get(printI) + ": " + isOp.get(printI));
            //}
            double value = doOperations(theMath, isOp);
            if (Math.abs(value-lookingFor)<0.0000000001) {
                System.out.println("Found the solution in " + (System.currentTimeMillis()-t)/1000 +" seconds!");
                System.out.println("Value found is " + value + ".");
                System.out.println("Here are the values:");
                //for (int printI = 0; printI<theMath.size();printI++) {
                    //System.out.println(theMath.get(printI) + ": " + isOp.get(printI));
                //}
                System.out.println(string);
                System.out.println("theMath is "+theMath.size()+" units long and there are "+isOp.size()+" booleans.");
                //System.out.println(addToString(theMath, "", 0));
                break;
            } else {
                System.out.println(value);
            }
        }

        //});
    }

    public static String generateOperations(ArrayList<Operation> theMath, ArrayList<Boolean> isOp, Random r, double opOverConstant, String string) {
        if (r.nextDouble()>opOverConstant) {
            switch (r.nextInt(9)) {
                case 0:
                    theMath.add(Operation.E);
                    string += Operation.E;
                    break;
                case 1:
                    theMath.add(Operation.ZERO);
                    string += Operation.ZERO;
                    break;
                case 2:
                    theMath.add(Operation.ONE);
                    string += Operation.ONE;
                    break;
                case 3:
                    theMath.add(Operation.TWO);
                    string += Operation.TWO;
                    break;
                case 4:
                    theMath.add(Operation.THREE);
                    string += Operation.THREE;
                    break;
                case 5:
                    theMath.add(Operation.FIVE);
                    string += Operation.FIVE;
                    break;
                case 6:
                    theMath.add(Operation.SEVEN);
                    string += Operation.SEVEN;
                    break;
                case 7:
                    theMath.add(Operation.ELEVEN);
                    string += Operation.ELEVEN;
                    break;
                case 8:
                    theMath.add(Operation.COUNT);
                    string += Operation.COUNT;
                    break;
            }
            isOp.add(false);
        } else {
            opOverConstant *= 0.8;
            switch (r.nextInt(10)) {
                case 0 -> {
                    theMath.add(Operation.ADD);
                    isOp.add(true);
                    string += Operation.ADD + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ", ";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";
                }
                case 1 -> {
                    theMath.add(Operation.SUBTRACT);
                    isOp.add(true);
                    string += Operation.SUBTRACT + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ", ";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";
                }
                case 2 -> {
                    theMath.add(Operation.MULTIPLY);
                    isOp.add(true);
                    string += Operation.MULTIPLY + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ", ";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";
                }
                case 3 -> {
                    theMath.add(Operation.DIVIDE);
                    isOp.add(true);
                    string += Operation.DIVIDE + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ", ";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";
                }
                case 4 -> {
                    theMath.add(Operation.MODULO);
                    isOp.add(true);
                    string += Operation.MODULO + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ", ";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";
                }
                case 5 -> {
                    theMath.add(Operation.SIN);
                    isOp.add(true);
                    string += Operation.SIN + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";
                }
                case 6 -> {
                    theMath.add(Operation.COS);
                    isOp.add(true);
                    string += Operation.COS + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";
                }
                case 7 -> {
                    theMath.add(Operation.TAN);
                    isOp.add(true);
                    string += Operation.TAN + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";
                }
                case 8 -> {
                    theMath.add(Operation.EXP);
                    isOp.add(true);
                    string += Operation.EXP + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ", ";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";
                }
                case 9 -> {
                    theMath.add(Operation.INVERT);
                    isOp.add(true);
                    string += Operation.INVERT + "(";
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ", ";// value to be inverted.
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ", ";// how often it repeats.
                    string = generateOperations(theMath, isOp, r, opOverConstant, string) + ")";// the offset of the repetition.
                }
            }
            //isOp.add(true);
        }
        return string;
    }

    public static double doOperations(ArrayList<Operation> theMath, ArrayList<Boolean> isOp) {
        double value = 0.0;
        for(int i = 0; i<100;i++) {
            value += doOperation(theMath, isOp, 0, i);
        }
        return value;
    }
    private static double doOperation(ArrayList<Operation> theMath, ArrayList<Boolean> isOp, int index, int count) {
        if (isOp.get(index)) {
            switch (theMath.get(index)) {
                case ADD:
                    return doOperation(theMath, isOp, index+1, count) + doOperation(theMath, isOp, index+2, count);
                case SUBTRACT:
                    return doOperation(theMath, isOp, index+1, count) - doOperation(theMath, isOp, index+2, count);
                case MULTIPLY:
                    return doOperation(theMath, isOp, index+1, count) * doOperation(theMath, isOp, index+2, count);
                case DIVIDE:
                    return doOperation(theMath, isOp, index+1, count) / doOperation(theMath, isOp, index+2, count);
                case MODULO:
                    return doOperation(theMath, isOp, index+1, count) % doOperation(theMath, isOp, index+2, count);
                case SIN:
                    return Math.sin(doOperation(theMath, isOp, index+1, count));
                case COS:
                    return Math.cos(doOperation(theMath, isOp, index+1, count));
                case TAN:
                    return Math.tan(doOperation(theMath, isOp, index+1, count));
                case EXP:
                    return Math.pow(doOperation(theMath, isOp, index+1, count), doOperation(theMath, isOp, index+2, count));
                case INVERT:
                    if ((count+doOperation(theMath, isOp, index+3, count))%doOperation(theMath, isOp, index+2, count)==0) {
                        return -doOperation(theMath, isOp, index+1, count);
                    } else {
                        return doOperation(theMath, isOp, index+1, count);
                    }
            }
        } else {
            return switch (theMath.get(index)) {
                //case PI -> Math.PI;
                case E -> Math.E;
                case ZERO -> 0;
                case ONE -> 1;
                case TWO -> 2;
                case THREE -> 3;
                case FIVE -> 5;
                case SEVEN -> 7;
                case ELEVEN -> 11;
                case COUNT -> count;
                default -> throw new IllegalStateException("Unexpected value: " + theMath.get(index));
            };
        }
        System.err.println("BIG PROBLEM!!! ILLEGIBLE OPERATION/CONSTANT");
        return 0.0;
    }

    public static String addToString(ArrayList<Operation> theMath, String string , int index) {
        if (theMath.size()<=index) {
            return "err";
        }
        switch (theMath.get(index)) {
            case ADD:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1) + ", " + addToString(theMath, string, index+2) + ")";
            case SUBTRACT:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1) + ", " + addToString(theMath, string, index+2) + ")";
            case MULTIPLY:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1) + ", " + addToString(theMath, string, index+2) + ")";
            case DIVIDE:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1) + ", " + addToString(theMath, string, index+2) + ")";
            case MODULO:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1) + ", " + addToString(theMath, string, index+2) + ")";
            case SIN:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1);
            case COS:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1);
            case TAN:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1);
            case EXP:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1) + ", " + addToString(theMath, string, index+2) + ")";
            case INVERT:
                string += theMath.get(index) + "(" + addToString(theMath, string, index+1) + ", " + addToString(theMath, string, index+2) + ", " + addToString(theMath, string, index+3) + ")";
            default:
                string += theMath.get(index);
        }
        return string;
    }

}