package model;

public abstract class Doable {
    public boolean isComplete;

    public Doable() {
        this.isComplete = false;
    }

    public abstract String getDescription();

    public boolean getIsComplete(){ return this.isComplete; }

    public void complete() {
        if (!isComplete) {
            isComplete = true;
        }
    }

    public abstract void display(String indentSpace);

}
