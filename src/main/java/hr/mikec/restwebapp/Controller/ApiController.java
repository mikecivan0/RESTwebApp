package hr.mikec.RESTwebApp.Controller;

import hr.mikec.RESTwebApp.Model.User;
import hr.mikec.RESTwebApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/user/save")
    public String saveUser(@RequestBody User user){
        userRepository.save(user);
        return "New user is saved";
    }

    @PutMapping(value = "user/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepository.save(updatedUser);
        return "User is updated";
    }

    @DeleteMapping(value = "user/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        User deletedUser = userRepository.findById(id).get();
        userRepository.delete(deletedUser);
        return "User is deleted";
    }
}
