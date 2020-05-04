package fr.ulille.iut.agile;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteDataSource;

import javax.inject.Singleton;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@Singleton
public class BDDFactory {
    private static Jdbi jdbi = null;
    private static final Logger LOGGER = Logger.getLogger(BDDFactory.class.getName());

    private BDDFactory() {
        throw new IllegalStateException("Do not use this constructor");
    }

    private static Jdbi getJdbi() {
        if(jdbi == null) {
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl("jdbc:sqlite:" + System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") + "data.db");
            jdbi = Jdbi.create(ds);
            jdbi.installPlugin(new SqlObjectPlugin());
            LOGGER.log(Level.INFO, "user.dir : {0}", System.getProperty("user.dir"));
            LOGGER.log(Level.INFO, "java.io.tmpdir : {0}", System.getProperty("java.io.tmpdir"));
        }
        return jdbi;
    }

    static boolean tableExist(String tableName) throws SQLException {
        try(Handle handle = getJdbi().open()) {
            DatabaseMetaData dbm = handle.getConnection().getMetaData();
            ResultSet tables = dbm.getTables(null, null, tableName, null);
            boolean exist = tables.next();
            tables.close();
            return exist;
        }
    }

    public static <T> T buildDao(Class<T> daoClass) {
        return getJdbi().onDemand(daoClass);
    }
}

