package oving5;

import java.util.Comparator;

public class TwitterAccountComparator implements Comparator<TwitterAccount> {

    /**
     * Method to compare two accounts by most tweets, most followers if the accounts
     * have the same numbers of tweets, greatest username if the accounts have the
     * same numbers of followers
     */
    @Override
    public int compare(TwitterAccount account1, TwitterAccount account2) {
        if (account1.getFollowersCount() == account2.getFollowersCount()) {
            if (account1.getTweetCount() == account2.getTweetCount()) {
                return account1.getUserName().compareTo(account2.getUserName());
            } else {
                return account2.getTweetCount() - account1.getTweetCount();
            }
        } else {
            return account2.getFollowersCount() - account1.getFollowersCount();
        }
    }

}
