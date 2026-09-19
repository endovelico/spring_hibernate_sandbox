import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

public class QUser extends EntityPathBase<User> {

    public static final QUser user =
            new QUser("user");

    public final NumberPath<Long> id =
            createNumber("id", Long.class);

    public final StringPath name =
            createString("name");

    public final NumberPath<Integer> age =
            createNumber("age", Integer.class);

    public final StringPath country =
            createString("country");

    public QUser(String variable) {
        super(User.class, variable);
    }
}