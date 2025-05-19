import java.util.*;
// Problem entity
public class Problem {
    private int id;
    private String title;
    private String description;
    private String difficulty;

    public Problem(int id, String title, String description, String difficulty) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getDifficulty() { return difficulty; }

    @Override
    public String toString() {
        return id + ". " + title + " (" + difficulty + ")";
    }
}