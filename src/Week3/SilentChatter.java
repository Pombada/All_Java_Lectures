package Week3;

import java.util.Random;

public class SilentChatter implements Chatter{
    private String statement;
    private int percentageToSayStatement;
    private Random random = new Random();


    public SilentChatter(String statement, int percentageToSayStatement){
        this.statement = statement;
        this.percentageToSayStatement = percentageToSayStatement;
    }

    @Override
    public String replyTo(String statement) {
        if(random.nextInt(100) < percentageToSayStatement)
            return this.statement;
        return "";
    }
}
