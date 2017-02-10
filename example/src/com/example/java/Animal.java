package com.example.java;

import java.util.List;

/**
 * Created by suxin on 17-2-10.
 */
public class Animal<T> {

    public <U extends T> U test(Animal<? super T> t,U s)  {
        return s;
    }

    public static void main(String[] args) {

        Animal<? super Bird0> an = new Animal<Animal>();
    }
}

class Bird extends Bird0 {

}

class Bird0 extends Animal {

}
