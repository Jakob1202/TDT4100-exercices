package oving4;

import java.util.ArrayList;

public class TwitterAccount {
    private String userName;
    private ArrayList<Tweet> tweets;
    private ArrayList<TwitterAccount> follows;
    private ArrayList<Tweet> favoriteTweets;

    /**
     * Constructur for account
     * 
     * @param userName the username to this account
     */
    public TwitterAccount(String userName) {
        if (userName == null) {
            throw new IllegalArgumentException("Not valid username");
        }
        this.userName = userName;
        this.tweets = new ArrayList<>();
        this.follows = new ArrayList<>();
        this.favoriteTweets = new ArrayList<>();
    }

    /**
     * Method to follow an account
     * 
     * @param account the account to be followed
     */
    public void follow(TwitterAccount account) {
        if (this == account) {
            throw new IllegalArgumentException("You cannot follow your own account");
        }
        this.follows.add(account);
    }

    /**
     * Method to unfollow an account
     * 
     * @param account the account to be unfollowed
     */
    public void unfollow(TwitterAccount account) {
        if (!this.follows.contains(account)) {
            throw new IllegalArgumentException("The account is not following you");
        }

        this.follows.remove(account);
    }

    /**
     * Method to check if this account follows the account
     * 
     * @param account the account to check
     * @return true is this account follows the account, false otherwise
     */
    public boolean isFollowing(TwitterAccount account) {
        return this.follows.contains(account);
    }

    /**
     * Method to check if the this account is followed by the account
     * 
     * @param account the account to check
     * @return true if this account is followed by the account, false otherwise
     */
    public boolean isFollowedBy(TwitterAccount account) {
        return account.follows.contains(this);
    }

    /**
     * Method to tweet
     * 
     * @param text the text to the tweet
     */
    public void tweet(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Not valid text");
        }
        this.tweets.add(new Tweet(this, text));
    }

    /**
     * Method to retweet
     * 
     * @param originalTweet the original tweet to be retweeted
     */
    public void retweet(Tweet originalTweet) {
        this.tweets.add(new Tweet(this, originalTweet));
    }

    /**
     * Method to get the username of this account
     * 
     * @return the username
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Method to get tweet number i to this account
     * 
     * @param i tweet number
     * @return tweet number i
     */
    public Tweet getTweet(int i) {
        if (i < 1 || i > this.tweets.size()) {
            throw new IllegalArgumentException("Not valid index");
        }

        return this.tweets.get(this.tweets.size() - i);

    }

    /**
     * Method to get the numbers of tweets to this account
     * 
     * @return numbers of tweets
     */
    public int getTweetCount() {
        return this.tweets.size();
    }

    /**
     * Method get the number of retweets to this account
     * 
     * @return number of retweets
     */
    public int getRetweetCount() {
        int retweetCount = 0;
        for (int i = 0; i < this.tweets.size(); i++) {
            retweetCount += this.tweets.get(i).getRetweetCount();
        }
        return retweetCount;
    }

    /**
     * Method to add a favorite tweet to this account
     * 
     * @param tweet the tweet
     */
    public void addFavoriteTweet(Tweet tweet) {
        if (tweet.getOriginalTweet() == null) {
            this.favoriteTweets.add(tweet);
            tweet.increaseFavoritecount();
        } else {
            this.favoriteTweets.add(tweet.getOriginalTweet());
            tweet.getOriginalTweet().increaseFavoritecount();
        }
    }

    /**
     * Method to remove a favorite tweet to this account
     * 
     * @param tweet the tweet
     */
    public void removeFavoriteTweet(Tweet tweet) {
        if (!this.favoriteTweets.contains(tweet)) {
            throw new IllegalArgumentException(
                    "The tweet has not been marked as an favorite tweet by this twitter account");
        } else {
            this.favoriteTweets.remove(tweet);
            tweet.decreaseFavoriteCount();
        }
    }

    /**
     * Method to get the favorite count to this account
     * 
     * @return the favorite count
     */
    public int getFavoriteCount() {
        int favoriteCount = 0;
        for (int i = 0; i < this.tweets.size(); i++) {
            favoriteCount += this.tweets.get(i).getFavoriteCount();
        }

        return favoriteCount;
    }

}
