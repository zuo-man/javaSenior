package com.spring5.aut;

/**
 * @create 2022-02-26 17:22
 */
//员工
public class User {
    private String name;
    private Department dep;

    public void setDep(Department dep) {
        this.dep = dep;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void test(){
        System.out.println(name + ", " + dep);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dep=" + dep +
                '}';
    }
}
