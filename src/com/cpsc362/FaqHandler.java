package com.cpsc362;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FaqHandler {

    public static void answerFaq(Scanner scanner, Set<Map.Entry<String, JsonElement>> faq){

        String response = "";
        String input = "";
        boolean firstInput = true;
        while (!response.equals("Stop")) {
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                response = findAnswer(input, faq);
                System.out.println(response);
                firstInput = false;
            }else{
                if(!firstInput) {
                    System.out.println("I'm sorry. I didn't get that. Could you try again please");
                }
                input = "";
            }
        }
    }

    private static String findAnswer(String userInput, Set<Map.Entry<String, JsonElement>> faq){

        for (Map.Entry<String, JsonElement> eachQuestion : faq){
            JsonObject object = eachQuestion.getValue().getAsJsonObject().get("Alt").getAsJsonObject();
                for(Map.Entry<String, JsonElement> each : object.entrySet()) {
                    if(userInput.toLowerCase().equals(each.getValue().getAsString().toLowerCase())){
                        return eachQuestion.getValue().getAsJsonObject().get("Response").getAsString();
                    }
                }
        }
        return "I'm sorry. I didn't get that. Could you try again please";
    }
}
