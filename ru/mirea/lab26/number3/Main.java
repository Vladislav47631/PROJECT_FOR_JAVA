package ru.mirea.lab26.number3;

public class Main {
    public static void main(String[] args)
    {
        Hash hash = new Hash(6);
        hash.Add(6);
        hash.Add(0);
        hash.Add(3);
        hash.Add(1876);
        System.out.println(hash.getElement(4));
        System.out.println(hash.getElement(6));
        hash.Delete(6);
        System.out.println(hash.getElement(6));
    }
}
