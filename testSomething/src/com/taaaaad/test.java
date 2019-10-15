package com.taaaaad;

public class test {

    public static void main(String[] args) {
        String src = "png,123456789";
        System.out.println(src.substring(src.indexOf(',')+1, src.length()));
    }
}
