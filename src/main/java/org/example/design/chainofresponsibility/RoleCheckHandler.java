package org.example.design.chainofresponsibility;

public class RoleCheckHandler extends Handler {

    public RoleCheckHandler() {
    }

    @Override
    public boolean handle(String username, String password) {
        if("admin_username".equals(username)) {
            System.out.println("Loading Admin Page...");
            return true;
        }

        System.out.println("Loading Default Page...");
        return handleNext(username, password);
    }
}
