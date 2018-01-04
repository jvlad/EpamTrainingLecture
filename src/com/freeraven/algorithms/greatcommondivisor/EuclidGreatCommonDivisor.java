package com.freeraven.algorithms.greatcommondivisor;

/**
 * Created by zvlades on 4/27/17.
 */
public class EuclidGreatCommonDivisor extends GreatCommonDivisor {
    @Override
    public int gcd(int num1, int num2) {
        validateArguments(num1, num2);

        int min = num1;
        int max = num2;
        if (min > max) {
            int temp = max;
            max = min;
            min = temp;
        }

        while (min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }

        return max;
    }
}
