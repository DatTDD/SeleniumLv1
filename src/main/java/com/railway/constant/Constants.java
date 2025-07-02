package com.railway.constant;

public class Constants {
    //Account
    public static class Account {
        public static final String VALID_USERNAME = "dattdd129@gmail.com";
        public static final String VALID_PASSWORD = "12345678";
        public static final String INVALID_PASSWORD = "1@3#5_7!/;'";
        public static final String REGISTER_EMAIL =  "selenium12345@gmail.com";
        public static final String REGISTER_PASSWORD = "12345678";
        public static final String REGISTER_CF_PASSWORD = REGISTER_PASSWORD;
        public static final String REGISTER_PID = "12345678";
        public static final String RESET_PASSWORD_ACCOUNT = "lhdfhmhb@sharklasers.com";
    }

    public static class MenuBar {
        public static final String TIMETABLE = "Timetable";
        public static final String BOOK_TICKET = "Book ticket";
        public static final String MY_TICKET = "My ticket";
        public static final String REGISTER = "Register";
        public static final String LOGIN = "Login";
        public static final String CHANGE_PASSWORD = "Change password";
        public static final String LOGOUT = "Log out";
    }

    public static class PageTitle {
        public static final String LOGIN_PAGE_TITLE = "Login page";
        public static final String MY_TICKET_TITLE = "Manage ticket";
        public static final String CHANGE_PASSWORD_TITLE = "Change password";
        public static final String REGISTER_PAGE_TITLE = "Create accounte";
        public static final String BOOK_TICKET_PAGE_TITLE = "Book ticket";
        public static final String LOG_OUT = "Log out";
        public static final String RESET_PASSWORD_PAGE_TITLE = "Safe Railway - Password Reset";
    }

    //LoginPage
    public static class Login {
        public static final String LOGIN_PAGE_TITLE = "Login page";
    }

    //HomePageAfterLogin
    public static class HomePage {
        public static final String WELCOME_MESSAGE = "Welcome " + Account.VALID_USERNAME;
    }


    public static class Message {
        public static final String LOGIN_WITH_BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
        public static final String LOGIN_WITH_INVALID_ALL_ERROR_MESSAGE = "Invalid username or password. Please try again.";
        public static final String SEVERAL_TIMES_LOGIN_FAIL_MESSAGE = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        public static final String REGISTER_THANKYOU_TEXT = "Thank you for registering your account";
        public static final String REGISTER_MESSAGE_ERROR = "There're errors in the form. Please correct the errors and try again.";
        public static final String REGISTER_INVALID_PASSWORD_ERROR_MESSAGE = "Invalid password length";
        public static final String REGISTER_INVALID_ID_ERROR_MESSAGE = "Invalid ID length";
        public static final String CHANGE_PASSWORD_MESSAGE_SUCCESS = "Your password has been updated!";
        public static final String SUCCESSFUL_BOOKING_MESSAGE = "Ticket booked successfully!";
        public static final String ERROR_MESSAGE_INCORRECT_RESET_TOKEN = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
        public static final String INLINE_ERROR_MESSAGE_INVALID_RESET_TOKEN = "The password reset token is invalid.";
        public static final String ERROR_MESSAGE_COULD_NOT_RESET_PASSWORD = "Could not reset password. Please correct the errors and try again.";
        public static final String INLINE_ERROR_MESSAGE_CONFIRM_PASSWORD = "The password confirmation did not match the new password.";
    }

}
