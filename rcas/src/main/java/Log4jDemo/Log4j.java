package Log4jDemo;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {
	
	static Logger logger = LogManager.getLogger(Log4j.class);
	
	public static void main(String[] args) {
		
	System.out.println("log4j file document");
	logger.info("this info");
    logger.warn("this is warn message");
    logger.error("this is error message");
    
    System.out.println("completed");
    
	}

}
