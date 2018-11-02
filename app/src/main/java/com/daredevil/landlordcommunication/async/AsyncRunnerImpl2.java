package com.daredevil.landlordcommunication.async;

import android.os.AsyncTask;

public class AsyncRunnerImpl2 implements AsyncRunner {
    @Override
    public void runInBackground(Runnable action) {
        runInBackgroundStatic(action);
    }

    private static void runInBackgroundStatic(Runnable action) {
        new AsyncTask<Boolean, Void, Void>() {
            @Override
            protected Void doInBackground(Boolean... booleans) {
                action.run();
                return null;
            }
        }.execute(true);
    }
}
