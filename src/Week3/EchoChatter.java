package Week3;
import java.util.*;
public class EchoChatter implements Chatter {
    public static final String REQUEST_PREFIX = "say ";
    private Random rand = new Random();
    private String[] repliesToIllegalRequest;

    public EchoChatter(String[] repliesToIllegalRequest) {
        this.repliesToIllegalRequest = new String[repliesToIllegalRequest.length];
        for (int i = 0; i < repliesToIllegalRequest.length; i++){
            this.repliesToIllegalRequest[i] = repliesToIllegalRequest[i];
        }
    }
    public String replyTo(String statement) {
        if (statement.startsWith(REQUEST_PREFIX))
            return statement.replaceFirst(REQUEST_PREFIX,"").trim();
        return respondToIllegalRequest(statement).trim();
    }
    private String respondToIllegalRequest(String statement){
        int randomIndex = rand.nextInt(repliesToIllegalRequest.length);
        String reply = repliesToIllegalRequest[randomIndex];
        if (rand.nextBoolean())
            reply+=statement;
        return reply;
    }
}
