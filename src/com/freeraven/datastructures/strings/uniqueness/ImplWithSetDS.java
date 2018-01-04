package com.freeraven.datastructures.strings.uniqueness;

import java.util.HashSet;

/**
 * Created by zvlad on 6/28/16.
 */
public class ImplWithSetDS implements CharactersUniquenessChecker {

    @Override
    public boolean check(String stringToCheck) {
        HashSet<Character> characterSet = new HashSet<>();
        for (Character character : stringToCheck.toCharArray()) {
            characterSet.add(character);
        }
        return characterSet.size() == stringToCheck.length();
    }
}
