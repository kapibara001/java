package exersize;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class BDFilmDoings {
    private static final String DB_URL = "jdbc:sqlite:createdb.db";
    private static ConnectionSource connectionSource;
    private static Dao<Film, Integer> filmDao;


    static {
        try {
            connectionSource = new JdbcConnectionSource(DB_URL);
            TableUtils.createTableIfNotExists(connectionSource, Film.class);
            filmDao = DaoManager.createDao(connectionSource, Film.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void InfoToDB(String response) {
        try {
            Film film = new Film(response);
            filmDao.create(film);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listDataInDB() {
        try {
            List<Film> films = filmDao.queryForAll();
            System.out.println();
            System.out.println("--------------------------- Films Log ---------------------------");
            for (Film f : films) {
                System.out.println(f);
            }
            System.out.println("-----------------------------------------------------------------");
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Закрытие соединения
    public static void closeCon() throws Exception {
        try {
            if (connectionSource != null) {
                connectionSource.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
