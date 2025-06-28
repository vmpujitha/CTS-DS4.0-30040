package com.cts.demo.respository;

import com.cts.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRespository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}