package com.cpsc362;

import java.util.Scanner;

public class Main {

    private static String username;
    private static boolean authenticated = false;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is Alex. I'm here to assist you with anything you need.\n" +
                "I see you have not signed in to your account. Would you like me to help you to sign in? (Yes/No)");
        String input = scanner.next();

        if(input.matches("Y|y|Yes"))
            username = AccountHandler.signIn(scanner);

        if(!username.isEmpty()){
            authenticated = true;
            System.out.println(String.format("Hello %s, welcome back! How can I help you today? You can " +
                    "ask me thing like:\n\n%s", username, getRandomQuestions()));
        }
    }

    private static String getRandomQuestions(){
        return "1. "
    }

}
