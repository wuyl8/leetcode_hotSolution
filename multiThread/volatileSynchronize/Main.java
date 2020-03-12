package multiThread.volatileSynchronize;

public class Main {
    public static void main(String[] args){
        VolatileTestThread[] volatileTestThreads = new VolatileTestThread[100];
        for(int i = 0;i<volatileTestThreads.length;i++){
            volatileTestThreads[i] = new VolatileTestThread();
        }
        for (int i = 0;i<volatileTestThreads.length;i++){
            volatileTestThreads[i].start();
        }
    }
}
