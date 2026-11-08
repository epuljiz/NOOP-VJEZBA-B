package pckg_model;

import pckg_core.Collaborator;
import pckg_observer.CollaboratorObserver;

import java.time.LocalDateTime;

public class Change {

    private String description;
    private LocalDateTime timestamp;
    private String code;
    private CollaboratorObserver author;


    public Change(String description, LocalDateTime timestamp, String code, CollaboratorObserver author) {
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

    public CollaboratorObserver getAuthor() {
        return author;
    }

    public String getCode() {
        return code;
    }
}
