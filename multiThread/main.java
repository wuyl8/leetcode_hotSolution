package multiThread;

public class main {
    public static void main(String[] args){
        /*ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        threadPoolExecutor.get*/
        JavaThreadTest1.JavaThreadTest2 test = new JavaThreadTest1.JavaThreadTest2();
        for(int i=0;i<5;i++){
            Thread thread = new Thread(test);
            test.setName("test"+i);

            int time = (int)(Math.random() + 1000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            thread.start();
        }
       /* multiThread.JavaThreadTest1.JavaThreadTest2 test1 = new multiThread.JavaThreadTest1.JavaThreadTest2();
        test1.setName("test1");
        test1.start();

        multiThread.JavaThreadTest1.JavaThreadTest2 test2  = new multiThread.JavaThreadTest1.JavaThreadTest2();
        test2.setName("test2");
        test2.start();*/
    }
}
