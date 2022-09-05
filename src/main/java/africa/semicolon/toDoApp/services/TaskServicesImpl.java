package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.repositories.TaskRepository;
import africa.semicolon.toDoApp.dtos.request.AddTaskRequest;
import africa.semicolon.toDoApp.dtos.responses.AddTaskResponse;
import africa.semicolon.toDoApp.exceptions.DuplicateTaskException;
import africa.semicolon.toDoApp.utils.Mapper;

public class TaskServicesImpl implements TaskServices{

    TaskRepository taskRepository;
    public TaskServicesImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public AddTaskResponse addTask(AddTaskRequest taskRequest) {
        Task savedTask = taskRepository.findByTask(taskRequest.getTask());
        if (savedTask != null) throw new DuplicateTaskException(String.format("%s already exists", taskRequest.getTask()));
        Task task = new Task();
        Mapper.map(taskRequest, task);
        Task saved = taskRepository.save(task);
        AddTaskResponse addTaskResponse = new AddTaskResponse();
        Mapper.map(saved, addTaskResponse);
        return addTaskResponse;
    }

//    @Override
//    public void addTask(String task, int date) {
//
//    }
//
//    @Override
//    public void deleteTask(User user) {
//
//    }
//
//    @Override
//    public void markAsDone(Task task) {
//
//    }
//
//    @Override
//    public void markAsDoing(Task task) {
//
//    }
//
//    @Override
//    public Task findTask() {
//        return null;
//    }
//
//    @Override
//    public User findById(String i) {
//        return null;
//    }
//
//    @Override
//    public List<User> findByName(String name) {
//        return null;
//    }
}
