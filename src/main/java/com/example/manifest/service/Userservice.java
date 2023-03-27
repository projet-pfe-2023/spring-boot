package com.example.manifest.service;
import com.example.manifest.Entity.Login;
import com.example.manifest.Entity.User;
import com.example.manifest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class Userservice {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() { return repository.findAll(); }

    public User finduserById(Long id) {
        Optional<User> utOptional = repository.findById(id);
        if (utOptional.isEmpty()) {
            return null;
        } else {
            return utOptional.get();
        }
    }

    public User addUser(User user) {
        return repository.save(user);
    }


    public void deleteUser(Long id) {
        repository.deleteById(id);
    }


    public User updateUser(User user) {
        Optional<User> utOptional = repository.findById(user.getId());
        if (utOptional.isEmpty()) {
            return null;
        } else {
            return repository.save(user);
        }
    }

    public Long save(User user) {
        return repository.save(user).getId();
    }
    public List<User>all(){
        return repository.findAll();
    }
    public ResponseEntity<String>Login(Login login){
        if(repository.findUserByEmailAndPassword(login.getEmail(),login.getPassword())!=null){
            return ResponseEntity.ok("user your loged");
        }else{
            return ResponseEntity.ofNullable("not exist");
        }
    }


}
