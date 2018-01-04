package com.freeraven.algorithms.greatcommondivisor;

/**
 * Created by zvlades on 4/27/17.
 */
public abstract class GreatCommonDivisor {

    abstract public int gcd(int num1, int num2);

    protected void validateArguments(int... arguments) {
        boolean isEachArgumentNonPositive = true;
        for (int arg : arguments) {
            if (arg > 0)
                return;
        }
        throw new IllegalArgumentException("All arguments are non-positive numbers");
    }
}
