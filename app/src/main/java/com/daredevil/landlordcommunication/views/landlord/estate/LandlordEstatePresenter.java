package com.daredevil.landlordcommunication.views.landlord.estate;

import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;

import javax.inject.Inject;

public class LandlordEstatePresenter implements Presenter {
    private View mView;
    private UserDTO userDTO;

    @Inject
    Repository mRepository;

    @Inject
    AsyncRunner asyncRunner;

    @Inject
    LandlordEstatePresenter() {
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void createEstate(Estates estates, String name)  {
        asyncRunner.runInBackground(() -> {
            String result = null;
            try {
                result = mRepository.createEstate(estates, name);
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
