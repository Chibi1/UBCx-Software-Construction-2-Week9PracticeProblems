package model;

public class Task extends Doable {

    private String description;
    private String date;
    private String location;
//    private boolean isComplete;

    public Task(String description, String date, String location) {
        this.description = description;
        this.date = date;
        this.location = location;
//        isComplete = false;
    }

    // getters
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public boolean getStatus() { return isComplete; }

    // setters
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String getDescription() {
        return description + " on " + getDate() + " @" + getLocation();
    }

//    @Override
//    public void complete() {
//        if (!isComplete) {
//            isComplete = true;
//        }
//    }

    @Override
    public void display(String indentSpace) {
        System.out.println(indentSpace + this.getDescription());
    }


}