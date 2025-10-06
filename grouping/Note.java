import java.util.ArrayList;
import java.util.Scanner;

class Note {
    private String title;
    private String content;
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }


    @Override
    public String toString() {
        return "Judul: " + title + "\nIsi: " + content;
    }
}