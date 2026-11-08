package pckg_model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VersionControlSystem {

    private List<Change> allCommits;

    public VersionControlSystem() {
        this.allCommits = new ArrayList<>();
    }

    public void logCommit(Change change) {
        if (change != null) {
            this.allCommits.add(change);
        }
    }

    public List<Change> getHistory() {
        return Collections.unmodifiableList(this.allCommits);
    }
}