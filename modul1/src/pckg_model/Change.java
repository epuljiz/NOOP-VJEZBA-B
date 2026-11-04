package pckg_model;

import java.time.LocalDateTime;

public class Change {

    private String description;
    private LocalDateTime timestamp;
    private String code;
    private Collaborator author;


    public Change(String description, LocalDateTime timestamp, String code, Collaborator author) {
        this.description = description;
        this.timestamp = timestamp;
        this.code = code;
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getAuthor() {
        return author;
    }

    public String getCode() {
        return code;
    }
}
