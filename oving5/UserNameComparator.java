package oving5;

import java.util.Comparator;

import oving4.TwitterAccount;

public class UserNameComparator implements Comparator<TwitterAccount> {

    /**
     * Method two compare two twitter accounts by username
     * 
     * @param account1 the first account
     * @param account2 the second account
     * @return 0 if the accounts have the same username, -1 if the username to the
     *         second account is greater than the first account and 1 if the
     *         username to the to the first account is greater than the second
     *         account
     */
    @Override
    public int compare(TwitterAccount account1, TwitterAccount account2) {
        return account1.getUserName().compareTo(account2.getUserName());
    }

}
