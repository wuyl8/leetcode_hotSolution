package multiThread.readBeforeUpdate;

public class MyObject {
    synchronized protected void methodA(){
        try{
            System.out.println("begin methodA threadName="+ Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end Time=" + System.currentTimeMillis());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    synchronized protected void methodB(){
        try{
            System.out.println("begin methodB threadName="+ Thread.currentThread().getName() +"begin Time=" +
                    System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
