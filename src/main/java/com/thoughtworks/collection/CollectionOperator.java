package com.thoughtworks.collection;


import java.util.*;

public class CollectionOperator {

    public List<Integer> getListByInterval(int left, int right) {
        return getIntegers(left, right,false);
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getIntegers(left, right, true);
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> result = new ArrayList<>();
        for (int i : array) {
            if (isAEven(i))
                result.add(i);
        }
        return result;
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i : firstArray)
            map.merge(i,1,(integer, integer2) -> integer + integer2);
        for (int i : secondArray) {
            Integer integer = map.get(i);
            if (integer != null) {
                if (integer == 0)
                    map.remove(i);
                else
                    map.put(i,integer - 1);
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<>();
        Collections.addAll(set, firstArray);
        Collections.addAll(set, secondArray);
        result.addAll(set);
        return result;
    }

    private boolean isAEven(int i) {
        return i % 2 == 0;
    }

    private List<Integer> getIntegers(int left, int right,boolean needEven) {
        List<Integer> result = new ArrayList<>();
        if (left > right) {
            for (int i = left; i >= right ; i--) {
                if (!needEven || isAEven(i))
                    result.add(i);
            }
        } else {
            for (int i = left; i <= right ; i++) {
                if (!needEven || isAEven(i))
                    result.add(i);
            }
        }
        return result;
    }
}
