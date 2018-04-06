package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        return array.stream().filter(this::isAEven).collect(Collectors.toList());
    }

    public List<Integer> filterMultipleOfThree() {
        return array.stream().filter(integer -> integer % 3 == 0).collect(Collectors.toList());
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i : secondList)
            map.merge(i,1,(integer, integer2) -> integer + integer2);
        for (int i : firstList) {
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

    public List<Integer> getDifferentElements() {
        return array.stream().distinct().collect(Collectors.toList());
    }

    private boolean isAEven(Integer integer) {
        return integer % 2 == 0;
    }
}