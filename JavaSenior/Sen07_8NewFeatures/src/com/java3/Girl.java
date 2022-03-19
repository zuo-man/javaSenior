package com.java3;

/**
 * @create 2021-11-02 19:16
 */
public class Girl {
    private String name;

    public Girl() {
    }
    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }

}
