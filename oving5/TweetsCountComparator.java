package oving5;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {


    /**
     * Method to compare two account by most tweets
     * 
     * @param account1 the first account
     * @param account2 the second account
     * @return 0 if the accounts have the same ammount of tweets, -1 if the
     *         second account have most tweets and 1 if the first account
     *         have most tweets
     */
    @Override
    public int compare(TwitterAccount account1, TwitterAccount account2) {
        return account2.getTweetCount() - account1.getTweetCount();
    }
    
}
