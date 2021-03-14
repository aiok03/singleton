package com.company;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        Database foo = Database.getInstance();
        System.out.println(foo);
        Database bar = Database.getInstance();
        System.out.println(bar);
        // The variable `bar` will contain the same object as
        // the variable `foo`
    }
}
