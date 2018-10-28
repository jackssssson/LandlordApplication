package com.daredevil.landlordcommunication.constants;

public class Constants {
    public static final String CHAT_SERVER_URL = "https://socket-io-chat.now.sh/";
    public static final String getUser = "http://192.168.43.151:8080/user/getUser/1";
    public static final String getAllUnoccupiedLandlords = "http://192.168.1.4:8080/user/getAllUnoccupiedLandlords";
    public static final String postLandlord = "http://192.168.1.3:8080/user/addLandlord";
    public static final String postTenant = "http://192.168.1.3:8080/user/addTenant";
    public static final String GET_TEST = "https://reqres.in/api/users/2";
    public static final String POST_TEST = "https://reqres.in/api/register";
    public static final String isLoginCorrect = "http://192.168.1.3:8080/user/checkLogin";
    public static final String isUserFree = "http://192.168.1.3:8080/user/isUserFree";

    public static final String getByUserNameAndPassword = "http://192.168.1.3:8080/user/getUser";
}
