package com.freeraven.algorithms.greatcommondivisor;

/**
 * Created by zvlades on 4/1/17.
 */
public class NaiveGreatCommonDivisor extends GreatCommonDivisor {

    @Override
    public int gcd(int num1, int num2) {
        validateArguments(num1, num2);

        int max = Math.max(num1, num2);

        for (int i = max; i > 1; i--) {
            if ((num1 % i == 0) && (num2 % i == 0)) {
                return i;
            }
        }
        return 1;
    }
}
