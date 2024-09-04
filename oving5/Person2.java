package oving5;

public class Person2 implements Named {
    private String fullName;

    /**
     * Constructor for this person
     * 
     * @param fullName the full name to this person
     */
    public Person2(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Method to set the given name to this person
     * 
     * @param newGivenName the new given name
     */
    @Override
    public void setGivenName(String newGivenName) {
        this.fullName = newGivenName + " " + this.fullName.split(" ")[1];
    }

    /**
     * Method to get the given name to this person
     * 
     * @return the given name
     */
    @Override
    public String getGivenName() {
        return this.fullName.split(" ")[0];
    }

    /**
     * Method to set the family name to this person
     * 
     * @param newFamilyName the new family name
     */
    @Override
    public void setFamilyName(String newFamilyName) {
        this.fullName = this.fullName.split(" ")[0] + " " + newFamilyName;
    }

    /**
     * Method to get the family name to this person
     * 
     * @return the family name
     */
    @Override
    public String getFamilyName() {
        return this.fullName.split(" ")[1];
    }

    /**
     * Method to set the full name to this person
     * 
     * @param newFullName the new full name
     */
    @Override
    public void setFullName(String newFullName) {
        this.fullName = newFullName;
    }

    /**
     * Method to get the full name to this person
     * 
     * @return the full name
     */
    @Override
    public String getFullName() {
        return this.fullName;

    }
}
