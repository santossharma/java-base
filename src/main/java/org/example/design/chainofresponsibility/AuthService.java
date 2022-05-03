package org.example.design.chainofresponsibility;

public class AuthService {
    private final Handler handler;

    public AuthService(Handler handler) {
        this.handler = handler;
    }

    public boolean login(String username, String password) {
        if(handler.handle(username, password)) {
            System.out.println("Successfully Authorized !!");
            return true;
        }
        return false;
    }
}
