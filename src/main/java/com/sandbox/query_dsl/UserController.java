import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/adults")
    public List<User> getAdults() {
        return userService.getAdults();
    }

    @GetMapping("/users/search")
    public List<User> searchUsers(

            @RequestParam(required = false)
            String name,

            @RequestParam(required = false)
            Integer minimumAge,

            @RequestParam(required = false)
            String country

    ) {
        return userService.searchUsers(
                name,
                minimumAge,
                country
        );
    }
}