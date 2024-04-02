package RateLimiter;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class UserBucketCreator {
   // private int id;
     ConcurrentHashMap<Integer,TokenBucket> userBuckets;

    UserBucketCreator(int userId){
        userBuckets=new ConcurrentHashMap<>();
        TokenBucket tokenBucket=new TokenBucket(10,10,1000);
        userBuckets.put(userId,tokenBucket);
    }
     void accessApplication(int id){
        if(userBuckets.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName()+"Access Granted");
        }else {
            System.out.println(Thread.currentThread().getName() + "Access Denied. Try Later!!");
        }
    }
}
