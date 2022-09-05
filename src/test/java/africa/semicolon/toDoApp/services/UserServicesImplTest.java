package africa.semicolon.toDoApp.services;

import africa.semicolon.toDoApp.data.repositories.iUserRepository;
import africa.semicolon.toDoApp.data.repositories.UserRepositoryImpl;
import africa.semicolon.toDoApp.dtos.request.LoginRequest;
import africa.semicolon.toDoApp.dtos.request.RegisterRequest;
import africa.semicolon.toDoApp.exceptions.DuplicateUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServicesImplTest {
    private UserServices userServices;
    private iUserRepository userRepository;

    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImpl();
        userServices = new UserServicesImpl(userRepository);
    }

    @Test
    public void registerUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("sandra@email.go");
        registerRequest.setFirstName("Sandra");
        registerRequest.setLastName("Kevin");
        registerRequest.setPassword("iLoveJesus222");
        userServices.registerUser(registerRequest);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void duplicateEmailCannotRegisterTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("sandra@email.go");
        registerRequest.setFirstName("Sandra");
        registerRequest.setLastName("Kevin");
        registerRequest.setPassword("iLoveJesus222");
        userServices.registerUser(registerRequest);
        assertThrows(DuplicateUserException.class, ()-> userServices.registerUser(registerRequest));
        assertEquals(1, userRepository.count());

    }
    @Test
    public void returnedFieldAfterRegisterWorks(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("sandra@email.go");
        registerRequest.setFirstName("Sandra");
        registerRequest.setLastName("Kevin");
        registerRequest.setPassword("iLoveJesus222");
        var returned =userServices.registerUser(registerRequest);
        assertEquals(1, userRepository.count());
        assertEquals(returned.getEmail() , registerRequest.getEmail());
        assertEquals("Sandra Kevin", returned.getFullName());
        System.out.println(returned);

    }
    @Test
    public void registerUserCanLoginTest(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("sandra@email.go");
        loginRequest.setPassword("iLoveJesus222");
        userServices.loginUser(loginRequest);
        assertEquals(1, userRepository.count());
    }

//    private UserRepository userRepository;
//
//    @BeforeEach
//    public void setUp(){
//        userRepository = new UserRepositoryImpl();
//        UserServices userServices = new UserServicesImpl();
//    }
//    @Test
//    public void addUserTest(){
////        userServices.addUser("Sandra","Kevin","sandra@mail.com", "ILoveJesus222");
////        var contact = userServices.findById("Sandra");
//
////        assertEquals("Sandra",contact.getFirstName());
////        assertEquals("Kevin",contact.getLastName());
////        assertEquals("sandra@mail.com",contact.getEmail());
//        User user = new User();
//        user.setEmail("sandra@mail.com");
//        user.setFirstName("Sandra");
//        user.setLastName("Kevin");
//        user.setPassword("ILoveJesus222");
//
//        userRepository.save(user);
//        assertEquals(1, userRepository.count());
//    }
//
//    @Test
//    public void findByEmailTest() {
//        User user = new User();
//        user.setEmail("cassandra@mail.com");
//        user.setFirstName("cassandra");
//        user.setLastName("oliver");
//        user.setPassword("ILoveJesus222");
//
//        userRepository.save(user);
//        User savedUser = userRepository.findByEmail("cassandra@mail.com");
//        assertEquals("cassandra@mail.com", savedUser.getEmail());
//    }
}