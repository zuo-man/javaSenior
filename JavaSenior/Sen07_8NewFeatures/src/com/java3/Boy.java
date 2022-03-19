package com.java3;

/**
 * @create 2021-11-02 19:16
 */
public class Boy {
    private Girl girl;

    public Boy() {
    }
    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
