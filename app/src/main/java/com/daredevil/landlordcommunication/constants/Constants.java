package com.daredevil.landlordcommunication.constants;

public class Constants {
    public static final String CHAT_SERVER_URL = "https://socket-io-chat.now.sh/";
    public static final String getUser =  Constants.IP_AND_PORT + "user/getUser/1";
    public static final String getAllUnoccupiedLandlords = Constants.IP_AND_PORT+"user/getAllUnoccupiedLandlords";
    public static final String postLandlord = Constants.IP_AND_PORT+"user/addLandlord";
    public static final String postTenant = Constants.IP_AND_PORT+"user/addTenant";
    public static final String GET_TEST = "https://reqres.in/api/users/2";
    public static final String POST_TEST = "https://reqres.in/api/register";
    public static final String isLoginCorrect = Constants.IP_AND_PORT+"user/checkLogin";
    public static final String isUserFree = Constants.IP_AND_PORT+"user/isUserFree";
    public static final String getByUserNameAndPassword = Constants.IP_AND_PORT+"user/getUser";

    public static final String IP_AND_PORT = "http://192.168.43.151:8080/";
    public static final String createEstateUrl = Constants.IP_AND_PORT + "estates/createEstate/";
    public static final String getTenantURL = Constants.IP_AND_PORT + "estates/getTenant/";
    public static final String ratingUser = Constants.IP_AND_PORT + "userRating/rateUser/";
    public static final String setDueDate = Constants.IP_AND_PORT + "estates/setDueDate/";
    public static final String setOwed = Constants.IP_AND_PORT + "estates/setOwed/";
}
