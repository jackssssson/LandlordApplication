package com.daredevil.landlordcommunication.repositories;

import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.dto.MessageDTO;
import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.util.Arrays;
import java.util.List;


public class InMemoryRepository implements Repository {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private List<Estates> estates = Arrays.asList(
            new Estates(ONE, "Jivko`s", true, 2000,
                    "Zaharii Zograf", "12-12-2012"),

            new Estates(2, "Denis`s", false, 3000,
                    "Studentski grad", "11-11-2011")
    );

    private List<UserDTO> users = Arrays.asList(
            new UserDTO(ONE, estates, "Jivko", "123456",
                    "jivko_hinev90@abv.bg", "1234567890",
                    "Tenant", "5"),

            new UserDTO(2, estates, "Denis", "123456",
                    "denis@abv.bg", "1234567890",
                    "Landlord", "5")
    );

    private List<Messages> messages = Arrays.asList(
            new Messages("Hello", "Text", "Timestamp",
                    users.get(ZERO), "ImageMessage"),

            new Messages("Hi", "Image", "Timestamp",
                    users.get(ONE), "ImageMessage")
    );

    @Override
    public String addUser(UserDTO user, String type) {
        if (user.equals(users.get(ZERO)) && type.equals(users.get(ZERO).getType())) {
            return users.get(ZERO).getType();
        }

        return null;
    }

    @Override
    public UserDTO getByUserNameAndPassword(String userName, String password) {
        if (userName.equals(users.get(ZERO).getUserName())
                && password.equals(users.get(ZERO).getUserPassword())) {
            return users.get(ZERO);
        }

        return null;
    }

    @Override
    public String createEstate(Estates estate, String name) {
        if (estate.equals(estates.get(ZERO)) &&
                name.equals(estates.get(ZERO).getEstateName())) {
            return estates.get(ZERO).getEstateName();
        }

        return null;
    }

    @Override
    public Estates getEstates() {
        return estates.get(ZERO);
    }

    @Override
    public UserDTO postIdEstate(int id) {
        if (id == users.get(ZERO).getUserid()) {
            return users.get(ZERO);
        }

        return null;
    }

    @Override
    public String setDueDate(String dueDate, int id) {
        if (dueDate.equals(estates.get(ZERO).getDuedate())
                && id == users.get(ZERO).getUserid()) {
            return estates.get(ZERO).getDuedate();
        }

        return null;
    }

    @Override
    public String rateUser(int rating, String name, String userName) {
        if (rating == Integer.parseInt(users.get(ZERO).getUserRating())
                && name.equals(users.get(ZERO).getUserName())
                && userName.equals(users.get(ZERO).getUserName())) {
            return users.get(ZERO).getUserName();
        }

        return null;
    }

    @Override
    public String setOwed(String price, int id) {
        if (String.valueOf(estates.get(ZERO).getPrice()).equals(price)
                && id == users.get(ZERO).getUserid()) {
            return users.get(ZERO).getUserName();
        }

        return null;
    }

    @Override
    public List<Estates> getUnoccupiedEstates() {
        return estates;
    }

    @Override
    public UserDTO postIdPerson(int id) {
        if (id == users.get(ZERO).getUserid()) {
            return users.get(ZERO);
        }

        return null;
    }

    @Override
    public String rentEstate(String userId, String estateId) {
        if (Integer.parseInt(userId) == users.get(ZERO).getUserid()
                && Integer.parseInt(estateId) == estates.get(ZERO).getEstateid()) {
            return userId + estateId;
        }

        return null;
    }

    @Override
    public UserDTO getUserById(int id) {
        if (id == users.get(ZERO).getUserid()) {
            return users.get(ZERO);
        }
        return null;
    }

    @Override
    public List<Messages> getMessages(int tenantId, int landlordId) {
        if (users.get(ZERO).getUserid() == tenantId
                && users.get(ONE).getUserid() == landlordId) {
            return messages;
        }

        return null;
    }

    @Override
    public List<Messages> getNewMessages(int tenantId, int landlordId) {
        if (users.get(ZERO).getUserid() == tenantId
                && users.get(ONE).getUserid() == landlordId) {
            return messages;
        }

        return null;
    }

    @Override
    public boolean checkForNewMessages(int senderId, int recipientId) {
        return users.get(ZERO).getUserid() == senderId
                && users.get(ONE).getUserid() == recipientId;

    }

    @Override
    public boolean checkForMessages(int senderId, int recipientId) {
        return users.get(ZERO).getUserid() == senderId
                && users.get(ONE).getUserid() == recipientId;
    }

    @Override
    public Messages sendMessage(String message, int senderId, int recipientId) {
        if (message.equals(messages.get(ZERO).getTextMessage())
                && users.get(ZERO).getUserid() == senderId
                && users.get(ONE).getUserid() == recipientId) {
            return messages.get(ZERO);
        }

        return null;
    }

    @Override
    public String getNotification(String user_name) {
        if (users.get(ZERO).getUserName().equals(user_name)){
            return user_name;
        }

        return null;
    }

    @Override
    public String payRent(String value, int id) {
        if (String.valueOf(estates.get(ZERO).getPrice()).equals(value)
                && estates.get(ZERO).getEstateid() == id){
            return value;
        }

        return null;
    }

    @Override
    public Estates refreshEstate(int id) {
        if (estates.get(ZERO).getEstateid() == id){
            return estates.get(ZERO);
        }

        return null;
    }

    @Override
    public void sendImageMessage(MessageDTO messageDTO) {

    }

    @Override
    public List<Messages> getMessagesForAdapter(int id) {
        if (users.get(ZERO).getUserid() == id){
            return messages;
        }

        return null;
    }

    @Override
    public String checkForEstateMessage(int id) {
        if (users.get(ZERO).getUserid() == id){
            return Integer.toString(id);
        }

        return null;
    }

    @Override
    public String postEstateMessage(String spinnerMessage, int estateId, int userId) {
        if (spinnerMessage.equals(messages.get(ZERO).getTextMessage())
                && estateId == estates.get(ZERO).getEstateid()
                && userId == users.get(ZERO).getUserid()){
            return spinnerMessage;
        }

        return null;
    }


}
