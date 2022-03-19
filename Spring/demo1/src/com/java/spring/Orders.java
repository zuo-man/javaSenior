package com.java.spring;

/**
 *  使用有参数构造注入
 */
public class Orders {

    private String oname;
    private String address;

    //有参数构造器
    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public void ordersTest(){
        System.out.println(oname+ " , " + address);
    }
}
