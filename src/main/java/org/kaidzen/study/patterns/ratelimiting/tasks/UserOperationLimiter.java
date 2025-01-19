package org.kaidzen.study.patterns.ratelimiting.tasks;

import java.util.List;

/**
 * Service, that will verify if user allowed to perfor operation, based on the limits.
 */
public class UserOperationLimiter {

    private final List<User> users;
    private final Long readLimitPerMinute;
    private final Long writeLimitPerMinute;

    public UserOperationLimiter(List<User> users, Long readLimitPerMinute, Long writeLimitPerMinute) {
        this.users = users;
        this.readLimitPerMinute = readLimitPerMinute;
        this.writeLimitPerMinute = writeLimitPerMinute;
    }

     public boolean isUserAllowedToPerform(Operation operation) {
        //TODO
         return false;
    }

    public boolean processAllowed(Operation operation) {
        //TODO
        return false;
    }
}
class User {
}

class Operation {
}
