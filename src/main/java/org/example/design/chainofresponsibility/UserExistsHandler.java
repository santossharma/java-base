package org.example.design.chainofresponsibility;

public class UserExistsHandler extends Handler {
    private final Database database;

    public UserExistsHandler(Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String username, String password) {
        if(!database.isValidUser(username)) {
            System.out.println("This username is not registered !!");
            System.out.println("Sign Up now !!");

            return false;
        }
        return handleNext(username, password);
    }
}
