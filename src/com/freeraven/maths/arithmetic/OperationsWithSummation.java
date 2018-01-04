package com.freeraven.maths.arithmetic;

/**
 * Created by zvlad on 7/11/16.
 */
class OperationsWithSummation {
    int subtract(int minuend, int subtrahend) {
        return minuend + negate(subtrahend);
    }

    int multiply(int biggerFactor, int smallerFactor) {
        int biggerFactorAbs = abs(biggerFactor);
        int smallerFactorAbs = abs(smallerFactor);

        if (smallerFactorAbs > biggerFactorAbs) {
            return multiply(smallerFactor, biggerFactor);
        }

        int product = 0;
        for (int i = 0; i < smallerFactorAbs; i++) {
            product += biggerFactor;
        }

        if (smallerFactor < 0) {
            return negate(product);
        }
        return product;
    }

    int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException();
        }

        int dividendAbs = abs(dividend);
        int divisorAbs = abs(divisor);

        if (dividendAbs == 0 || dividendAbs < divisorAbs) {
            return 0;
        }

        int quotient = 0;
        while ((multiply(divisorAbs, quotient) + divisorAbs) <= dividendAbs) {
            quotient++;
        }
        if (isNumbersHaveDifferentSigns(dividend, divisor)) {
            quotient = negate(quotient);
        }
        return quotient;
    }

    private boolean isNumbersHaveDifferentSigns(int dividend, int divisor) {
        return (dividend > 0 && divisor < 0)
               || (dividend < 0 && divisor > 0);
    }

    private int negate(int a) {
        int delta = (a > 0) ? -1 : 1;
        int negated = 0;
        while (a != 0) {
            negated += delta;
            a += delta;
        }
        return negated;
    }

    private int abs(int a) {
        return (a < 0) ? negate(a) : a;
    }
}
