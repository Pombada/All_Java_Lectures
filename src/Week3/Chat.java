package Week3;

import java.util.*;

public class Chat {
    private static final String EXIT_STATEMENT = "stop";
    public static void main(String[] args){

        if(args.length < 1) {
            System.out.println("Enter Chatter types as cmd args: Chat [chatter 1], [chatter 2]...");
            return;
        }
        ChatterFactory factory = new ChatterFactory();
        Chatter[] chatters = new Chatter[args.length];
        for (int i = 0; i < chatters.length; i++){
            chatters[i] = factory.build(args[i]);
            if(chatters[i] == null){
                System.err.println("Failed to create chatter " + args[i]+ ".");
                //an alternative way to print the top line would be
                System.err.println(String.format("Failed to create chatter %s . ",args[i]));
                //this would replace s% with the args[i] (s is for string placeholder)
                return;
            }
        }
        Scanner scanner = new Scanner(System.in);

        String statement = "hi";
        for (int i = 0; !statement.equalsIgnoreCase(EXIT_STATEMENT); i= (i+1)%chatters.length){
            String newStatement = chatters[i].replyTo(statement);
            if (newStatement.isEmpty())
                continue;
            statement = newStatement;
            System.out.print(String.format("%s : %s",args[i],statement));
            scanner.nextLine();
        }
    }
}
