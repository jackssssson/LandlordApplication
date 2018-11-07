package com.daredevil.landlordcommunication;

import com.daredevil.landlordcommunication.models.dto.UserDTO;
import com.daredevil.landlordcommunication.repositories.InMemoryRepository;
import com.daredevil.landlordcommunication.servieces.InMemoryService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HttpUserServiceTester {


    private InMemoryRepository mockRepository;

    @InjectMocks
    private InMemoryService service;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    private List<UserDTO> users = Arrays.asList(
            new UserDTO("Jivko", "123456",
                    "jivko_hinev90@abv.bg", "1234567890", "Tenant"),
            new UserDTO("Denis", "123456",
                    "denis@abv.bg", "1234567890", "Landlord")
    );

    @Test
    public void addUser() throws IOException {
        //Arrange
        mockRepository = mock(InMemoryRepository.class);

        //Act
        UserDTO user = service.getUserById(1);

        //Assert
        Assert.assertEquals(user.getUserName(), users.get(0).getUserName());
    }

    @Test
    public void getByUserNameAndPassword() throws IOException {
        //Arrange
        mockRepository = mock(InMemoryRepository.class);

//        Mockito.when(mockRepository.getByUserNameAndPassword("Jivko", "123456"))
//                .thenReturn(users.get(0));

        //Act
        UserDTO user = service.getByUserNameAndPassword("Jivko", "123456");

        //Assert
        Assert.assertEquals(user.getUserName(), users.get(0).getUserName());
        Assert.assertEquals(user.getUserPassword(), users.get(0).getUserPassword());
    }
}
