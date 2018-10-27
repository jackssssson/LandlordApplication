package com.daredevil.landlordcommunication.async;

import android.os.AsyncTask;

import javax.inject.Inject;

public class AsyncRunnerImpl implements AsyncRunner{

    @Inject
    public AsyncRunnerImpl() {
    }

    @Override
    public void runInBackground(Runnable action) {
        runInBackGroundStatic(action);
    }

    private static void runInBackGroundStatic(Runnable action){
        new AsyncTask<Boolean, Void, Void>(){
            @Override
            protected Void doInBackground(Boolean... booleans) {
                action.run();
                return null;
            }
        }.execute(true);
    }
}
