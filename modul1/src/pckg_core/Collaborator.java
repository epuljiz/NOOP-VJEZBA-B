package pckg_core;

import pckg_model.Change;
import pckg_observer.CollaboratorObserver;

public class Collaborator implements CollaboratorObserver {

    private String name;
    private CollaboratorStatus status;

    public Collaborator(String name, CollaboratorStatus status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public void update(Change change) {
        if (change.author().equals(this)) {
            return;
        }

        System.out.println("[" + name + "] primio obavijest o novom commitu od "
                + change.author().toString() + ": " + change.description());
    }

    public void changeCode(CodeRepository repo, String newCode, String desc){
        System.out.println("[" + name + "] napravio commit: " + desc);
        repo.commit(desc, newCode, this);
    }

    public void goAway(){
        this.status = CollaboratorStatus.AWAY;
    }

    public void rejoin(CodeRepository repo){
        this.status = CollaboratorStatus.ACTIVE;
        repo.registerObserver(this);
    }

    public CollaboratorStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Collaborator{" +
                "name='" + name + '\'' +
                '}';
    }

}
