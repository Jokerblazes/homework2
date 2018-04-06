package com.thoughtworks.collection;


import java.util.*;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<>();
        for (Integer[] integers : array) {
            Collections.addAll(result,integers);
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> list = transformToOneDimesional();
        return list.stream().distinct().collect(Collectors.toList());
    }
}
