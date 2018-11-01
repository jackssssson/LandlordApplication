package com.daredevil.landlordcommunication.views.tenant.estate;

public interface View {
   void setPresenter(Presenter presenter);

   void showUserInfo(String name, String email, String rating, String price, String address);

   void showMessage(String message);
}
