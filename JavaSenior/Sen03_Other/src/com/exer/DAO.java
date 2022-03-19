package com.exer;

import java.util.*;

/**
 * @create 2021-10-22 19:03
 */
public class DAO<T> { //本题T 就是User类型
    private Map<String,T> t = new HashMap<String,T>();

    //保存T类型的对象到Map成员变量中
    public void save(String id,T data){
        t.put(id,data);
    }
    //从t 中获取id对应的对象
    public T get(String id){
        return t.get(id);
    }
    //修改
    //替换t 中key为id的内容，改为data对象
    public void update(String id,T data){//如果传入数据id相对应，则执行
        if(t.containsKey(id)){
            t.put(id,data);
        }
    }
    //返回t 中存放的所有T 对象
    public List<T> list(){
        ArrayList<T> l1 = new ArrayList<>();
        Collection<T> value = t.values();
        for(T t : value){
            l1.add(t);
        }
        return l1;
    }
    //删除指定id对象
    public void delete(String id){
        t.remove(id);
    }
}
