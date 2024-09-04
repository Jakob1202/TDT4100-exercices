package oving5;

public class Person1 implements Named {
    private String givenName;
    private String familyName;

    /**
     * Constructor for this person
     * 
     * @param givenName  the given name to this person
     * @param familyName the family name to this person
     */
    public Person1(String givenName, String familyName) {
        this.givenName = givenName;
        this.familyName = familyName;
    }

    /**
     * Method to set the given name to this person
     * 
     * @param newGivenName the new given name
     */
    @Override
    public void setGivenName(String newGivenName) {
        this.givenName = newGivenName;
    }

    /**
     * Method to get the given name to this person
     * 
     * @return the given name
     */
    @Override
    public String getGivenName() {
        return this.givenName;
    }

    /**
     * Method to set the family name to this person
     * 
     * @param newFamilyName the new family name
     */
    @Override
    public void setFamilyName(String newFamilyName) {
        this.familyName = newFamilyName;
    }

    /**
     * Method to get the family name to this person
     * 
     * @return the family name
     */
    @Override
    public String getFamilyName() {
        return this.familyName;
    }

    /**
     * Method to set the full name to this person
     * 
     * @param newFullName the new full name
     */
    @Override
    public void setFullName(String newFullName) {
        this.givenName = newFullName.split(" ")[0];
        this.familyName = newFullName.split(" ")[1];
    }

    /**
     * Method to get the full name
     * 
     * @return the full name
     */
    @Override
    public String getFullName() {
        return this.givenName + " " + this.familyName;
    }

}
