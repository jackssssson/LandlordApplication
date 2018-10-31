package com.daredevil.landlordcommunication.views.tenant.unoccupiedestates;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class TenantUnOccupiedPresenter implements Presenter{

    private View mView;

    @Inject
    Repository mRepository;

    @Inject
    AsyncRunner asyncRunner;

    @Inject
    TenantUnOccupiedPresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void loadAdapter() {
        asyncRunner.runInBackground(() -> {
            try {
                List<Estates> estates = mRepository.getUnoccupiedEstates();
                mView.showAdapter(estates);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
