package Week3;

public class Toddler implements Chatter {
    private String likedPhrase;
    private Chatter chatterIfPhraseNotFound;

    public Toddler(String likedPhrase,Chatter chatterIfPhraseNotFound) {
        this.likedPhrase = likedPhrase;
        this.chatterIfPhraseNotFound = chatterIfPhraseNotFound;

    }

    public String replyTo(String statement) {
        if (statement.contains(likedPhrase))
            return String.format("Say %s again", statement);

        return chatterIfPhraseNotFound.replyTo(statement);
    }
}
