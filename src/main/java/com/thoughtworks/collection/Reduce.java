package com.thoughtworks.collection;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Comparator.comparingInt(a -> a)).get();
    }

    public double getMinimum() {
        return arrayList.stream().min(Comparator.comparingInt(a -> a)).get();
    }

    public double getAverage() {
        int sum = 0;
        for (Integer integer : arrayList) {
            sum += integer;
        }
        return (double) sum / arrayList.size();
    }

    public double getOrderedMedian() {
        List<Integer> collect = arrayList.stream().sorted().collect(Collectors.toList());
        int size = collect.size();
        int index = size / 2;
        if (isAEven(size)) {
            return (double) (collect.get(index - 1) + collect.get(index)) / 2;
        } else {
            return (double) collect.get(index);
        }
    }

    public int getFirstEven() {
        return getIndexOfFirstEvenOrFirstEven(false);
    }

    public int getIndexOfFirstEven() {
        return getIndexOfFirstEvenOrFirstEven(true);
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (arrayList.equals(this.arrayList))
            return true;
        return false;
    }

    //实现接口SingleLink，然后再此函数内使用

    public Double getMedianInLinkList(SingleLink singleLink) {
        singleLink.addHeadPointer(arrayList.get(0));
        for (Integer integer : arrayList) {
            singleLink.addTailPointer(integer);
        }
        int size = arrayList.size();
        int index = size / 2;
        if (isAEven(size)) {
            return (double) ((Integer)singleLink.getNode(index + 1) + (Integer) singleLink.getNode(index)) / 2;
        } else {
            return (double) singleLink.getNode(index);
        }
    }
    public int getLastOdd() {
        return getIndexOfLastOddOrLastOdd(false);
    }

    public int getIndexOfLastOdd() {
        return getIndexOfLastOddOrLastOdd(true);
    }

    private boolean isAEven(int size) {
        return size % 2 == 0;
    }

    private int getIndexOfFirstEvenOrFirstEven(boolean isIndex) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (isAEven(arrayList.get(i))) {
                return isIndex ? i : arrayList.get(i);
            }
        }
        return -1;
    }

    private int getIndexOfLastOddOrLastOdd(boolean isIndex) {
        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            if (!isAEven(arrayList.get(i)))
                return isIndex == true ? i : arrayList.get(i);
        }
        return -1;
    }
}
