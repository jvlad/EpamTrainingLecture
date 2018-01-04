package com.freeraven.algorithms.codility.dnaquery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

// Performance: 66%
class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        char[] result = new char[P.length];
        Arrays.fill(result, 'Z');

        ArrayList<Integer> listeners = new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> startPointToQueryMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> endPointToQueryMap = new HashMap<>();
         
        for (int queryNumber = 0; queryNumber < P.length; queryNumber++){
            addPoint(startPointToQueryMap, P[queryNumber], queryNumber);
            addPoint(endPointToQueryMap, Q[queryNumber], queryNumber);
        }

        int potentialListeners = Q.length;
        char previousChar = 'Z';
        HashSet<Integer> listeningQueries = new HashSet<>();
        for (int i = 0; i < S.length(); i++){
            if (potentialListeners == 0){
                return convertToInt(result);
            }

            char currentChar = S.charAt(i);
            if(listeningQueries.size() != 0 && (currentChar < previousChar)){
                updateCharResult(result, listeningQueries, currentChar);
            }

            HashSet<Integer> startToListenQueries = startPointToQueryMap.get(i);
            if (startToListenQueries != null){
                updateCharResult(result, startToListenQueries, currentChar);
                listeningQueries.addAll(startToListenQueries);
            }

            HashSet<Integer> finishToListenQueries = endPointToQueryMap.get(i);
            if (finishToListenQueries != null){
                listeningQueries.removeAll(finishToListenQueries);
                potentialListeners -= finishToListenQueries.size();
            } 
            previousChar = currentChar;
        }
        return convertToInt(result);
    }

    private void updateCharResult(char[] arrayToUpdate, HashSet<Integer> indexesToUpdate, char value){
        for (int index : indexesToUpdate){
            if (value < arrayToUpdate[index]){
                arrayToUpdate[index] = value;
            }
        }
    }
    
    private void addPoint(HashMap<Integer, HashSet<Integer>> map,
                          int key, int value){
        if (map.get(key) == null){
            HashSet<Integer> set = new HashSet<>();
            set.add(value);
            map.put(key, set);
        } else {
            map.get(key).add(value);
        }
    }

    private int[] convertToInt(char[] charList){
        int[] result = new int[charList.length];
        for (int i = 0; i < charList.length; i++){
            result[i] = getWeight(charList[i]);
        }
        return result;
    }

    private int getWeight(char c){
        switch (c) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                throw new IllegalArgumentException();
        }
    }
}