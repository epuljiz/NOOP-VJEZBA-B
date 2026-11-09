package pckg_client;

import pckg_core.CodeRepository;
import pckg_core.Collaborator;
import pckg_core.CollaboratorStatus;
import pckg_model.Change;

public class Main {

    static void main(String[] args) {

        CodeRepository repository = new CodeRepository();

        Collaborator dev1 = new Collaborator("Kolega 1", CollaboratorStatus.ACTIVE);
        Collaborator dev2 = new Collaborator("Kolega 2", CollaboratorStatus.ACTIVE);

        System.out.println("=== 1. Registracija suradnika ===");
        dev1.rejoin(repository);
        dev2.rejoin(repository);

        System.out.println("\n=== 2. Prvi commit ===");
        dev1.changeCode(repository, "public class App { // v1 }", "Inicijalna struktura aplikacije");

        System.out.println("\n=== 3. Odsutnost suradnika ===");
        dev2.goAway();
        repository.removeObserver(dev2);

        System.out.println("\n=== 4. Commit dok je kolega 2 odsutan ===");
        dev1.changeCode(repository, "public class App { // v2 - dodana logika }", "Dodana napredna logika");

        System.out.println("\n=== 5. Povratak odsutnog suradnika (Sinkronizacija - Zahtjev 5) ===");
        dev2.rejoin(repository);

        System.out.println("\n=== 6. Završni commit nakon povratka ===");
        dev2.changeCode(repository, "public class App { // v3 - finalna verzija }", "Finalno poliranje koda");

        System.out.println("\n=== 7. Pregled cjelokupne povijesti projekta (VCS) ===" );
        for (Change commit : repository.getHistory()) {
            System.out.println("Datum/Vrijeme: " + commit.timestamp() +
                    " | Autor: " + commit.author() +
                    " | Opis: " + commit.description());
        }
    }

}
