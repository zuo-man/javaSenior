package com.java1;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类(重写了toSting方法)
 *
 *
 * 一：Enum类中常用方法：
 *      values()方法：返回枚举类型的对象数组，该方法可以遍历所有的枚举值
 *      valueOf(String str):可以把一个字符串转为对应的枚举类对象，要求字符串必须是枚举类对象
 *      toString():返回当前枚举类对象常量的名称
 *
 * 二：使用enum关键字定义的枚举类实现接口的情况
 *      1.实现接口，在enum类中实现相同抽象方法
 *      2.让枚举类的对象分别实现接口中的不同抽象方法
 *
 * @create 2021-10-17 13:37
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;

        //toString():
        System.out.println(summer.toString());

        System.out.println("********");

        //values():
        Season1[] S1 = Season1.values();
        for(int i = 0;i < S1.length; i++){
            System.out.println(S1[i]);
            S1[i].show();
        }

        System.out.println("*******");

        //valueOf(String objName):返回与定义名称同名objName对象，若不同名，则抛异常
        Season1 W1 = Season1.valueOf("WINTER");
        System.out.println(W1);
    }
}

//使用enum关键字枚举类
enum Season1 implements Info{//可以继承于接口
    //1.提供当前枚举类的对象，多个对象时间用","隔开，末尾对象";"结束
    SPRING("春天","困"){
        @Override
        public void show(){//实现接口Iofo，重写show方法
            System.out.println("这是春天");
        }
    },
    SUMMER("夏天","倦"){
        @Override
        public void show(){
            System.out.println("这是夏天");
        }
    },
    AUTUMN("秋天","乏"){
        @Override
        public void show(){
            System.out.println("这是秋天");
        }
    },
    WINTER("冬天","眠"){
        @Override
        public void show(){
            System.out.println("这是冬天");
        }
    };

    //2.声明Season对象的属性：private final修饰
    private final String Name;
    private final String Desc;

    //3.私有化类的构造器，并给对象属性赋值    所以不能用构造器造对象，只能调用已有对象
    private Season1(String Name, String Desc){
        this.Name = Name;
        this.Desc = Desc;
    }

    //4.其他诉求：获取枚举类对象的属性、toString方法
    public String getName() {
        return Name;
    }
    public String getDesc() {
        return Desc;
    }
//    @Override
//    public String toString() {
//        return "Season{" +
//                "Name='" + Name + '\'' +
//                ", Desc='" + Desc + '\'' +
//                '}';
//    }

    //每一个对象调用show方法都执行相同代码
//    public void show(){
//        System.out.println("这是一个季节");
//    }
}

interface Info{
    void show();
}
