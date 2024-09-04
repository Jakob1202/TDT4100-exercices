package oving5;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {

    /**
     * Method to compare two account by most followers
     * 
     * @param account1 the first account
     * @param account2 the second account
     * @return 0 if the accounts have the same ammount of followers, -1 if the
     *         second account have most followers and 1 if the first account
     *         have most followers
     */
    @Override
    public int compare(TwitterAccount account1, TwitterAccount account2) {
        return account2.getFollowersCount() - account1.getFollowersCount();
    }

}
