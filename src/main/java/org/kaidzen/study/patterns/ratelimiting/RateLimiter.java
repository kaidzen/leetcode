package org.kaidzen.study.patterns.ratelimiting;

public interface RateLimiter {
        boolean tryAcquire();
}
