package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.dto.MessageDTO;
import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.io.IOException;
import java.util.List;


public class InMemoryRepository implements Repository {

    @Override
    public String addUser(UserDTO user, String type) {
        if (type.equals("Landlord")) {
            return "Landlord";
        }

        if (type.equals("Tenant")) {
            return "Tenant";
        }

        return null;
    }

    @Override
    public UserDTO getByUserNameAndPassword(String userName, String password) {
        if (userName.equals("Jivko")) {
            return new UserDTO("Jivko", "123456",
                    "jivko_hinev90@abv.bg", "1234567890", "Tenant");
        }

        if (userName.equals("Denis")) {
            return new UserDTO("Denis", "123456",
                    "denis@abv.bg", "1234567890", "Landlord");
        }

        return null;
    }

    @Override
    public String createEstate(Estates estates, String name) {
        return null;
    }

    @Override
    public Estates getEstates() {
        return null;
    }

    @Override
    public UserDTO postIdEstate(int id) {
        return null;
    }

    @Override
    public String setDueDate(String dueDate, int id) {
        return null;
    }

    @Override
    public String rateUser(int rating, String name, String userName) {
        return null;
    }

    @Override
    public String setOwed(String price, int id) {
        return null;
    }

    @Override
    public List<Estates> getUnoccupiedEstates() {
        return null;
    }

    @Override
    public UserDTO postIdPerson(int id) {
        return null;
    }

    @Override
    public String rentEstate(String userId, String estateId) {
        return null;
    }

    @Override
    public UserDTO getUserById(int id) {
        if (id == 1) {
            return new UserDTO("Jivko", "123456",
                    "jivko_hinev90@abv.bg", "1234567890", "Tenant");
        }

        if (id == 2) {
            return new UserDTO("Denis", "123456",
                    "denis@abv.bg", "1234567890", "Landlord");
        }

        return null;
    }

    @Override
    public List<Messages> getMessages(int tenantId, int landlordId) {
        return null;
    }

    @Override
    public List<Messages> getNewMessages(int tenantId, int landlordId) {
        return null;
    }

    @Override
    public boolean checkForNewMessages(int senderId, int recipientId) {
        return false;
    }

    @Override
    public boolean checkForMessages(int senderId, int recipientId) {
        return false;
    }

    @Override
    public Messages sendMessage(String message, int senderId, int recipientId) {
        return null;
    }

    @Override
    public String getNotification(String user_name) {
        return null;
    }

    @Override
    public String payRent(String value, int id) {
        return null;
    }

    @Override
    public Estates refreshEstate(int id) {
        return null;
    }

    @Override
    public void sendImageMessage(MessageDTO messageDTO) {

    }

    @Override
    public List<Messages> getMessagesForAdapter(int id) {
        return null;
    }

    @Override
    public String checkForEstateMessage(int id) {
        return null;
    }

    @Override
    public String postEstateMessage(String spinnerMessage, int estateId, int userId) throws IOException {
        return null;
    }


}
