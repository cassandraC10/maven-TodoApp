package africa.semicolon.toDoApp.data.repositories;

import africa.semicolon.toDoApp.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImpl();
    }

    @Test
    public void saveUserTest(){
        User user = new User();
        user.setEmail("sandra@mail.com");
        user.setFirstName("Sandra");
        user.setLastName("Kevin");
        user.setPassword("ILoveJesus222");

        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void saveNewUserFindById_userExistsTest(){
        User user = new User();
        user.setEmail("sandra@mail.com");
        user.setFirstName("Sandra");
        user.setLastName("Kevin");
        user.setPassword("ILoveJesus222");

        userRepository.save(user);
        User savedUser = userRepository.findById(1);
        assertEquals("Sandra", savedUser.getFirstName());
        assertEquals("Kevin", savedUser.getLastName());
        assertEquals("sandra@mail.com", savedUser.getEmail());
    }

    @Test
    public void deleteUserTest(){
        User user = new User();
        user.setEmail("sandra@mail.com");
        user.setFirstName("Sandra");
        user.setLastName("Kevin");
        user.setPassword("ILoveJesus222");

        userRepository.save(user);
        User savedUser = userRepository.findById(1);
        assertEquals(1, userRepository.count());

        userRepository.delete(1);

        assertEquals("Sandra", savedUser.getFirstName());
        assertEquals("Kevin", savedUser.getLastName());
        assertEquals("sandra@mail.com", savedUser.getEmail());
        assertEquals(0, userRepository.count());
    }

    @Test
    public void addAnotherUserTest(){
        User user = new User();
        user.setEmail("sandra@mail.com");
        user.setFirstName("Sandra");
        user.setLastName("Kevin");
        user.setPassword("ILoveJesus222");

        User anotherUser = new User();
        anotherUser.setEmail("cassandra@mail.com");
        anotherUser.setFirstName("Cassandra");
        anotherUser.setLastName("Oliver");
        anotherUser.setPassword("beautiful123");

        User user1 = new User();
        user1.setEmail("alex@mail.com");
        user1.setFirstName("Alex");
        user1.setLastName("Peter");
        user1.setPassword("AlexPeter123");

        userRepository.save(user);
        userRepository.save(anotherUser);
        userRepository.save(user1);
        assertEquals(3, userRepository.count());
    }

    @Test
    public void findAllTest(){
        User user = new User();
        user.setEmail("sandra@mail.com");
        user.setFirstName("Sandra");
        user.setLastName("Kevin");
        user.setPassword("ILoveJesus222");

        User anotherUser = new User();
        anotherUser.setEmail("cassandra@mail.com");
        anotherUser.setFirstName("Cassandra");
        anotherUser.setLastName("Oliver");
        anotherUser.setPassword("beautiful123");

        User user1 = new User();
        user1.setEmail("alex@mail.com");
        user1.setFirstName("Alex");
        user1.setLastName("Peter");
        user1.setPassword("AlexPeter123");

        userRepository.save(user);
        userRepository.save(anotherUser);
        userRepository.save(user1);
        assertEquals(3, userRepository.count());

        List<User> result = userRepository.findAll();
        assertEquals(3, result.size());
    }

    @Test
    public void findByFirstNameTest(){
        User user = new User();
        user.setEmail("sandra@mail.com");
        user.setFirstName("Sandra");
        user.setLastName("Kevin");
        user.setPassword("ILoveJesus222");

        User anotherUser = new User();
        anotherUser.setEmail("cassandra@mail.com");
        anotherUser.setFirstName("Cassandra");
        anotherUser.setLastName("Oliver");
        anotherUser.setPassword("beautiful123");

        User user1 = new User();
        user1.setEmail("alex@mail.com");
        user1.setFirstName("Alex");
        user.setLastName("Peter");
        user1.setPassword("AlexPeter123");

        userRepository.save(user);
        userRepository.save(anotherUser);
        userRepository.save(user1);
        assertEquals(3, userRepository.count());

        List <User> result = userRepository.findByFirstName("Cassandra");
        assertEquals(1, result.size());
    }

    @Test
    public void findByLastNameTest(){
        User user = new User();
        user.setEmail("sandra@mail.com");
        user.setFirstName("Sandra");
        user.setLastName("Kevin");
        user.setPassword("ILoveJesus222");

        User anotherUser = new User();
        anotherUser.setEmail("cassandra@mail.com");
        anotherUser.setFirstName("Cassandra");
        anotherUser.setLastName("Peter");
        anotherUser.setPassword("beautiful123");

        User user1 = new User();
        user1.setEmail("alex@mail.com");
        user1.setFirstName("Alex");
        user1.setLastName("Peter");
        user1.setPassword("AlexPeter123");

        userRepository.save(user);
        userRepository.save(anotherUser);
        userRepository.save(user1);
        assertEquals(3, userRepository.count());

        List <User> result = userRepository.findByLastName("Peter");
        assertEquals(2, result.size());
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