package main;

import model.Task;
import model.Todo;

public class main {
    public static void main(String[] args) {
        Todo mainTodo = new Todo("Throw Party");
        Todo todo1 = new Todo("Send out invitations");
        mainTodo.addDoable(todo1);
        Todo todo2 = new Todo("Get cake ingredients");
        mainTodo.addDoable(todo2);
        Todo todo3 = new Todo("Bake cake and food");
        mainTodo.addDoable(todo3);

        Task task1 = new Task("Buy flour", "19/12/2017", "Whole Foods");
        todo2.addDoable(task1);
        Task task2 = new Task("Get a new cake tin", "09/12/2017", "Williams Sonoma");
        todo2.addDoable(task2);
        Task task3 = new Task("Buy a dozen eggs", "09/12/2017", "Farmer's Market");
        todo2.addDoable(task3);
        Task task4 = new Task("Mix flour", "09/14/2017", "Anna's house");
        todo3.addDoable(task4);
        Task task5 = new Task("Grill fillet of sole", "09/14/2017", "Anna's grill");
        todo3.addDoable(task5);

        mainTodo.display("  ");
    }
}
