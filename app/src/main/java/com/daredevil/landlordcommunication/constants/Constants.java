package com.daredevil.landlordcommunication.constants;

public class Constants {
    private static final String IP_AND_PORT = "http://192.168.0.5:3579/";

    public static final String POST_LANDLORD = Constants.IP_AND_PORT + "user/addLandlord";
    public static final String POST_TENANT = Constants.IP_AND_PORT + "user/addTenant";
    public static final String IS_LOGIN_CORRECT = Constants.IP_AND_PORT + "user/checkLogin";
    public static final String IS_USER_FREE = Constants.IP_AND_PORT + "user/isUserFree";
    public static final String GET_BY_USER_NAME_AND_PASSWORD = Constants.IP_AND_PORT + "user/getUser";
    public static final String CREATE_ESTATE = Constants.IP_AND_PORT + "estates/createEstate/";
    public static final String GET_TENANT = Constants.IP_AND_PORT + "estates/getTenant/";
    public static final String GET_LANDLORD = Constants.IP_AND_PORT + "estates/getLandlord/";
    public static final String RATING_USER = Constants.IP_AND_PORT + "userRating/rateUser/";
    public static final String SET_DUE_DATE = Constants.IP_AND_PORT + "estates/setDueDate/";
    public static final String SET_OWED = Constants.IP_AND_PORT + "estates/setOwed/";
    public static final String GET_UNOCCUPIED_ESTATE = Constants.IP_AND_PORT + "estates/getUnoccupiedEstates";
    public static final String RENT_ESTATE = Constants.IP_AND_PORT + "user/rentEstate/";
    public static final String GET_USER_BY_ID = Constants.IP_AND_PORT + "user/getUser/";
    public static final String GET_MESSAGES = Constants.IP_AND_PORT + "messages/getMessages/";
    public static final String CHECK_FOR_MESSAGES = Constants.IP_AND_PORT + "messages/checkForMessages/";
    public static final String GET_NEW_MESSAGES = Constants.IP_AND_PORT + "messages/getNewMessages/";
    public static final String CHECK_FOR_NEW_MESSAGES = Constants.IP_AND_PORT + "messages/checkForNewMessages/";
    public static final String SEND_TEXT_MESSAGES = Constants.IP_AND_PORT + "messages/postTextMessage/";
    public static final String CHAT_SERVER_URL = "https://socket-io-chat.now.sh/";
    public static final String GET_NOTIFICATION = Constants.IP_AND_PORT + "user/getNotification/";
    public static final String PAY_RENT = Constants.IP_AND_PORT + "user/payRent/";
    public static final String UPDATE_RENT = Constants.IP_AND_PORT + "estates/getEstate/";
    public static final String SEND_IMAGE = Constants.IP_AND_PORT + "messages/postImage";
    public static final String GET_MESSAGES_FOR_ADAPTER = Constants.IP_AND_PORT + "messages/getEstateMessages/";
    public static final String CHECK_FOR_ESTATE_MESSAGES = Constants.IP_AND_PORT + "messages/checkForEstateMessages/";
    public static final String GET_ESTATE_MESSAGES = Constants.IP_AND_PORT + "messages/postEstateMessage/";
}
