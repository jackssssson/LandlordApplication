package com.daredevil.landlordcommunication.views.landlord.estate;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.IOException;

import javax.inject.Inject;

public class LandlordEstatePresenter implements Presenter {
    private View mView;

    @Inject
    UserService mService;

    @Inject
    AsyncRunner mAsyncRunner;

    @Inject
    LandlordEstatePresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void createEstate(Estates estates, String name)  {
        mAsyncRunner.runInBackground(() -> {
            String result = null;
            try {
                result = mService.createEstate(estates, name);
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert result != null;
            if (result.equals("Estate created.")){
                mView.showEstateCreated();
            } else {
                mView.showErrorMessage(result);
            }
        });
    }
}
