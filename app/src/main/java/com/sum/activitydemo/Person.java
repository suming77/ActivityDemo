package com.sum.activitydemo;

import java.io.Serializable;

/**
 * 传递的数据，需要序列化，Serializable, Parcelable 都可以
 */
public class Person implements Serializable{
    public String name;

    public Person(String name) {
        this.name = name;
    }
}
