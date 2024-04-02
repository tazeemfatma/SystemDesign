package RateLimiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenBucketTest {
    private TokenBucket tokenBucket;

    @BeforeEach
    void setUp() {
        tokenBucket = new TokenBucket(10, 10, 1000);
    }

    @Test
    void testGrantAccess_TokensAvailable() {
        assertTrue(tokenBucket.grantAccess());
    }

    @Test
    void testGrantAccess_TokensExhausted() {
        // Consume all tokens
        for (int i = 0; i < 10; i++) {
            tokenBucket.grantAccess();
        }
        assertFalse(tokenBucket.grantAccess());
    }
    @Test
    void testRefillBucket() {
        // Wait for refill
        try {
            Thread.sleep(1100); // Wait for more than refillRate (1000 ms)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(tokenBucket.grantAccess()); // Tokens should be refilled
    }
}


