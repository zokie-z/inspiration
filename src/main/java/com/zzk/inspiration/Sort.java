package com.zzk.inspiration;

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


    }

    private static void print(String name,int[] numbers,long t1,long t2){
        System.out.println(name+"运行耗时:"+(t2-t1));
        for(int i=0;i<numbers.length;i++){
            System.out.print("\t"+numbers[i]);
        }
        System.out.println();
        System.out.println("=====================================");
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

    private static int[] insertionSort(int []numbers){
        for(int i=0;i<numbers.length;i++){
            int temp = numbers[i];
            for(int j=i;j>0;j--){
                if(temp>numbers[j]){

                }
//                numbers[j]=numbers[]
            }
        }
        return null;
    }
}
