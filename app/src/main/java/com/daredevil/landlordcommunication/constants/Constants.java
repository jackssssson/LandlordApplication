package com.daredevil.landlordcommunication.constants;

public class Constants {
    private static final String IP_AND_PORT = "http://95.111.19.222:3579/";


    public static final String postLandlord = Constants.IP_AND_PORT+"user/addLandlord";
    public static final String postTenant = Constants.IP_AND_PORT+"user/addTenant";
    public static final String isLoginCorrect = Constants.IP_AND_PORT+"user/checkLogin";
    public static final String isUserFree = Constants.IP_AND_PORT+"user/isUserFree";
    public static final String getByUserNameAndPassword = Constants.IP_AND_PORT+"user/getUser";
    public static final String createEstateUrl = Constants.IP_AND_PORT + "estates/createEstate/";
    public static final String getTenantURL = Constants.IP_AND_PORT + "estates/getTenant/";
    public static final String getLandlordURL = Constants.IP_AND_PORT + "estates/getLandlord/";
    public static final String ratingUser = Constants.IP_AND_PORT + "userRating/rateUser/";
    public static final String setDueDate = Constants.IP_AND_PORT + "estates/setDueDate/";
    public static final String setOwed = Constants.IP_AND_PORT + "estates/setOwed/";
    public static final String getUnoccupiedEstates = Constants.IP_AND_PORT + "estates/getUnoccupiedEstates";
    public static final String rentEstate = Constants.IP_AND_PORT + "user/rentEstate/";
    public static final String getUserById = Constants.IP_AND_PORT + "user/getUser/";


    public static final String CHAT_SERVER_URL = "https://socket-io-chat.now.sh/";
}
