package org.example.design.chainofresponsibility;

public class MainApp {
    public static void main(String[] args) {
        Database database = new Database();

        Handler handler = new UserExistsHandler(database);
        handler.setNextHandler(new ValidPasswordHandler(database));
        handler.setNextHandler(new RoleCheckHandler());

        AuthService authService = new AuthService(handler);
        authService.login("admin_username", "admin_password");
    }
}
