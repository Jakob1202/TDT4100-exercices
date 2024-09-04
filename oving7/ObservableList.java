package oving7;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableList {
    private List<ObservableListListener> listeners = new ArrayList<>();
    private List<Object> list = new ArrayList<>();

    /**
     * Method to get the size of this high score list
     * 
     * @return
     */
    public int size() {
        return this.list.size();
    }

    /**
     * Method to get a result from this high score list
     * 
     * @param position the position to the result
     * @return the result
     */
    public Object getElement(int position) {
        if (position < 0 || position >= this.list.size()) {
            throw new IllegalArgumentException("The result is not in the list");
        } else {
            return this.list.get(position);
        }
    }

    /**
     * Method to add an element to a postion to this observable list
     * 
     * @param position the position
     * @param element  the element
     */
    public void addElement(int position, Object element) {
        if (!this.acceptsElement(element)) {
            throw new IllegalArgumentException("The element is not accepted for this list");
        } else {
            this.list.add(position, element);
        }

        this.notifyListeners(position);

        // TODO: validering IndexOutOfBoundsException
    }

    /**
     * Method to add an element to at the end to this observable list
     * 
     * @param element the element
     */
    public void addElement(Object element) {
        this.addElement(this.size(), element);
    }

    /**
     * Method to remove an element to a postion to this observable list
     * 
     * @param position the position
     * @param element  the element
     */
    public void removeElement(int position) {
        if (position < 0 || position >= this.list.size()) {
            throw new IndexOutOfBoundsException("Illegal position for this element");
        } else {
            this.list.remove(position);
        }
    }

    /**
     * Abstract method to check if this observable list accepts the object
     * 
     * @param element the object
     * @return true if the observable list accepts the element, false otherwise
     */
    public abstract boolean acceptsElement(Object element);

    /**
     * Method to add a listener to this high score list
     * 
     * @param listener the listener
     */
    public void addObservableListListener(ObservableListListener listener) {
        if (this.listeners.contains(listener)) {
            throw new IllegalArgumentException("The listener is already an observer");
        } else {
            this.listeners.add(listener);
        }
    }

    /**
     * Method to remove a listener to this high score list
     * 
     * @param listener the listener
     */
    public void removeObservableListListener(ObservableListListener listener) {
        if (!this.listeners.contains(listener)) {
            throw new IllegalArgumentException("The listener is not an observer");
        } else {
            this.listeners.remove(listener);
        }
    }

    public void notifyListeners(int position) {
        this.listeners.stream().forEach(listener -> listener.listChanged(this.list, position));
    }

     /**
     * Method to get the listeners to this observable list
     * @return the listeners
     */
    public List<ObservableListListener> getListeners() {
        return listeners;
    }

    /**
     * Method to get the new listeners to this observable list
     * @param newListeners the new listeners
     */
    public void setListeners(List<ObservableListListener> newListeners) {
        this.listeners = newListeners;
    }

    /**
     * Method to get the list to this observable list
     * @return the list
     */
    public List<Object> getList() {
        return this.list;
    }

     /**
     * Method to set the list to this observable list
     * @param newList the new list
     */
    public void setList(List<Object> newList) {
        this.list = newList;
    }

}
