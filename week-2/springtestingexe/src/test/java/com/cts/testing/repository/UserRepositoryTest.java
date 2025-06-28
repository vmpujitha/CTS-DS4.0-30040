package com.cts.testing.repository;


import com.cts.demo.respository.UserRespository;
import com.cts.demo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRespository UserRespository;

    @Test
    void findByName_shouldReturnCorrectUsers() {
        UserRespository.save(new User(1L, "John"));
        UserRespository.save(new User(2L, "Alice"));
        List<User> users = UserRespository.findByName("John");
        assertEquals(1, users.size());
        assertEquals("John", users.get(0).getName());
    }
}