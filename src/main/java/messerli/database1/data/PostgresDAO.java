package messerli.database1.data;

import java.sql.Connection;
import java.util.List;

public interface PostgresDAO {

    List<String> select(Connection conn);

    int update(Connection conn);

    List<String> drop(Connection conn);

    List<String> create(Connection conn);

    List<String> list(Connection conn);

    List<String> percent(Connection conn);
}
