package pckg_model;

import pckg_core.Collaborator;
import java.time.LocalDateTime;

public record Change(
        String description,
        LocalDateTime timestamp,
        String code,
        Collaborator author
) {

}