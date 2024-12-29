package com.ocean;

import java.io.IOException;

public class addressImpl implements address{

    int address;
    public addressImpl(){
        System.out.println("add构造函数");
    }
    @Override
    public void setAddress(int address) throws IOException {
        this.address = address;
        System.out.println("set方法");
    }

    @Override
    public int getAddress() {
        System.out.println("get 方法");
        return address;
    }
}
