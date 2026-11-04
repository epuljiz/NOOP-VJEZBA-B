package pckg_observer;

public interface Observable {

    void registerObserver(CollaboratorObserver collaboratorObserver);
    void removeObserver(CollaboratorObserver collaboratorObserver);
    void notifyObservers(Change change);
    void syncCollaborator(Collaborator collaborator);

}
