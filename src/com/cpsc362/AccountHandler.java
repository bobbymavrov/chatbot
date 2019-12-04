package com.cpsc362;

import java.util.Scanner;

public class AccountHandler {

    public static String signIn(Scanner scanner){

        boolean success = false;
        String username;

        do {
            System.out.println("Please enter your user name:\t");
            username = scanner.next();
            System.out.println("Please enter your password:\t");
            String password = scanner.next();

            if(username.isEmpty()){
                System.out.println("You have not entered any username. Would you like to try again?(Yes/No):\t");
                String input = scanner.next();
                if(input.matches("N|n|No")){
                    success = true;
                }
            }else{
                success = true;
            }
        }while (!success);
        return username;
    }
}
