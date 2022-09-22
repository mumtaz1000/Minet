package com.minet.utils;

public class ExceptionThreadHandling implements Runnable{

    public void run(){
        throw new IndexOutOfBoundsException();
    }

}
