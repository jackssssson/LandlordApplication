package com.daredevil.landlordcommunication;

import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.models.dto.MessageDTO;
import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.servieces.InMemoryService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HttpUserServiceTester {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    @InjectMocks
    private InMemoryService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

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

    private List<MessageDTO> messagesDTO = Arrays.asList(
            new MessageDTO("Hello", ONE, ONE),
            new MessageDTO("Hi", 2, 2)
    );

    @Test
    public void addUser() throws IOException {
        Assert.assertEquals(service.addUser(users.get(ZERO), users.get(ZERO).getType()),
                users.get(ZERO).getType());
    }

    @Test
    public void getByUserNameAndPassword() throws IOException {
        Assert.assertEquals(service.getByUserNameAndPassword(
                users.get(ZERO).getUserName(), users.get(ZERO).getUserPassword()), users.get(ZERO));
    }

    @Test
    public void createEstate() throws IOException {
        Assert.assertEquals(service.createEstate(estates.get(ZERO),
                estates.get(ZERO).getEstateName()), estates.get(ZERO).getEstateName());
    }

    @Test
    public void getEstate() throws IOException {
        Assert.assertEquals(service.getEstates(), estates.get(ZERO));
    }

    @Test
    public void postIdEstate() throws IOException {
        Assert.assertEquals(service.postIdEstate(users.get(ZERO).getUserid()), users.get(ZERO));
    }

    @Test
    public void setDueDate() throws IOException {
        Assert.assertEquals(service.setDueDate(estates.get(ZERO).getDuedate(),
                users.get(ZERO).getUserid()), estates.get(ZERO).getDuedate());
    }

    @Test
    public void rateUser() throws IOException {
        Assert.assertEquals(service.rateUser(Integer.parseInt(users.get(0).getUserRating()),
                users.get(ZERO).getUserName(), users.get(ZERO).getUserName()),
                users.get(ZERO).getUserName());
    }

    @Test
    public void setOwed() throws IOException {
        Assert.assertEquals(service.setOwed(
                String.valueOf(estates.get(ZERO).getPrice()),
                estates.get(ZERO).getEstateid()), users.get(ZERO).getUserName());
    }

    @Test
    public void getUnoccupiedEstates() throws IOException {
        Assert.assertEquals(service.getUnoccupiedEstates(), estates);
    }

    @Test
    public void postIdPerson() throws IOException {
        Assert.assertEquals(service.postIdPerson(users.get(ZERO).getUserid()), users.get(ZERO));
    }

    @Test
    public void rentEstate() throws IOException {
        Assert.assertEquals(service.rentEstate(
                Integer.toString(users.get(ZERO).getUserid()),
                Integer.toString(estates.get(ZERO).getEstateid())
        ), Integer.toString(users.get(ZERO).getUserid())
                + Integer.toString(estates.get(ZERO).getEstateid()));
    }

    @Test
    public void getMessages() throws IOException {
        Assert.assertEquals(service.getMessages(users.get(ZERO).getUserid(),
                users.get(ONE).getUserid()), messages);
    }

    @Test
    public void getNewMessages() throws IOException {
        Assert.assertEquals(service.getNewMessages(users.get(ZERO).getUserid(),
                users.get(ONE).getUserid()), messages);
    }

    @Test
    public void checkForNewMessages() throws IOException {
        Assert.assertEquals(service.checkForNewMessages(users.get(ZERO).getUserid(),
                users.get(ONE).getUserid()), true);
    }

    @Test
    public void checkForMessages() throws IOException {
        Assert.assertEquals(service.checkForNewMessages(users.get(ZERO).getUserid(),
                users.get(ONE).getUserid()), true);
    }

    @Test
    public void sendMessage() throws IOException {
        Assert.assertEquals(service.sendMessage(messages.get(ZERO).getTextMessage(),
                users.get(ZERO).getUserid(),
                users.get(ONE).getUserid()), messages.get(ZERO));
    }

    @Test
    public void getNotification() throws IOException {
        Assert.assertEquals(service.getNotification(
                users.get(ZERO).getUserName()), users.get(ZERO).getUserName());
    }

    @Test
    public void payRent() throws IOException {
        Assert.assertEquals(service.payRent(
                String.valueOf(estates.get(ZERO).getPrice()),
                estates.get(ZERO).getEstateid()),
                String.valueOf(estates.get(ZERO).getPrice()));
    }

    @Test
    public void refreshEstate() throws IOException {
        Assert.assertEquals(service.refreshEstate(
                estates.get(ZERO).getEstateid()), estates.get(ZERO));
    }

    @Test
    public void sendImageMessage() throws IOException {
        InMemoryService test = Mockito.mock(InMemoryService.class);

        test.sendImageMessage(messagesDTO.get(ZERO));

        Mockito.verify(test, Mockito.times(1))
                .sendImageMessage(messagesDTO.get(ZERO));
    }

    @Test
    public void getMessagesForAdapter() throws IOException {
        Assert.assertEquals(service.getMessagesForAdapter(
                users.get(ZERO).getUserid()), messages);
    }

    @Test
    public void checkForEstateMessage() throws IOException {
        Assert.assertEquals(service.checkForEstateMessage(
                users.get(ZERO).getUserid()), Integer.toString(users.get(ZERO).getUserid()));
    }

    @Test
    public void postEstateMessage() throws IOException {
        Assert.assertEquals(service.postEstateMessage(
                messages.get(ZERO).getTextMessage(),
                estates.get(ZERO).getEstateid(),
                users.get(ZERO).getUserid()), messages.get(ZERO).getTextMessage());
    }
}
