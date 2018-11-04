package com.daredevil.landlordcommunication.servieces;

import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.dto.MessageDTO;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.repositories.Repository;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class HttpUserService implements UserService {
    @Inject
    Repository mUserRepository;

    @Inject
    public HttpUserService(Repository repository) {
        this.mUserRepository = repository;
    }


    @Override
    public String addUser(UserDTO user, String type) throws IOException {
        return mUserRepository.addUser(user, type);
    }

    @Override
    public UserDTO getByUserNameAndPassword(String userName, String password) throws IOException {
        return mUserRepository.getByUserNameAndPassword(userName, password);
    }

    @Override
    public String createEstate(Estates estates, String name) throws IOException {
        return mUserRepository.createEstate(estates, name);
    }

    @Override
    public Estates getEstates() throws IOException {
        return mUserRepository.getEstates();
    }

    @Override
    public UserDTO postIdEstate(int id) throws IOException {
        return mUserRepository.postIdEstate(id);
    }

    @Override
    public String setDueDate(String dueDate, int id) throws IOException {
        return mUserRepository.setDueDate(dueDate, id);
    }

    @Override
    public String rateUser(int rating, String name, String userName) throws IOException {
        return mUserRepository.rateUser(rating, name, userName);
    }

    @Override
    public String setOwed(String price, int id) throws IOException {
        return mUserRepository.setOwed(price, id);
    }

    @Override
    public List<Estates> getUnoccupiedEstates() throws IOException {
        return mUserRepository.getUnoccupiedEstates();
    }

    @Override
    public UserDTO postIdPerson(int id) throws IOException {
        return mUserRepository.postIdPerson(id);
    }

    @Override
    public String rentEstate(String userId, String estateId) throws IOException {
        return mUserRepository.rentEstate(userId, estateId);
    }

    @Override
    public UserDTO getUserById(int id) throws IOException {
        return mUserRepository.getUserById(id);
    }

    @Override
    public List<Messages> getMessages(int tenantId, int landlordId) throws IOException {
        return mUserRepository.getMessages(tenantId, landlordId);
    }

    @Override
    public List<Messages> getNewMessages(int tenantId, int landlordId) throws IOException {
        return mUserRepository.getNewMessages(tenantId, landlordId);
    }

    @Override
    public boolean checkForNewMessages(int senderId, int recipientId) throws IOException {
        return mUserRepository.checkForNewMessages(senderId, recipientId);
    }

    @Override
    public boolean checkForMessages(int senderId, int recipientId) throws IOException {
        return mUserRepository.checkForMessages(senderId, recipientId);
    }

    @Override
    public Messages sendMessage(String message, int senderId, int recipientId) throws IOException {
        return mUserRepository.sendMessage(message, senderId, recipientId);
    }

    @Override
    public String getNotification(String user_name) throws IOException {
        return mUserRepository.getNotification(user_name);
    }

    @Override
    public String payRent(String value, int id) throws IOException {
        return mUserRepository.payRent(value, id);
    }

    @Override
    public Estates refreshEstate(int id) throws IOException {
        return mUserRepository.refreshEstate(id);
    }

    @Override
    public void sendImageMessage(MessageDTO messageDTO) throws IOException {
        mUserRepository.sendImageMessage(messageDTO);
    }
}
