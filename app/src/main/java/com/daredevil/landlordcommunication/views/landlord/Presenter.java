package com.daredevil.landlordcommunication.views.landlord;

import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.util.List;

public interface Presenter {
   void setView(View view);

   void loadUser();

   void setUser(UserDTO user);

   void loadEstates();

   void setEstates(List<Estates> estates);
}
