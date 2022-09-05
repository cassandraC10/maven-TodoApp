package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.Task;
import africa.semicolon.toDoApp.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskRepositoryImplTest {
    private TaskRepository taskRepository;
    @BeforeEach
    public void setUp(){
        taskRepository = new TaskRepositoryImpl();
    }

    @Test
    public void saveTaskTest(){
        Task task = new Task();
        task.setTask("write python script");
        taskRepository.save(task);
        assertEquals(1, taskRepository.count());
    }

    @Test
    public void findByIdTaskExistTest(){
        Task task = new Task();
        task.setTask("write python script");
        taskRepository.save(task);
        Task savedTask = taskRepository.findById(1);
        assertEquals("write python script", savedTask.getTask());
    }

    @Test
    public void addAnotherTaskTest(){
        Task task = new Task();
        task.setTask("sweep the floor");

        Task task1 = new Task();
        task1.setTask("mop the kitchen");

        Task task2 = new Task();
        task2.setTask(" do the laundry");

        taskRepository.save(task);
        taskRepository.save(task1);
        taskRepository.save(task2);
        assertEquals(3, taskRepository.count());
        // I want to add date(with getters and setters to these tasks
//      so I can also find by date
    }

    @Test
    public void findAllTest(){
        Task task = new Task();
        task.setTask("sweep the floor");

        Task task1 = new Task();
        task1.setTask("mop the kitchen");

        Task task2 = new Task();
        task2.setTask(" do the laundry");

        taskRepository.save(task);
        taskRepository.save(task1);
        taskRepository.save(task2);
        assertEquals(3, taskRepository.count());

        List<Task> result = taskRepository.findAll();
        assertEquals(3, result.size());
    }

    @Test
    public void deleteTaskTest(){
        Task task = new Task();
        task.setTask("read");

        Task task1 = new Task();
        task1.setTask("study");

        taskRepository.save(task);
        taskRepository.save(task);

        Task savedTask = taskRepository.findById(2);
        assertEquals(2, taskRepository.count());

        taskRepository.delete(1);

        assertEquals("read", savedTask.getTask());
        assertEquals(1, taskRepository.count());
    }

    @Test
    public void findTaskByName(){
        Task task = new Task();
        task.setTask("sweep the floor");

        Task task1 = new Task();
        task1.setTask("mop the kitchen");

        Task task2 = new Task();
        task2.setTask(" do the laundry");

        taskRepository.save(task);
        taskRepository.save(task1);
        taskRepository.save(task2);
        assertEquals(3, taskRepository.count());

        Task savedTask = taskRepository.findByTask("sweep the floor");
        assertEquals("sweep the floor", savedTask.getTask());
    }
}