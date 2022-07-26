package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.models.User;
import africa.semicolon.toDoApp.data.repositories.UserRepository;
import africa.semicolon.toDoApp.data.repositories.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServicesImplTest {
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImpl();
        UserServices userServices = new UserServicesImpl();
    }
    @Test
    public void addUserTest(){
//        userServices.addUser("Sandra","Kevin","sandra@mail.com", "ILoveJesus222");
//        var contact = userServices.findById("Sandra");

//        assertEquals("Sandra",contact.getFirstName());
//        assertEquals("Kevin",contact.getLastName());
//        assertEquals("sandra@mail.com",contact.getEmail());
        User user = new User();
        user.setEmail("sandra@mail.com");
        user.setFirstName("Sandra");
        user.setLastName("Kevin");
        user.setPassword("ILoveJesus222");

        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void findByEmailTest() {
        User user = new User();
        user.setEmail("cassandra@mail.com");
        user.setFirstName("cassandra");
        user.setLastName("oliver");
        user.setPassword("ILoveJesus222");

        userRepository.save(user);
        User savedUser = userRepository.findByEmail("cassandra@mail.com");
        assertEquals("cassandra@mail.com", savedUser.getEmail());
    }
}