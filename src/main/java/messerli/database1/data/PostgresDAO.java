package messerli.database1.data;

import java.sql.Connection;
import java.util.List;

public interface PostgresDAO {

    List<String> select(Connection conn);

    List<String> update(Connection conn);

    List<String> drop(Connection conn);

    void create(Connection conn);
}
