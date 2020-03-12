package multiThread.readBeforeUpdate;

public class Main {
    public static void main(String[] args){
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        threadA.setName("ThreadA");


        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("ThreadB");

        threadA.start();
        threadB.start();
    }
}
