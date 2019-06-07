package com.bervie.pattern;

import com.bervie.pattern.singleton.register.EnumSingleton;

import java.io.*;

/**
 * Created with IntelliJ IDEA
 * Author:Bervie
 * Date:2019-06-04
 */
public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton ls1 = null;
        EnumSingleton ls2 = EnumSingleton.getInstance();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ls2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ls1 = (EnumSingleton)ois.readObject();
            ois.close();

            System.out.println(ls1.getData());
            System.out.println(ls2.getData());
            System.out.println(EnumSingleton.getInstance().getData());

            System.out.println(ls1);
            System.out.println(ls2);
            System.out.println(ls1==ls2);

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}