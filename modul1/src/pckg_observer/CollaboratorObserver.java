package pckg_observer;

import pckg_model.Change;

public interface CollaboratorObserver {

    void update(Change change);
}
