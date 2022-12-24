package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Nikita", "Rabotnov", (byte) 32);
        userService.saveUser("Ken", "Block", (byte) 54);
        userService.saveUser("Alexey", "Vladykin", (byte) 38);
        userService.saveUser("Cristiano", "Ronaldo", (byte) 37);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.closeFactory();
    }
}
