package pckg_model;

import pckg_observer.CollaboratorObserver;

import java.time.LocalDateTime;

public record Change(
        String description,
        LocalDateTime timestamp,
        String code,
        CollaboratorObserver author
) {

}