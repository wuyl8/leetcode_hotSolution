package multiThread;

public class JavaThreadTest1 extends Thread {
    Integer i ;
    public void run(){

        try{
            for(i = 0;i < 10; i++){
                int time = (int)(Math.random() + 1000);
                Thread.sleep(time);
                System.out.println("run="+i+Thread.currentThread().getName());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static class JavaThreadTest2 extends Thread{

        Integer i = 5;
        @Override
        public void run(){
            /*try{*/
            i--;
                System.out.println("run="+i+Thread.currentThread().getName());
            /*}catch(InterruptedException e){
                e.printStackTrace();
            }*/
        }

    }
}
