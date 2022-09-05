package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.repositories.TaskRepository;
import africa.semicolon.toDoApp.data.repositories.TaskRepositoryImpl;
import africa.semicolon.toDoApp.dtos.request.AddTaskRequest;
import africa.semicolon.toDoApp.exceptions.DuplicateTaskException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServicesImplTest {
    private TaskServices taskServices;
    private TaskRepository taskRepository;

    @BeforeEach
    public void setUp(){
        taskRepository = new TaskRepositoryImpl();
        taskServices = new TaskServicesImpl(taskRepository);
    }

    @Test
    public void addTaskTest(){
        AddTaskRequest addTaskRequest = new AddTaskRequest();
        addTaskRequest.setTask("write python script");
        taskServices.addTask(addTaskRequest);
        assertEquals(1, taskRepository.count());
    }

    @Test
    public void cannotHaveDuplicateTaskTest(){
        AddTaskRequest addTaskRequest = new AddTaskRequest();
        addTaskRequest.setTask("write python script");
        taskServices.addTask(addTaskRequest);
        assertThrows(DuplicateTaskException.class, ()-> taskServices.addTask(addTaskRequest));
        assertEquals(1, taskRepository.count());
    }

    @Test
    public void returnedFieldAfterAddingTasks(){
        AddTaskRequest addTaskRequest = new AddTaskRequest();
        addTaskRequest.setTask("write python script");
        var returned = taskServices.addTask(addTaskRequest);
        assertEquals(1, taskRepository.count());
        assertEquals(returned.getTask() , addTaskRequest.getTask());
        assertEquals("write python script", returned.getTask());
//        System.out.println(returned);

    }
}