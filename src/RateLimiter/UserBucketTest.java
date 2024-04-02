package RateLimiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserBucketTest {
    private UserBucketCreator userBucketCreator;

    @BeforeEach
    void setUp() {
        userBucketCreator = new UserBucketCreator(123);
    }

    @Test
    void testAccessApplication_Granted() {
        userBucketCreator.accessApplication(123);
        assertTrue(userBucketCreator.userBuckets.get(123).grantAccess());
    }

    @Test
    void testAccessApplication_Denied() {
        TokenBucket tokenBucket = userBucketCreator.userBuckets.get(123);
        for (int i = 0; i < 10; i++) {
            tokenBucket.grantAccess();
        }
        userBucketCreator.accessApplication(123);
        assertFalse(tokenBucket.grantAccess());
    }
    @Test
    void testAccessApplication_MultipleUsers() {
        UserBucketCreator userBucketCreator2 = new UserBucketCreator(456);
        assertTrue(userBucketCreator.userBuckets.get(123).grantAccess());
        assertTrue(userBucketCreator2.userBuckets.get(456).grantAccess());

    }
}

