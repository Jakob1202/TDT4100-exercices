package oving5;

public interface Named {
    /**
     * Method to set the given name to this person
     * 
     * @param newGivenName the new given name
     */
    public void setGivenName(String newGivenName);

    /**
     * Method to get the given name
     * 
     * @return the given name
     */
    public String getGivenName();

    /**
     * Method to set the family name
     * 
     * @param newFamilyName the new family name
     */
    public void setFamilyName(String newFamilyName);

    /**
     * Method to get the family name
     * 
     * @return the family name
     */
    public String getFamilyName();

    /**
     * Method to set the full name
     * 
     * @param newFullName the new full name
     */
    public void setFullName(String newFullName);

    /**
     * Method to get the full name
     * 
     * @return the full name
     */
    public String getFullName();

}
