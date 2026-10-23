package Week3;


import java.util.Scanner;

class ChatterFactory  {

    private static final String STRING_SEPARATOR = "#";
    private Scanner scanner = new Scanner(System.in);
   public Chatter build (String arg){
        Chatter chatter = null;
        System.out.println(String.format("======= creating %s chatter =======", arg));
        switch(arg) {
            case "echo":
                chatter = new EchoChatter(getStringsFromUser("replies to illegal requests"));
                break;
            case "human":
                chatter = new HumanChatter();
                break;
            case "silent":
                System.out.println("Enter statement for silent chatter:  ");
                String statement = scanner.nextLine();
                System.out.println("Enter percentage to say statement: ");
                int percentage = scanner.nextInt();
                scanner.nextLine();
                chatter = new SilentChatter(statement,percentage);
                break;
        }
       System.out.println(String.format("======= %s chatter created =======\n", arg));

        return chatter;
        /*if (arg.equals("echo"))
            return new EchoChatter(new String[] {"what "});*/
        /*
        else if (arg.equals("other kind of chatter"))
            return other chatter;

         */
    }
    private String[] getStringsFromUser(String stringDescription){
        System.out.print(String.format("Enter %s (with %s as seperator): " ,stringDescription,STRING_SEPARATOR));
        String line = scanner.nextLine();
        return line.split(STRING_SEPARATOR);
    }
}
