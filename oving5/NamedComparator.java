package oving5;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {

    @Override
    public int compare(Named named1, Named named2) {
        int sortedByFamilyName = named1.getFamilyName().compareTo(named2.getFamilyName());
        int sortedByGivenName = named1.getGivenName().compareTo(named2.getGivenName());
        if (sortedByFamilyName != 0) {
            return sortedByFamilyName;
        } else {
            return sortedByGivenName;
        }
    }
}
