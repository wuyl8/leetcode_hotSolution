package testLog4j;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Test;

public class loggerHello {
    @Test
    public void testLogCreate(){
        Logger logger = Logger.getLogger("myLogger");
        logger.removeAllAppenders();
        ConsoleAppender comsoleAppender = new ConsoleAppender(
                new PatternLayout("%p %t %m%n"),
                ConsoleAppender.SYSTEM_OUT
        );
        logger.addAppender(comsoleAppender);
        logger.info("hello");
    }
}
