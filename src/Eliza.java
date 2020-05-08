import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        HashMap<String,String> replaceMap = new HashMap<>();
        replaceMap.put("i", "you");
        replaceMap.put("i'm", "you're");
        replaceMap.put("me", "you");
        replaceMap.put("my", "your");
        replaceMap.put("am", "are");

        System.out.println("Good day. What is your problem?");
        String response = "";

        do {
            System.out.println("Enter your response here or Q to quit: ");
            response = input.nextLine().toLowerCase();
            if (response.equals("q")) System.exit(1);
            respond(replaceMap, response);
        } while (!response.equals("i am feeling great"));
        System.out.println("Thanks for chatting. Have a great day!");
    }

    public static void respond(HashMap replaceMap, String response) {
        String returnStr = "";
        Random random = new Random();
        String[] elizaResponses = {"You see to think that ", "Why do you say that ", "Please tell me more"};
        int randomIdx = random.nextInt(3);
        for (String word : response.split(" ")) {
            if (replaceMap.containsKey(word)) {
                returnStr += replaceMap.get(word) + " ";
            } else {
                returnStr += word + " ";
            }
        }

        switch (randomIdx) {
            case 0:
                returnStr = elizaResponses[0] + returnStr;
                break;
            case 1:
                returnStr = elizaResponses[1] + returnStr;
                break;
            default:
                returnStr = elizaResponses[2];
                break;
        }

        System.out.println(returnStr);
    }
}