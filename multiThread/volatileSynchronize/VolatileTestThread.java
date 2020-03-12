package multiThread.volatileSynchronize;

public class VolatileTestThread extends Thread{
    volatile public static int count;
    synchronized private static void addCount(){
        for(int i = 0;i<100;i++){
            count ++;
        }
        System.out.println("count="+count);
    }

    public void run(){
        addCount();
    }
}
