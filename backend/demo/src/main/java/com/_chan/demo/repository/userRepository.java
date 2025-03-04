package com._chan.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com._chan.demo.model.User;
import java.util.List;



@Repository
public interface userRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
