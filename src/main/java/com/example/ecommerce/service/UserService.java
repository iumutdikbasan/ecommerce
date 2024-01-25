package com.example.ecommerce.service;

import com.example.ecommerce.general.BaseEntityService;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseEntityService<User, UserRepository> {
    private final UserRepository userRepository;
    public UserService(UserRepository repository, UserRepository userRepository) {
        super(repository);
        this.userRepository = userRepository;
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user != null)
            userRepository.delete(user);

    }

    public User update(User user, Long id){
        User user1 = userRepository.findById(id).orElseThrow();  //hata
        user1.setUsername(user.getUsername());
        user1.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(user1);

    }

}
