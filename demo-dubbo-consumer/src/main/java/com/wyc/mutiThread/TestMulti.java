package com.wyc.mutiThread;

public class TestMulti {

    public static void main(String[] args){
        Thread t1 = new Thread(){

            @Override
            public void run(){
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1"+Thread.currentThread().getName());
                    System.out.println("2"+this.getName());
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("3"+Thread.currentThread().getName());
                }
            }
        });
        t2.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("4:"+Thread.currentThread().getName());
            }
        }){
            @Override
            public void run() {
                System.out.println("5:"+Thread.currentThread().getName());
            }
        }.start();
    }
}
