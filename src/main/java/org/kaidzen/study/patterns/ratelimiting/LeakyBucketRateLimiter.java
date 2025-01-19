package org.kaidzen.study.patterns.ratelimiting;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The leaky bucket algorithm metaphorically allows requests to drip out of a bucket at a constant rate.
 * If the bucket (buffer) overflows, new requests are discarded
 * <p>
 * Pros:
 * - Smooths Bursts: Effectively smoothens out bursts of traffic over time, allowing for handling sudden spikes more gracefully.
 * - Consistent Output Rate: Ensures that the data processing occurs at a steady rate.
 * <p>
 * Cons:
 * - Potentially Delaying: Can introduce delays in processing if the bucket is consistently full, leading to a queue of requests.
 * - Less Reactive: Not as responsive to changes in incoming traffic patterns due to its smoothing nature.
 */
public class LeakyBucketRateLimiter implements RateLimiter {

    /*
     * The maximum capacity of the bucket. Once water reaches this level, further requests are rejected.
     */
    private final long threshold;

    /*
     * Time units for measuring the leak rate.
     */
    private long windowUnit;

    /*
     * Current level of water in the bucket, managed atomically to ensure thread safety.
     */
    private final AtomicLong water = new AtomicLong(0L);

    /*
     * Timestamp of the last leak calculation, used to determine how much water has leaked over time.
     */
    private volatile long lastLeakTimestamp;

    /**
     * Construct LeakyBucketRateLimiter with specified threshold,
     * default windowUnit is 1000 (1 second).
     *
     * @param threshold for created LeakyBucketRateLimiter.
     */
    public LeakyBucketRateLimiter(long threshold) {
        this.threshold = threshold;
        this.windowUnit = 1000L;
        this.lastLeakTimestamp = Instant.now().toEpochMilli();
    }

    /**
     * Tries to acquire a permit for a request based on the current state of the bucket.
     *
     * @return true if the request can be accommodated (water level is below threshold), false otherwise.
     */
    @Override
    public boolean tryAcquire() {
        long currentTime = Instant.now().toEpochMilli();
        // Calculate the amount of water that has leaked since the last check.
        long leakedAmount = ((currentTime - lastLeakTimestamp) / windowUnit) * threshold;

        // If any water has leaked, reduce the water level accordingly.
        if (leakedAmount > 0) {
            this.water.addAndGet(-leakedAmount);
            this.lastLeakTimestamp = currentTime;
        }
        // Ensure, the water level does not go below zero.
        if (water.get() < 0) {
            this.water.set(0);
        }

        // If the bucket is not full, increment the water level and allow the request.
        if (water.get() < threshold) {
            water.getAndIncrement();
            return true;
        }

        //Bucket is full, rejected
        return false;
    }
}
