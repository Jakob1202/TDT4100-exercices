package oving2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Person {

    private String fullName;
    private String email;
    private Date birthday;
    private char gender;
    private String SSN;
    private static int[] factors1 = { 3, 7, 6, 1, 8, 9, 4, 5, 2, 0 };
    private static int[] factors2 = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };

    private ArrayList<String> countryCodes = new ArrayList<>(Arrays.asList("ad", "ae", "af", "ag", "ai", "al", "am",
            "ao", "aq",
            "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm",
            "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck",
            "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec",
            "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg",
            "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht",
            "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh",
            "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv",
            "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt",
            "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz",
            "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro",
            "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr",
            "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr",
            "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf",
            "ws", "ye", "yt", "za", "zm", "zw"));

    /**
     * Method to set new name to this person
     * 
     * @param newName the new name
     */
    public void setName(String newName) {
        if (newName.split(" ").length == 2) {
            String firstName = newName.split(" ")[0];
            String lastName = newName.split(" ")[1];

            if (firstName.length() >= 2 && lastName.length() >= 2 && firstName.matches("^[a-zA-Z]*$")
                    && lastName.matches("^[a-zA-Z]*$")) {
                this.fullName = newName;
            } else {
                throw new IllegalArgumentException(
                        "Fornavn og etternavn må være minst to bokstaver langt og kun inneholde bokstaver");
            }
        } else {
            throw new IllegalArgumentException(
                    "Navnet må inneholde både fornavn og etternavn som må være skilt med ett mellomrom");
        }
    }

    /**
     * Method to set the new email to this person
     * 
     * @param newEmail the new email
     */
    public void setEmail(String newEmail) {
        if (newEmail.split("@").length == 2) {
            if (newEmail.split("@")[0].split("\\.").length == 2 && newEmail.split("@")[1].split("\\.").length == 2) {
                String firstName = newEmail.split("@")[0].split("\\.")[0];
                String lastName = newEmail.split("@")[0].split("\\.")[1];
                String countryCode = newEmail.split("@")[1].split("\\.")[1];
                String domain = newEmail.split("@")[1].split("\\.")[0];
                if (countryCodes.contains(countryCode)
                        && firstName.toLowerCase().equals(this.fullName.split(" ")[0].toLowerCase())
                        && lastName.toLowerCase().equals(this.fullName.split(" ")[1].toLowerCase())) {
                    this.email = newEmail;
                } else {
                    throw new IllegalArgumentException(
                            "Mailen må være på denne formen: fornavn.etternavn@domene.landskode");
                }
            } else {
                throw new IllegalArgumentException(
                        "Mailen må være på denne formen: fornavn.etternavn@domene.landskode");
            }
        } else {
            throw new IllegalArgumentException("Mailen må være på denne formen: fornavn.etternavn@domene.landskode");
        }
    }

    /**
     * Method to set the new birtday to this person
     * 
     * @param newBirthday the new birtday
     */
    public void setBirthday(Date newBirthday) {
        Date currentDate = new Date();
        if (newBirthday.before(currentDate)) {
            this.birthday = newBirthday;
        } else {
            throw new IllegalArgumentException("Datoen kan ikke være frem i tid");
        }
    }

    /**
     * Method to set the SSN to this person
     * 
     * @param newSSN the new SSN
     */
    public void setSSN(String newSSN) {
        if (validSSN(newSSN)) {
            this.SSN = newSSN;
        } else {
            throw new IllegalArgumentException("Not valid social security number");
        }
    }

    /**
     * Method to validate the new SSN to this person
     * 
     * @param newSSN the new SSN
     * @return true if the new SSN if valid, false otherwise
     */
    public boolean validSSN(String newSSN) {
        if (newSSN.length() != 11) {
            return false;
        }

        for (int i = 0; i < newSSN.length(); i++) {
            if (!Character.isDigit(newSSN.charAt(i))) {
                return false;
            }
        }

        @SuppressWarnings("deprecation")
        int day = this.birthday.getDay();
        @SuppressWarnings("deprecation")
        int month = this.birthday.getMonth();
        @SuppressWarnings("deprecation")
        int year = this.birthday.getYear();
        // TODO
        return true;

    }

    /**
     * Method to set the new gender to this person
     * 
     * @param newGender the new gender
     */
    public void setGender(char newGender) {
        if (newGender == 'M' || newGender == 'F' || newGender == '\0') {
            this.gender = newGender;
        } else {
            throw new IllegalArgumentException("Kjønnet skal være på formen M, F eller \0");
        }
    }

    /**
     * Method to get the name to this person
     * 
     * @return the name
     */
    public String getName() {
        return this.fullName;
    }

    /**
     * Method to get the email to this person
     * 
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Method to get the birtday to this person
     * 
     * @return the birtday
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * Method to get the gender to this person
     * 
     * @return the gender
     */
    public char getGender() {
        return this.gender;
    }

    /**
     * Method to get the SSN to this person
     * 
     * @return the SSN
     */
    public String getSSN() {
        return this.SSN;
    }

    public static void main(String[] args) {
        Person person = new Person();
    }
}
