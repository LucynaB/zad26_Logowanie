package lb.demo;

import lb.demo.user.User;
import lb.demo.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/editUser")
    public String edit(Principal principal, Model model) {
        String username = principal.getName();
        User user = userRepository.findByUserName(username);
        model.addAttribute("user", user);

        return "editUser";

    }

    @PostMapping("/editUser")
    public String edit(User user, @RequestParam String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return "redirect:/menu";
    }

    @GetMapping("/changePassword")
    public String passwordForm(Principal principal, Model model) {
        String username = principal.getName();
        User user = userRepository.findByUserName(username);
        model.addAttribute("user", user);

        return "changePassword";

    }

    @PostMapping("/changePassword")
    public String changePassword(User user, @RequestParam String username) {
       // user.setPassword(passwordEncoder.encode(password));
        user.setUserName(username);
        userRepository.save(user);
        return "redirect:/menu";
    }
}


