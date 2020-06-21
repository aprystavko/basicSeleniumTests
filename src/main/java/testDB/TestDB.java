package testDB;

import libs.Database;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDB {
    static Logger logger = Logger.getLogger("TestDB");
    static Database dbMySQL;

    @Before
    public void setUp() throws SQLException, IOException, ClassNotFoundException {
        dbMySQL = new Database("MySQL_DB", "MySQL");
    }

    @Test
    public void testDB() throws SQLException {
        List<Map<String, String>> testData = dbMySQL.selectTable("select * from seleniumTable where login = 'test'");
        logger.info(testData);

        dbMySQL.changeTable("INSERT INTO seleniumTable VALUES ('696', 'AlexeyP', 'MyPersonalPassword')");
        List<Map<String, String>> myInsert = dbMySQL.selectTable("select * from seleniumTable where login = 'AlexeyP'");
        logger.info(myInsert);

        dbMySQL.changeTable("DELETE FROM seleniumTable WHERE login='Alexey'");
        List<Map<String, String>> myDelete = dbMySQL.selectTable("select * from seleniumTable where login = 'Alexey'");
        logger.info(myDelete);


/*        for (List<Map<String,String>> ourMap:
                testData) {
            logger.info(ourMap);
        }
    }*/

    }

    @After
    public void tearDown() throws SQLException {
        dbMySQL.quit();
    }

}
