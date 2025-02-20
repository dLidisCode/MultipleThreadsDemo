package org.example;

public class Main {
    public static void main(String[] args){

        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        Thread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();

    }
}
class Countdown {
    public void doCountdown(){

        String color;

        switch(Thread.currentThread().getName()){
            case "Thread 1" :
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2" :
                color = ThreadColor.ANSI_PURPLE;
                break;
            default: color = ThreadColor.ANSI_GREEN;
        }

        for(int i=10; i > 0 ;i--){
            System.out.println(color + Thread.currentThread().getName() +" i= "+i);
        }
    }
}

class CountdownThread extends Thread{
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown){
        threadCountdown = countdown;
    }

    public void run(){
        threadCountdown.doCountdown();

    }
}
