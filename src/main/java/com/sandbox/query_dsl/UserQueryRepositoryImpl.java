import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserQueryRepositoryImpl
        implements UserQueryRepository {

    private final JPAQueryFactory queryFactory;

    public UserQueryRepositoryImpl(
            JPAQueryFactory queryFactory
    ) {
        this.queryFactory = queryFactory;
    }

    @Override
    public List<User> findAdults() {

        QUser user = QUser.user;

        return queryFactory
                .selectFrom(user)
                .where(user.age.goe(18))
                .fetch();
    }

    @Override
    public List<User> findUsers(
            String name,
            Integer minimumAge,
            String country
    ) {

        QUser user = QUser.user;

        BooleanBuilder predicate =
                new BooleanBuilder();

        if (name != null) {
            predicate.and(
                    user.name.containsIgnoreCase(name)
            );
        }

        if (minimumAge != null) {
            predicate.and(
                    user.age.goe(minimumAge)
            );
        }

        if (country != null) {
            predicate.and(
                    user.country.eq(country)
            );
        }

        return queryFactory
                .selectFrom(user)
                .where(predicate)
                .fetch();
    }
}