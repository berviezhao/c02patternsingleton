package com.bervie.pattern;

import com.bervie.pattern.singleton.seriable.SeriableSingleton;

import java.io.*;

/**
 * Created with IntelliJ IDEA
 * Author:Bervie
 * Date:2019-06-04
 */
public class SeriableSingletonTest {
    public static void main(String[] args) {
        SeriableSingleton ls1 = null;
        SeriableSingleton ls2 = SeriableSingleton.getInstance();

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ls2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ls1 = (SeriableSingleton)ois.readObject();
            ois.close();

            System.out.println(ls1);
            System.out.println(ls2);
            System.out.println(ls1==ls2);

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
