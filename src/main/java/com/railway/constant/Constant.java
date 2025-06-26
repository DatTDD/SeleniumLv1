package com.railway.constant;

public class Constant {

    //LoginPage
    public static class Login {
        public static final String LOGIN_PAGE_TITLE = "Login page";
        public static final String VALID_USERNAME = "dattdd129@gmail.com";
        public static final String VALID_PASSWORD = "12345678";
        public static final String INVALID_PASSWORD = "1@3#5_7!/;'";
        public static final String BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
        public static final String INVALID_ALL_ERROR_MESSAGE = "Invalid username or password. Please try again.";
        public static final String SEVERAL_TIMES_LOGIN_FAIL_MESSAGE = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    }

    //HomePageAfterLogin
    public static final String WELCOME_MESSAGE = "Welcome " + Login.VALID_USERNAME;

    public static class Register {
        public static final String THANKYOU_TEXT = "Thank you for registering your account";
        public static final String REGISTER_EMAIL = "113@gmail.com";
        public static final String REGISTER_EMAIL2 = "02091945@gmail.com";
        public static final String REGISTER_PASSWORD = "12345678";
        public static final String REGISTER_CF_PASSWORD = REGISTER_PASSWORD;
        public static final String REGISTER_PID = "12345678";
        public static final String REGISTER_MESSAGE_ERROR = "There're errors in the form. Please correct the errors and try again.";
        public static final String INVALID_PASSWORD_ERROR_MESSAGE = "Invalid password length";
        public static final String invalidIDErrorMessage = "Invalid ID length";
    }

    //ChangePasswordPage
    public static class ChangePassword {
        public static final String CHANGE_PASSWORD_MESSAGE_SUCCESS = "Your password has been updated!";
    }

    //MyTicketPage
    public static class MyTicket {

    }

    //BookTicketPage
    public static class BookTicket {
        public static final String DEPART_DATE = "7/12/2025";
        public static final String DEPART_FROM = "Sài Gòn";
        public static final String ARRIVER_AT = "Nha Trang";
        public static final String SEAT_TYPE = "Soft bed with air conditioner";
        public static final String TICKET_AMOUNT = "1";
        public static final String SUCCESSFUL_BOOKING_MESSAGE = "Ticket booked successfully!";
    }

    public static class PageTitle {
        public static final String LOGIN_PAGE_TITLE = "Login page";
        public static final String MY_TICKET_TITLE = "Manage ticket";
        public static final String CHANGE_PASSWORD_TITLE = "Change password";
        public static final String REGISTER_PAGE_TITLE = "Create accounte";
        public static final String BOOK_TICKET_PAGE_TITLE = "Book ticket";
    }
}
