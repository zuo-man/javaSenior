package com.java;

/**
 * @create 2021-10-20 16:21
 */
public class Person implements Comparable<Person>{//泛型类型：想比较谁写谁。比较Person
    String name;
    int age;

    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //重写equals方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //指明泛型时写法
    @Override
    public int compareTo(Person o) {//泛型指明了传入形参为Person类型，就不用instanceof和强转了
        //return -this.name.compareTo(o.name);
        int C1 = -this.name.compareTo(o.name);
        if(C1 != 0){//姓名如果不一样，则返回C1姓名
            return C1;
        }else {//姓名如果一样，则比较年龄
            return Integer.compare(this.age,o.age);
        }
    }
    //没有指明泛型写法
    //按照姓名从大到小排列compareTo,年龄从小到大
//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Person){
//            Person P1 = (Person)o;//强转，向下转型
////            return -this.name.compareTo(P1.name);
//            int C1 = -this.name.compareTo(P1.name);
//            if(C1 != 0){//姓名如果不一样，则返回C1姓名
//                return C1;
//            }else {//姓名如果一样，则比较年龄
//                return Integer.compare(this.age,P1.age);
//            }
//        }else {
//            throw new RuntimeException("输入的类型不匹配");
//        }
//    }

}
