package com.freeraven.datastructures.strings.reverse;

/**
 * Created by zvlad on 6/29/16.
 */
public class ReverseImpl implements StringReverse {
    @Override
    public String reverse(String string) {
        StringBuilder builder = new StringBuilder(string);
        for (int leftEnd = 0, rightEnd = string.length() - 1;
             leftEnd < string.length() / 2;
             leftEnd++, rightEnd--) {

            swap(builder, leftEnd, rightEnd);
        }
        return builder.toString();
    }

    private void swap(StringBuilder builder, int leftEnd, int rightEnd) {
        char leftEndChar = builder.charAt(leftEnd);
        char rightEndChar = builder.charAt(rightEnd);
        if (leftEndChar == rightEndChar){
            return;
        }

        builder.setCharAt(leftEnd, rightEndChar);
        builder.setCharAt(rightEnd, leftEndChar);
    }
}
