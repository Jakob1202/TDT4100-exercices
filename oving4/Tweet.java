package oving4;

public class Tweet {
    private TwitterAccount owner;
    private String text;
    private Tweet originalTweet;
    private int retweetCount;
    private int favoriteCount;

    /**
     * Constructor to tweet
     * 
     * @param account the account who post the tweet
     * @param text    the text to the tweet
     */
    public Tweet(TwitterAccount account, String text) {
        this.owner = account;
        this.text = text;
        this.originalTweet = null;
        this.retweetCount = 0;
        this.favoriteCount = 0;
    }

    /**
     * Constructor for retweet
     * 
     * @param account      the account who retweets
     * @param orginalTweet the tweet to be retweetet
     */
    public Tweet(TwitterAccount account, Tweet orginalTweet) {
        if (account.equals(orginalTweet.getOwner())) {
            throw new IllegalArgumentException("The tweet is from the same account");
        }

        this.owner = account;
        this.text = orginalTweet.getText();

        if (orginalTweet.getOriginalTweet() == null) {
            this.originalTweet = orginalTweet;
            orginalTweet.retweetCount += 1;
        } else {
            this.originalTweet = orginalTweet.getOriginalTweet();
            orginalTweet.getOriginalTweet().retweetCount += 1;
        }
    }

    /**
     * Method to get the text to this tweet
     * 
     * @return the text
     */
    public String getText() {
        return this.text;
    }

    /**
     * Method to get the account to this tweet
     * 
     * @return the account
     */
    public TwitterAccount getOwner() {
        return this.owner;
    }

    /**
     * Method to get the original tweet if it is a retweet
     * 
     * @return the original tweet
     */
    public Tweet getOriginalTweet() {
        return this.originalTweet;
    }

    /**
     * Method to get the numbers of retweets to this tweet
     * 
     * @return the numbers of retweet
     */
    public int getRetweetCount() {
        return this.retweetCount;
    }

    /**
     * Method to get favorite count to this tweet
     * 
     * @return the favorite count
     */
    public int getFavoriteCount() {
        return this.favoriteCount;
    }

    /**
     * Method to increase the favorite count to this tweet
     */
    public void increaseFavoritecount() {
        this.favoriteCount++;
    }

    /**
     * Method to decrease the favorite count to this tweet
     */
    public void decreaseFavoriteCount() {
        this.favoriteCount--;
    }
}
