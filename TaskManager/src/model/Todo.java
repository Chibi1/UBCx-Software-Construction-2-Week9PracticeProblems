package model;

import java.util.LinkedList;
import java.util.List;


public class Todo extends Doable {

    private String description;
    private List<Doable> subDoables;


    public Todo(String description) {
        this.description = description;
        subDoables = new LinkedList<>();
    }

    // getters
    public List<Doable> getSubDoables() { return subDoables; }
    public boolean getStatus() { return isComplete; }
    @Override
    public String getDescription() { return this.description; }

    //setter
    public void setIsComplete() {
        isComplete = doableComplete();
    }

    public boolean addDoable(Doable doable) {
        if (!subDoables.contains(doable)) {
            subDoables.add(doable);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeDoable(Doable doable) {
        if (subDoables.contains(doable)) {
            subDoables.remove(doable);
            return true;
        }  else {
            return false;
        }
     }

    public boolean doableComplete() {
        boolean areDoablesComplete = false;
        for (Doable doable : subDoables) {
            if (doable.getIsComplete()) {
                areDoablesComplete = true;
            }
        }
        return areDoablesComplete;
    }

    @Override
    public void display(String indentSpace) {
        System.out.println(indentSpace + getDescription());
        for (Doable doable : subDoables) {
            doable.display(indentSpace + indentSpace);
        }

    }
}