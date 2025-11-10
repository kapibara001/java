package exersize;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Films")
public class Film {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String title;
    
    @DatabaseField
    private String year;

    @DatabaseField
    private String runTime;

    public Film() {

    };

    public Film(String stringFilm) {
        JsonObject jsonObject = JsonParser.parseString(stringFilm).getAsJsonObject();

        System.out.println(jsonObject.get("Title").getAsString());

        this.title = jsonObject.get("Title").getAsString();
        this.year = jsonObject.get("Year").getAsString();
        this.runTime = jsonObject.get("Runtime").getAsString();
    }

    public String toString() {
        return id + " " + title + " " + year + " " + runTime;
    }
}
