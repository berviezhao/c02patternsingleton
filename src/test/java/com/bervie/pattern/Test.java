package com.bervie.pattern;

/**
 * Created with IntelliJ IDEA
 *
 * @author Bervie
 * @date 2019/06/07
 */
public class Test {
    public static void main(String[] args) {
        print1();
    }
    private static void print1(){
        int count =0;
        for (int i=0;i<100;i++){
            count=count++;
        }
        System.out.println("count:"+count);
        for (int i=0;i<100;i++){
            count=++count;
        }
        System.out.println("count:"+count);
    }
}
