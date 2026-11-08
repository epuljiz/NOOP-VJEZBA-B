package pckg_observer;

import pckg_core.Collaborator;
import pckg_model.Change;

public interface Observable {

    void registerObserver(CollaboratorObserver collaboratorObserver);
    void removeObserver(CollaboratorObserver collaboratorObserver);
    void notifyObservers(Change change);
    void syncCollaborator(Collaborator collaborator);

}
