package africa.semicolon.toDoApp;

import africa.semicolon.toDoApp.controller.UserController;
import africa.semicolon.toDoApp.dtos.request.AddTaskRequest;
import africa.semicolon.toDoApp.dtos.request.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
public class Main {

    private static final Scanner keyboardInput = new Scanner(System.in);
    private static UserController userController = new UserController();

    public static void main(String[] args) { displayMainMenu(); }



    private static void displayMainMenu() {
        String mainMenuPrompt = """
                Welcome to To-Do App
                1-> Create an Account
                2 -> Add Task
                3 -> Find Task
                """;

        String userInput = input(mainMenuPrompt);
        switch (userInput.charAt(0)) {
            case '1' -> createAnAccount();
            case '2' -> addTask();
            case '3' -> findTask();
        }
    }

    private static void findTask() {
        var tasks = userController.findTask(input("find a task"));
//        for(var task: tasks){
//            displayMainMenu();
//        }
        displayMainMenu();
    }

    private static void addTask() {
        AddTaskRequest taskRequest = new AddTaskRequest();
        taskRequest.setTask(input("Enter a Task"));
        userController.addTask(taskRequest);
        displayMainMenu();
    }

    private static void createAnAccount() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input("Enter first name: "));
        request.setLastName( input("Enter last name: "));
        request.setEmail(input("Enter email: "));
        request.setPassword( input("Enter password"));
        userController.registerUser(request);
        display("done");
        displayMainMenu();
    }
    private static void display(String message) {
        System.out.println(message);
    }

    private static String input(String prompt) {
        display(prompt);
        return keyboardInput.nextLine();
    }
}
