package com.cpsc362;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static String username = "";
    private static boolean authenticated = false;
    private static Set<Map.Entry<String, JsonElement>> faqContent = new HashSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is Alex. I'm here to assist you with anything you need.\n" +
                "I see you have not signed in to your account. Would you like me to help you to sign in? (Yes/No)");
        String input = scanner.next();

        if(input.matches("Y|y|Yes|yes"))
            username = AccountHandler.signIn(scanner);

        if(!username.isEmpty()){
            authenticated = true;
            System.out.println(String.format("\nHello %s, welcome back! How can I help you today? You can " +
                    "ask me things like:\n%s", username, getRandomAuthenticated()));
        }else{
            System.out.println(String.format("\nHow can I help you today? You can ask me things like:\n%s", getRandomGuest()));
        }
        loadFaq(authenticated);
        FaqHandler.answerFaq(scanner, faqContent);
    }

    private static String getRandomAuthenticated(){
        return "My latest video isn’t online\n" +
                "I want to pay for something but don’t know how\n" +
                "Do you have music videos\n" +
                "Why was my video cut off\n";
    }

    private static String getRandomGuest(){
        return "Do you have videos for kids\n" +
                "Where can I find videos on cosplay\n" +
                "Do you have music videos\n" +
                "Is making and account free\n";
    }
    private static void loadFaq(boolean authenticated) throws FileNotFoundException {
        String json = authenticated? "faq-account.json" : "faq.json";
        InputStream is = new FileInputStream(json);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(new InputStreamReader(is));
        faqContent = jsonObject.entrySet();
    }
}
