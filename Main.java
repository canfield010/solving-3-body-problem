import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

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
        EXP
    }
    public static enum Constants {
        PI,
        E,
        ZERO,
        ONE,
        TWO,
        THREE,
        FIVE,
        SEVEN,
        ELEVEN
    }
    public static double[] constants = {Math.PI, Math.E, 0, 1, 2, 3, 5, 7, 11};

    public static void solvePI() {
        IntStream.range(0, (int)Math.sqrt(500)).parallel().forEach(i -> {
            Random r = new Random();
            r.setSeed(i);
            double opOverConstant = 0.95;
            ArrayList<Enum> theMath = new ArrayList<>();
            if (r.nextDouble()>opOverConstant) {
                theMath.add(Constants.FIVE);
                theMath.add(Operation.SIN);
            }
        });
    }

    public static void generateOperations(ArrayList<Enum> theMath, Random r, double opOverConstant) {
        if (r.nextDouble()>opOverConstant) {
            switch (r.nextInt(9)) {
                case 0:
                    theMath.add(Constants.PI);
                case 1:
                    theMath.add(Constants.E);
                case 2:
                    theMath.add(Constants.ZERO);
                case 3:
                    theMath.add(Constants.ONE);
                case 4:
                    theMath.add(Constants.TWO);
                case 5:
                    theMath.add(Constants.THREE);
                case 6:
                    theMath.add(Constants.FIVE);
                case 7:
                    theMath.add(Constants.SEVEN);
                case 8:
                    theMath.add(Constants.ELEVEN);
            }
        } else {
            opOverConstant *= 0.75;
            switch (r.nextInt(9)) {
                case 0:
                    theMath.add(Operation.ADD);
                    generateOperations(theMath, r, opOverConstant);
                    generateOperations(theMath, r, opOverConstant);
                case 1:
                    theMath.add(Operation.SUBTRACT);
                    generateOperations(theMath, r, opOverConstant);
                    generateOperations(theMath, r, opOverConstant);
                case 2:
                    theMath.add(Operation.MULTIPLY);
                    generateOperations(theMath, r, opOverConstant);
                    generateOperations(theMath, r, opOverConstant);
                case 3:
                    theMath.add(Operation.DIVIDE);
                    generateOperations(theMath, r, opOverConstant);
                    generateOperations(theMath, r, opOverConstant);
                case 4:
                    theMath.add(Operation.MODULO);
                    generateOperations(theMath, r, opOverConstant);
                    generateOperations(theMath, r, opOverConstant);
                case 5:
                    theMath.add(Operation.SIN);
                    generateOperations(theMath, r, opOverConstant);
                case 6:
                    theMath.add(Operation.COS);
                    generateOperations(theMath, r, opOverConstant);
                case 7:
                    theMath.add(Operation.TAN);
                    generateOperations(theMath, r, opOverConstant);
                case 8:
                    theMath.add(Operation.EXP);
                    generateOperations(theMath, r, opOverConstant);
                    generateOperations(theMath, r, opOverConstant);
            }
        }
    }

}
