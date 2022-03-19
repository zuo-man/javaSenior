package com.exer;

import java.io.Serializable;

/**
 * @create 2021-10-30 10:49
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("呼吸");
    }

    public void set(){
        System.out.println("吃饭");
    }
}
