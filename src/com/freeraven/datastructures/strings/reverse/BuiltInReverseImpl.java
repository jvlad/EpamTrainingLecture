package com.freeraven.datastructures.strings.reverse;

/**
 * Created by zvlad on 6/29/16.
 */
public class BuiltInReverseImpl implements StringReverse {
    @Override
    public String reverse(String string) {
        StringBuilder builder = new StringBuilder(string);
        return builder.reverse().toString();
    }
}
