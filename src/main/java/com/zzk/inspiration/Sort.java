package com.zzk.inspiration;

import java.util.Arrays;
import java.util.Random;

/**
 * 十大经典排序
 * https://www.cnblogs.com/guoyaohua/p/8600214.html
 */
public class Sort {

    public static void main(String[] args) {
        long t1 = System.nanoTime();
        int length = 10;
        int[] numbers = new int[length];
        Random random = new Random();
        for(int i=0;i<length;i++){
            numbers[i]=random.nextInt(100);
        }
        long t2 = System.nanoTime();
        print("原始数据",numbers,t1,t2);
        t1=System.nanoTime();
        int[] bubbleSort = bubbleSort(numbers.clone());
        t2=System.nanoTime();
        print("冒泡排序",bubbleSort,t1,t2);
        t1=System.nanoTime();
        int[] selectionSort = selectionSort(numbers.clone());
        t2=System.nanoTime();
        print("选择排序",selectionSort,t1,t2);

        t1=System.nanoTime();
        int[] insertionSort = insertionSort(numbers.clone());
        t2=System.nanoTime();
        print("插入排序",insertionSort,t1,t2);


        t1=System.nanoTime();
        int[] shellSort2 = shellSort(numbers.clone(),2);
        t2=System.nanoTime();
        print("希尔排序2",shellSort2,t1,t2);

        t1=System.nanoTime();
        int[] shellSort3 = shellSort(numbers.clone(),3);
        t2=System.nanoTime();
        print("希尔排序3",shellSort3,t1,t2);

        t1=System.nanoTime();
        int[] shellSort4 = shellSort(numbers.clone(),4);
        t2=System.nanoTime();
        print("希尔排序4",shellSort4,t1,t2);

        t1=System.nanoTime();
        int[] shellSort5 = shellSort(numbers.clone(),5);
        t2=System.nanoTime();
        print("希尔排序5",shellSort5,t1,t2);

        t1=System.nanoTime();
        int[] mergeSort = mergeSort(numbers.clone());
        t2=System.nanoTime();
        print("归并排序",mergeSort,t1,t2);

    }

    private static void print(String name,int[] numbers,long t1,long t2){
        System.out.println(name+"运行耗时:"+(t2-t1));
//        for(int i=0;i<numbers.length;i++){
//            System.out.print("\t"+numbers[i]);
//        }
//        System.out.println();
//        System.out.println("=====================================");
    }


    /**
     * 冒泡排序
     * @param numbers
     * @return
     */
    private static int[] bubbleSort(int[] numbers){
        for(int i=0;i<numbers.length;i++){
            for(int j=0;j<numbers.length-1-i;j++){
                if(numbers[j+1]<numbers[j]){
                    int temp = numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
        return numbers;
    }

    /**
     * 选择排序
     * @param numbers
     * @return
     */
    private static int[] selectionSort(int[] numbers){
        for(int i=0;i<numbers.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[j]<numbers[minIndex]){
                    minIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i]=numbers[minIndex];
            numbers[minIndex]=temp;
        }
        return numbers;
    }

    /**
     * 插入排序
     * @param numbers
     * @return
     */
    private static int[] insertionSort(int[] numbers){

        int current ,preIndex;
        for(int i=1;i<numbers.length;i++){
            current = numbers[i];
            preIndex=i-1;
            while (preIndex>=0 && numbers[preIndex]>current){
                numbers[preIndex+1]=numbers[preIndex];
                preIndex--;
            }
            numbers[preIndex+1] = current;
        }
        return numbers;

    }


    /**
     * 希尔排序
     * @param numbers
     * @param increment 增量
     * @return
     */
    private static int[] shellSort(int[] numbers,int increment){
        int current,preIndex;
        int length = numbers.length;
        int gap = length/increment;
        while(gap>0){
            for(int i = gap; i< length; i++){
                current = numbers[i];
                preIndex=i-gap;
                while (preIndex>=0 && numbers[preIndex]>current){
                    numbers[preIndex+gap]=numbers[preIndex];
                    preIndex = preIndex-gap;
                }
                numbers[preIndex+gap] = current;
            }
            gap = gap/2;
        }
        return numbers;
    }

    /**
     * 归并排序
     * @param numbers
     * @return
     */
    private static int[] mergeSort(int[] numbers){
        int length = numbers.length;
        if(length <2){
            return numbers;
        }
        int splitIndex = length / 2;
        int[] left = Arrays.copyOfRange(numbers, 0, splitIndex);
        int[] right = Arrays.copyOfRange(numbers, splitIndex, length);
        //使用递归从内到外合并
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 归并排序合并两个数组
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;

        int[] result =new int[leftLength + rightLength];
        int leftIndex = 0;
        int rightIndex = 0;

        for(int resultIndex=0;resultIndex<result.length;resultIndex++){
            if(leftIndex>= leftLength){
                result[resultIndex] = right[rightIndex++];
            }else if(rightIndex>= rightLength){
                result[resultIndex] = left[leftIndex++];
            }else {
                int rightValue = right[rightIndex];
                int leftValue = left[leftIndex];
                if (leftValue > rightValue) {
                    result[resultIndex] = rightValue;
                    rightIndex++;
                } else {
                    result[resultIndex] = leftValue;
                    leftIndex++;
                }
            }
        }
        return result;
    }


}
