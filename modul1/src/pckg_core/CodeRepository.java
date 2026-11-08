package pckg_core;

import pckg_model.Change;
import pckg_observer.CollaboratorObserver;
import pckg_observer.Observable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CodeRepository implements Observable {

    private String currentCode = "";
    private List<CollaboratorObserver> collaborators = new ArrayList<>();
    private List<Change> commitHistory = new ArrayList<>();

    public void commit(String description, String code, CollaboratorObserver author) {
        Change change = new Change(description, LocalDateTime.now(), code, author);
        commitHistory.add(change);
        currentCode = code;
        notifyObservers(change, author);
    }

    @Override
    public void registerObserver(CollaboratorObserver collaboratorObserver) {
        if (!collaborators.contains(collaboratorObserver)) {
            collaborators.add(collaboratorObserver);
            System.out.println("Collaborator registered as an observer.");
        } else {
            System.out.println("Collaborator is already registered as an observer.");
        }
    }

    @Override
    public void removeObserver(CollaboratorObserver collaboratorObserver) {
        if (!collaborators.contains(collaboratorObserver)) {
            System.out.println("Collaborator is not registered as an observer.");
        } else {
            collaborators.remove(collaboratorObserver);
            System.out.println("Collaborator removed from observers.");
        }
    }

    @Override
    public void notifyObservers(Change change) {
        for (CollaboratorObserver collaborator : collaborators) {
            collaborator.update(change);
        }
    }

    public void notifyObservers(Change change, CollaboratorObserver author) {
        for (CollaboratorObserver collaborator : collaborators) {
            if (collaborator != author) {
                collaborator.update(change);
            }
        }
    }

    @Override
    public void syncCollaborator(CollaboratorObserver collaborator) {
        if (collaborator != null) {
            Change syncChange = new Change("Sync: Initial or re-join synchronization", LocalDateTime.now(), currentCode, null);
            collaborator.update(syncChange);
        }
    }

}