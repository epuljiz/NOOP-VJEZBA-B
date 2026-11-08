package pckg_core;

import pckg_model.Change;
import pckg_observer.CollaboratorObserver;

public class Collaborator implements CollaboratorObserver {

    private String name;
    private CollaboratorStatus status;

    @Override
    public void update(Change change) {
        return;
    }

    public void changeCode(CodeRepository repo, String newCode, String desc){
        System.out.println();
    }

    public goAway(){
        return;
    }

    public rejoin(CodeRepository repo){
        return;
    }


}
