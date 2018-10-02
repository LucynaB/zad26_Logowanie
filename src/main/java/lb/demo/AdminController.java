package lb.demo;

import lb.demo.user.User;
import lb.demo.user.UserRepository;
import lb.demo.user.UserRole;
import lb.demo.user.UserRoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;

    public AdminController(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @GetMapping("/users")
    public String userList(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);

        return "users";
    }

    @GetMapping("/uprawnienia")
    public String uprawnienia(@RequestParam Long id, Model model) {
        Optional<User> optional = userRepository.findById(id);
        User user = optional.get();
        List<UserRole> roleList = userRoleRepository.findAll();
        model.addAttribute("roles", roleList);
        model.addAttribute("user", user);

        return "uprawnienia";

    }


    @PostMapping("/addRole")
    public String addRole(@RequestParam String userName, @RequestParam String selectedRole) {
        UserRole userRole = new UserRole(userName, selectedRole);
        userRoleRepository.save(userRole);
        return "redirect:/menu";
    }

    @GetMapping("/removeRole")
    public String delete(@RequestParam Long id) {
        userRoleRepository.deleteById(id);
        return "redirect:/menu";
    }


}
