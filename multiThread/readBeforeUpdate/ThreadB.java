package multiThread.readBeforeUpdate;

public class ThreadB extends Thread{
    private MyObject myObject;

    public ThreadB(MyObject myObject){
        super();
        this.myObject = myObject;
    }

    public void run(){
        super.run();
        myObject.methodB();
    }
}
