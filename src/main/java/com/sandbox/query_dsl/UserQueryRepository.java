import java.util.List;

public interface UserQueryRepository {

    List<User> findAdults();

    List<User> findUsers(
            String name,
            Integer minimumAge,
            String country
    );
}