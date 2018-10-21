package com.daredevil.landlordcommunication.async;

public interface AsyncRunner {
    void runInBackground(final Runnable action);
}
