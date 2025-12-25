// package com.example.demo.service;

// import com.example.demo.entity.User;
// import java.util.List;

// public interface UserService {

//     User createUser(User user);

//     User getUserById(Long id);

//     List<User> getAllUsers();   

//     User updateUser(Long id, User user);

//     void deleteUser(Long id);
// }
package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
}
