package Week3;

import java.util.Scanner;

public class HumanChatter implements Chatter {
    private Scanner scanner = new Scanner(System.in);

    public String replyTo(String statement) {
        System.out.print(">>> ");
        return scanner.nextLine();
    }
    /*notice now since we have a factory already we no longer need to change anything beside
        the factory class (simple and bombastic)
     */
}
