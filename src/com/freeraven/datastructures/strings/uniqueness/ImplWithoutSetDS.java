package com.freeraven.datastructures.strings.uniqueness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zvlad on 6/28/16.
 */
public class ImplWithoutSetDS implements CharactersUniquenessChecker {

    @Override
    public boolean check(String stringToCheck) {
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < stringToCheck.length(); i++) {
            charList.add(stringToCheck.charAt(i));
        }

        charList.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Character) o1) - ((Character) o2);
            }
        });

        for (int i = 0; i < charList.size() - 1; i++) {
            if (charList.get(i).equals(charList.get(i + 1))){
                return false;
            };
        }
        return true;
    }
}
