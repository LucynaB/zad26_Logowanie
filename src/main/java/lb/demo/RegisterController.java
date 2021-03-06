package lb.demo;

import lb.demo.user.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public RegisterController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/rejestracja")
    public String registerForm(){
        return "register";
    }

    @PostMapping("/rejestracja")
    public String register(@RequestParam String username,@RequestParam String password){
        userService.addUser(username, password);
        return "redirect:/login";
    }


}
