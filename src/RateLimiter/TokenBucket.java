package RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket implements RateLimiter {
    private int bucketCapacity;
    private int refillTokens;
    private int refillRate;
    private AtomicInteger noOfTokenAvailable;
    private AtomicLong lastRefillTime;
    private AtomicLong nextRefillTime;
    TokenBucket(int bucketCapacity,int refillTokens, int refillRate){
        this.bucketCapacity=bucketCapacity;
        this.refillTokens =refillTokens;
        this.refillRate=refillRate;
        noOfTokenAvailable =new AtomicInteger(bucketCapacity);
        lastRefillTime =new AtomicLong(System.currentTimeMillis());
        nextRefillTime=new AtomicLong(System.currentTimeMillis()+refillRate);
    }

    @Override
    public boolean grantAccess() {
        refillBucket();
        if(noOfTokenAvailable.get()>0){
            noOfTokenAvailable.decrementAndGet();
            return  true;
        }
        return false;
    }

    private void refillBucket() {
        long currentTime=System.currentTimeMillis();
        if(currentTime<nextRefillTime.get())
            return;
        int additionalToken=(int)(currentTime- lastRefillTime.get())/1000* refillTokens;
        int currCapacity= Math.min(noOfTokenAvailable.get()+additionalToken,bucketCapacity);
        noOfTokenAvailable.getAndSet(currCapacity);
        lastRefillTime.getAndSet(currentTime);
        nextRefillTime.getAndSet(currentTime+refillRate);

    }
}
