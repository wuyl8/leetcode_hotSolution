package multiThread.readBeforeUpdate;

public class ThreadA extends Thread{
    private MyObject myObject;

    public ThreadA(MyObject myObject){
        super();
        this.myObject = myObject;
    }

    public void run(){
        super.run();
        myObject.methodA();
    }
}
