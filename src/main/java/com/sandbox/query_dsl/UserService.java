import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;

    public UserService(
            UserRepository userRepository,
            UserQueryRepository userQueryRepository
    ) {
        this.userRepository = userRepository;
        this.userQueryRepository =
                userQueryRepository;
    }

    public List<User> getAdults() {
        return userQueryRepository.findAdults();
    }

    public List<User> searchUsers(
            String name,
            Integer minimumAge,
            String country
    ) {
        return userQueryRepository.findUsers(
                name,
                minimumAge,
                country
        );
    }
}