package multiThread;

public class NullFore {
    private volatile static boolean flag = false;
    private static int cnt = 0;
    public static void main(String[] argv) throws Exception{
        new Thread(() -> {
            while (!flag) {
                try {
                    //Thread.sleep(2000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //System.out.println(cnt);
            }
            System.out.println("----a end"+cnt);
        }).start();
        Thread.sleep(1000L);
        new Thread(() -> refresh()).start();

    }
    private static void refresh() {
        System.out.println("--stat");
        flag = true;
        cnt = 3;
        System.out.println("---end");
    }
}
