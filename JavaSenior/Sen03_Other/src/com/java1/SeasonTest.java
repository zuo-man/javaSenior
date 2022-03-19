package com.java1;

/**
 * 一、枚举类的使用
 *  1.枚举类的理解：类的对象只有有限个，确定的、我们称此类位枚举类
 *  2.当需要定义一组常量时，强烈建议使用枚举类
 *  3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 * @create 2021-10-17 13:12
 */
public class SeasonTest {
    public static void main(String[] args) {

        Season spring = Season.WINTER;//静态， 类.对象
        System.out.println(spring);
    }
}
//自定义枚举类
class Season{
    //1.声明Season对象的属性：private final修饰
    private final String Name;
    private final String Desc;

    //2.私有化类的构造器，并给对象属性赋值    所以不能用构造器造对象，只能调用已有对象
    private Season(String Name, String Desc){
        this.Name = Name;
        this.Desc = Desc;
    }

    //3.创建当前枚举类的多个对象:public static final
    public static final Season SPRING = new Season("春天","困");
    public static final Season SUMMER = new Season("夏天","倦");
    public static final Season AUTUMN = new Season("秋天","乏");
    public static final Season WINTER = new Season("冬天","眠");



    //4.其他诉求：获取枚举类对象的属性、toString方法
    public String getName() {
        return Name;
    }
    public String getDesc() {
        return Desc;
    }
    @Override
    public String toString() {
        return "Season{" +
                "Name='" + Name + '\'' +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}
