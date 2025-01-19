package org.kaidzen.study.patterns.ratelimiting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeakyBucketRateLimiterTest {

    private LeakyBucketRateLimiter rateLimiter;

    @BeforeEach
    void setUp() {

        rateLimiter = new LeakyBucketRateLimiter(5);
    }

    @Test
    void tryAcquire() {

    }
}