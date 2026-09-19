package main.java.com.sandbox.query_hints;

public interface UserRepository
        extends JpaRepository<User, Long> {

    @Query("""
        SELECT u
        FROM User u
        WHERE u.active = true
    """)
    @QueryHints({
            @QueryHint(
                    name = "org.hibernate.readOnly",
                    value = "true"
            )
    })
    List<User> findActiveUsers();
}