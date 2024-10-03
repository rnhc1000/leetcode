package ferreiras.leetcode;


import org.apache.commons.lang3.time.StopWatch;

import static java.lang.Thread.sleep;

public class ConcurrencyUtils {
  public static StopWatch stopWatch = new StopWatch();

  public static void log(String message){

    System.out.println("[" + Thread.currentThread().getName() +"] - " + message);

  }
  public static void delays(long delayMilliSeconds)  {
    try{
      sleep(delayMilliSeconds);
    }catch (Exception e){
      log("Exception is :" + e.getMessage());
    }

  }

  public static void delay(long delayMilliSeconds)  {
    try{
      sleep(delayMilliSeconds);
    }catch (Exception e){
      log("Exception is :" + e.getMessage());
    }

  }
  public static String transForm(String s) {
    delay(500);
    return s.toUpperCase();
  }

  public static void startTimer(){

    stopWatch.start();
  }

  public static void timeTaken(){
    stopWatch.stop();
    log("Total Time Taken : " + stopWatch.getTime() + " ms");
    stopWatchReset();
  }

  public static void stopWatchReset(){

    stopWatch.reset();
  }

  public static  int noOfCores(){

    return Runtime.getRuntime().availableProcessors();
  }
}

