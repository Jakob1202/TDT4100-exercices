package oving4;

import java.util.ArrayList;

import oving4.Person;

public class Person {
    private String name;
    private char gender;
    private Person mother;
    private Person father;
    private ArrayList<Person> children;

    /**
     * Constructor for person
     * 
     * @param name   the name to this person
     * @param gender the gender to this person
     */
    public Person(String name, char gender) {
        if (gender == 'F' || gender == 'M') {
            this.name = name;
            this.gender = gender;
            this.mother = null;
            this.father = null;
            this.children = new ArrayList<>();
        } else {
            throw new IllegalArgumentException("The gender must be F or M");
        }
    }

    /**
     * Method to add a new child to this person
     * 
     * @param newChild the child
     */
    public void addChild(Person newChild) {
        if (this.children.contains(newChild)) {
            throw new IllegalArgumentException("The parent has this child already");
        }

        if (this.getGender() == 'F') {
            if (newChild.mother != null) {
                newChild.mother.removeChild(newChild);
            }

            newChild.mother = this;
        } else {
            if (newChild.father != null) {
                newChild.father.removeChild(newChild);
            }
            newChild.father = this;
        }

        this.children.add(newChild);

    }

    /**
     * Method to remove the old child from this person
     * 
     * @param oldChild the old child
     */
    public void removeChild(Person oldChild) {
        if (!(this.children.contains(oldChild))) {
            throw new IllegalArgumentException("You dont have this child");
        }

        this.children.remove(oldChild);
    }

    /**
     * Method to set a new mother to this person
     * 
     * @param newMother the new mother
     */
    public void setMother(Person newMother) {
        if (newMother.gender != 'F') {
            throw new IllegalArgumentException("A mother must be a woman");
        }

        if (newMother.equals(this)) {
            throw new IllegalArgumentException("You cant be your own mother");
        }

        Person oldMother = this.mother;

        if (!(oldMother == null)) {
            oldMother.removeChild(this);
        }

        this.mother = newMother;
        this.mother.children.add(this);

    }

    /**
     * Method to set a new father to this person
     * 
     * @param newFather the new father
     */
    public void setFather(Person newFather) {
        if (newFather.gender != 'M') {
            throw new IllegalArgumentException("A father must be a man");
        }

        if (newFather.equals(this)) {
            throw new IllegalArgumentException("You cant be your own father");
        }

        Person oldFather = this.father;

        if (!(oldFather == null)) {
            oldFather.removeChild(this);
        }

        this.father = newFather;
        this.father.children.add(this);
    }

    /**
     * Method to get the name to this person
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
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
     * Method to get the mother to this person
     * 
     * @return the mother
     */
    public Person getMother() {
        return this.mother;
    }

    /**
     * Method to get the father to this person
     * 
     * @return the father
     */
    public Person getFather() {
        return this.father;
    }

    /**
     * Method to get the numbers of childrens to this person
     * 
     * @return the number of childrens
     */
    public int getChildCount() {
        return children.size();
    }

    /**
     * Method to get the children number i to this person
     * 
     * @param n number i
     * @return the children
     */
    public Person getChild(int n) {
        if (n < 0 || n >= this.children.size()) {
            throw new IllegalArgumentException("Not valid index");
        }
        return this.children.get(n);

    }

}
