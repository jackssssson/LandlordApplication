package com.daredevil.landlordcommunication.servieces;

import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.dto.MessageDTO;
import com.daredevil.landlordcommunication.models.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface UserService {
    String addUser(UserDTO user, String type) throws IOException;

    UserDTO getByUserNameAndPassword(String userName, String password) throws IOException;

    String createEstate(Estates estates, String name) throws IOException;

    Estates getEstates() throws IOException;

    UserDTO postIdEstate(int id) throws IOException;

    String setDueDate(String dueDate, int id) throws IOException;

    String rateUser(int rating, String name, String userName) throws IOException;

    String setOwed(String price, int id) throws IOException;

    List<Estates> getUnoccupiedEstates() throws IOException;

    UserDTO postIdPerson(int id) throws IOException;

    String rentEstate(String userId, String estateId) throws IOException;

    UserDTO getUserById(int id) throws IOException;

    List<Messages> getMessages(int tenantId, int landlordId) throws IOException;

    List<Messages> getNewMessages(int tenantId, int landlordId) throws IOException;

    boolean checkForNewMessages(int senderId, int recipientId) throws IOException;

    boolean checkForMessages(int senderId, int recipientId) throws IOException;

    Messages sendMessage(String message, int senderId, int recipientId) throws IOException;

    String getNotification(String user_name) throws IOException;

    String payRent(String value, int id) throws IOException;

    Estates refreshEstate(int id) throws IOException;

    void sendImageMessage(MessageDTO messageDTO) throws IOException;

    List<Messages> getMessagesForAdapter(int id) throws IOException;

    String checkForEstateMessage(int id) throws IOException;

    String postEstateMessage(String spinnerMessage, int estateId, int userId) throws IOException;
}
