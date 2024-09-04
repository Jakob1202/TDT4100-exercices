package oving5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwitterAccount {
    private String userName;
    private ArrayList<Tweet> tweets;
    private ArrayList<TwitterAccount> follows;
    private ArrayList<TwitterAccount> followers;

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
        this.followers = new ArrayList<>();
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
        account.followers.add(this);
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
        account.followers.remove(this);
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
     * Method to get the number of followers to this account
     * 
     * @return the number of followers
     */
    public int getFollowersCount() {
        return this.followers.size();
    }

    public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
        if (comparator == null) {
            return this.followers;
        } else {
            List<TwitterAccount> sortedFollowers = new ArrayList<>(this.followers);
            Collections.sort(sortedFollowers, comparator);
            return sortedFollowers;

        }
    }
}
