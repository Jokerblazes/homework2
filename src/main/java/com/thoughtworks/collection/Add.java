package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Add {

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        return getSumOfEvenOrOdd(leftBorder,rightBorder, true);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        return getSumOfEvenOrOdd(leftBorder, rightBorder, false);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return getSum(arrayList, 3, 2);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (Integer integer : arrayList) {
            if (!isAEven(integer)) {
                integer = (getIncrease(integer, 3, 2));
            }
            result.add(integer);
        }
        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        List<Integer> collect = arrayList.stream().filter(integer -> !isAEven(integer)).collect(Collectors.toList());
        return getSum(collect, 3, 5);
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> collect = arrayList.stream().filter(this::isAEven)
                .sorted().collect(Collectors.toList());
        int size = collect.size();
        if (isAEven(size)) {
            int mid = size / 2;
            return (double) (collect.get(mid) + collect.get(mid - 1)) / 2;
        } else {
            return collect.get(size / 2);
        }
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer> collect = arrayList.stream().filter(this::isAEven)
                .collect(Collectors.toList());
        int sum = getSum(collect, 1, 0);
        return (double) sum / collect.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        if (specialElment % 2 != 0)
            return false;
        long count = arrayList.stream().filter(integer -> Objects.equals(integer, specialElment)).count();
        return count != 0;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(this::isAEven)
                .distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenCollect = arrayList.stream().filter(this::isAEven).sorted().collect(Collectors.toList());
        List<Integer> oddCollect = arrayList.stream().filter(integer -> !isAEven(integer)).sorted((a, b) -> b - a).collect(Collectors.toList());
        evenCollect.addAll(oddCollect);
        return evenCollect;
    }


    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>(arrayList.size() - 1);
        for (int i = 1; i < arrayList.size(); i++) {
            int calNum = getIncrease((arrayList.get(i - 1) + arrayList.get(i)),3,0);
            result.add(calNum);
        }
        return result;
    }


    private boolean isAEven(int i) {
        return i % 2 == 0;
    }

    private int getIncrease(Integer integer, int multiple, int addNum) {
        return integer * multiple + addNum;
    }

    private int getSumOfEvenOrOdd(int leftBorder, int rightBorder, boolean isEven) {
        int result = 0;
        int start = Math.min(leftBorder, rightBorder);
        int end = Math.max(leftBorder, rightBorder);
        for (int i = start; i <= end; i++) {
            if (isEven && isAEven(i))
                result += i;
            else if (!isEven && !isAEven(i))
                result += i;
        }
        return result;
    }


    private int getSum(List<Integer> arrayList, int multiple, int addNum) {
        int result = 0;
        for (Integer integer : arrayList) {
            result += getIncrease(integer, multiple, addNum);
        }
        return result;
    }
}
