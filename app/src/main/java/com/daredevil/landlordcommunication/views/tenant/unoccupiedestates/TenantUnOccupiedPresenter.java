package com.daredevil.landlordcommunication.views.tenant.unoccupiedestates;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class TenantUnOccupiedPresenter implements Presenter{

    private View mView;

    @Inject
    UserService mService;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    TenantUnOccupiedPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void loadAdapter() {
        mAsyncRunner.runInBackground(() -> {
            try {
                List<Estates> estates = mService.getUnoccupiedEstates();
                mView.showAdapter(estates);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
