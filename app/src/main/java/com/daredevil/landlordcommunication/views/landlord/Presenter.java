package com.daredevil.landlordcommunication.views.landlord;

import com.daredevil.landlordcommunication.models.dto.UserDTO;

public interface Presenter {
   void setView(View view);

   void loadUser();

   void setUser(UserDTO user);

}
