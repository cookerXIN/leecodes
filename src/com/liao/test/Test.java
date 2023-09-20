package com.liao.test;

class Parent{
    static int age=30;
    public Parent(){
        age = 40;
        System.out.println(age);
    }
    {
        System.out.println(50);
    }
    static{
        System.out.println(age);
    }
}
class Children extends Parent{
    static int h = 60;
    static{
        System.out.println(h);
    }
}
public class Test{
    public static void main(String[] args){
        Children c = new Children();
    }
}