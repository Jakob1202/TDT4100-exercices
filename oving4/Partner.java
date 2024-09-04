package oving4;

public class Partner {
    private String name;
    private Partner partner;

    /**
     * Constructor for partner
     * 
     * @param name the name to this partner
     */
    public Partner(String name) {
        this.name = name;
        this.partner = null;
    }

    /**
     * Method to set a new partner to this person
     * 
     * @param newPartner the new partner
     */
    public void setPartner(Partner newPartner) {
        if (this.partner == newPartner) {
            return;
        }

        // Kobler partner til newPartner
        Partner oldPartner = this.partner;
        this.partner = newPartner;

        // Koble oldPartner fra partner
        if (oldPartner != null && oldPartner.getPartner() == this) {
            oldPartner.setPartner(null);
        }

        // Koble newPartner til partner
        if (newPartner != null) {
            newPartner.setPartner(this);
        }

    }

    /**
     * Method to get the name to this partner
     * 
     * @returnt the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to get the partner to this partner
     * 
     * @return the partner
     */
    public Partner getPartner() {
        return this.partner;
    }

    /**
     * Method to get the name to this partner and the partner to this partner
     * 
     * @return the name and the partner
     */
    @Override
    public String toString() {
        String partnerName = (partner != null) ? partner.getName() : "null";
        return "Partner [name=" + this.name + ", partner=" + partnerName + "]";
    }

    public static void main(String[] args) {
        Partner p1 = new Partner("p1");
        Partner p2 = new Partner("p2");
        Partner p3 = new Partner("p3");

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        p1.setPartner(p2);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        p1.setPartner(p3);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
