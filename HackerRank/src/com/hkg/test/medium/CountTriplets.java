package com.hkg.test.medium;

import java.util.*;

public class CountTriplets {

    public static void main(String[] args) {


    }

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        int tripletCount =0;

        Map<Integer, List<Integer>> valuesMap = new LinkedHashMap<>();

        for (int i=0; i < arr.size(); i++){

            if (valuesMap.containsKey(arr.get(i))){
                valuesMap.get(arr.get(i)).add(i);
            }else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
            }

        }

        for (Map.Entry<String,List<Integer>> entry : valuesMap.entrySet())

            return  tripletCount;

    }
}
