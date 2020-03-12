package multiThread.ThreadUseJoin;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyThread {
    public void useTimer(){
        Timer timer = new Timer(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("完成");
            }
        };

        timer.schedule(task,new Date());
    }
}
