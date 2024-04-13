package com.systemdesign;

public class TokenBucketAlgorithm {
   private long maxBucketSize;
   private long refillRate ; // per second

  private long currentBucketSize;
  private long lastRefillTimeStamp; //time in nano seconds

  public synchronized boolean allowRequest(int requestedTokens){
    refill();

    if(requestedTokens > currentBucketSize)
      return false;
    else
      currentBucketSize -= requestedTokens ;

    return true;
  }

  private void refill(){
    long now = System.nanoTime();
    long timeElapsed = now - lastRefillTimeStamp;
    double tokensToAdd = (timeElapsed/Math.pow(10,9))*(refillRate) ;
    currentBucketSize = Math.min(currentBucketSize+(long) tokensToAdd , maxBucketSize);
    lastRefillTimeStamp =  now;
  }


}
