package testLog4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
import org.junit.Test;

public class logTest {
    private Logger logger;
    @Before
    public void initialize(){
        logger = Logger.getLogger("logger");
        logger.removeAllAppenders();
        Logger.getRootLogger().removeAllAppenders();
    }
    @Test
    public void basicLogger(){
        BasicConfigurator.configure();
        logger.info("basicLogger");
    }

    @Test
    public void addAppenderWithStream(){
        logger.addAppender(new ConsoleAppender(
                new PatternLayout("%p %t %m%n"),
                ConsoleAppender.SYSTEM_OUT
        ));
        logger.info("addAppenderWithStream");
    }
    @Test
    public void addAppenderWithOutStream(){
        logger.addAppender(new ConsoleAppender(
                new PatternLayout("%p %t %m%n")
        ));
        logger.info("addAppenderWithOutStream");
    }
}
