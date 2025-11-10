package exersize;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws Exception, SQLException {
        while(true) {
            // 1: HTTP
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите полное или неполное название фильма: ");
            String filmname = scanner.nextLine().trim();
    
            String response = FilmFetcher.fetchFilm(filmname);

            // Запись в файл, создание и запись в бд
            Path path = Paths.get("output.txt");

            if (filmname.equals("qqqq")) {
                System.exit(0);;
            } else if (response.equals("{\"Response\":\"False\",\"Error\":\"Movie not found!\"}")) {
                System.out.println("Этого фильма не существует");
            } else {
                FileManager.writeToFile(path, response);
                BDFilmDoings.InfoToDB(response);

                Runtime.getRuntime().exec("notepad " + path); // Открытие блокнота

                System.out.println("Содержимое файла: ");
                String contentFromFile = FileManager.readFromFile(path);
                System.out.println(contentFromFile);
                
                System.out.println("Данные записаны в файл и БД.");

                BDFilmDoings.listDataInDB();
                BDFilmDoings.closeCon();
            }
        }
    }
}