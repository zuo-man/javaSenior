package com.java2;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和 BigDecimal
 *
 * @create 2021-10-16 13:49
 */
public class OtherClassTest {
    @Test
    public void test1(){
        String javaversion = System.getProperty("java.version");//java的版本
        System.out.println("java的version:"+javaversion);

        String javaHome = System.getProperty("java.home");//java的文件路径
        System.out.println("java的home:"+ javaHome);

        String osName = System.getProperty("os.name");//系统的名称
        System.out.println("os的name:"+ osName);

        String osVersion = System.getProperty("os.version");//系统的版本
        System.out.println("os的version:"+ osVersion);

        String userName = System.getProperty("user.name");//系统的用户名
        System.out.println("user的name:"+ userName);

        String userHome = System.getProperty("user.home");//系统当前的路径
        System.out.println("user的home:"+ userHome);

        String userDir = System.getProperty("user.dir");//当前dir
        System.out.println("user的dir:"+userDir);
    }

    /*
                            Math类
    java.lang.Math提供了一系列静态方法用于科学计算。其方法的参数和返回值类型一般为double型。
    abs 绝对值
    acos,asin,atan,cos,sin,tan 三角函数
    sqrt 平方根
    pow(doubleadoble b) a的b次幂
    log 自然对数
    exp e为底指数
    max(double adouble b)
    min(double a,double b)
    random() 返回0.0到1.0的随机数
    long round(double a) double型数据a转换为long型（四舍五入）toDegrees(double angrad) 弧度—>角度
    toRadians(double angdeg) 角度—>弧度
     */





    /*
                    BigInteger类常用方法
    java.math包的Biglnteger可以表示不可变的任意精度的整数。
    Biglnteger提供所有Java 的基本整数操作符的对应物，并提供java.lang.Math的所有相关方法。
    另外，Biglnteger还提供以下运算：模算术、GCD计算、质数测试、素数生成、位操作以及一些其他操作。
    构造器BigInteger(String val)：根据字符串构建Biglnteger对象


    public Biglnteger abs()：返回此 Biglnteger的绝对值的Biglnteger。
    Biglnteger add(Biglnteger val):返回其值为(this + val)的Biglnteger
    Biglnteger subtract(Biglnteger val):返回其值为(this-val)的Biglnteger
    BigInteger multiply(Biglnteger val):返回其值为(this*val)的Biglnteger
    BigInteger divide(Biglnteger val):返回其值为(this/val)的Biglnteger。整数相除只保留整数部分。
    Biglnteger remainder(Biglnteger val)：返回其值为(this % val)的Biglnteger。
    BigInteger divideAndRemainder(Biglnteger val):返回包含(this/val)后跟(this % val)的两个Biglnteger的数组。
    Biglnteger pow(int exponent):返回其值为(thisexponent)的Biglnteger。
     */




    /*
                         BigDecimal类常用方法
    一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中，要求数字精度比较高，
    故用到java.math.BigDecimal类。
    BigDecimal类支持不可变的、任意精度的有符号十进制定点数。
    构造器
    public BigDecimal(double val)
    public BigDecimal(String val)
    常用方法
    public BigDecimal add(BigDecimal augend)
    public BigDecimal subtract(BigDecimal subtrahend)
    public BigDecimal multiply(BigDecimal multiplicand)
    public BigDecimal divide(BigDecimal divisor, int scale,int roundingMode)
     */
    @Test
    public void test2() {
        BigInteger bi = new BigInteger("1243324112132156653");
        BigDecimal bd = new BigDecimal("12334.123");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        // System.out.println(bd.divide(bd2));//没有指定位数，除不尽的话报错
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));//bd除于bd2,然后四舍五入
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));//保留15位小数
    }
}
