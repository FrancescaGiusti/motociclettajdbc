package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.util.List;

public class TestUpdate {
    public static void main(String[] args) {
        System.out.println("Inizio....");

        // questo risulta l'oggetto incaricato di operazioni dao
        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        System.out.println("################ test se esiste almeno uno ne sfrutto l'id #######");
        List<Motocicletta> attualmentePresentiSullaBaseDati = motociclettaDaoInstance
                .findAll();

        if (!attualmentePresentiSullaBaseDati.isEmpty()) {
            Motocicletta elementoCheVoglioModificare = attualmentePresentiSullaBaseDati.get(0);
            String nuovoValoreDaAssegnareAModello = "Toyota";
            System.out.println("...before update: " + elementoCheVoglioModificare);
            elementoCheVoglioModificare.setModello(nuovoValoreDaAssegnareAModello);

            motociclettaDaoInstance.update(elementoCheVoglioModificare);

            Long idElementoRicaricataDaDbPerTestUpdate = elementoCheVoglioModificare.getId();
            Motocicletta elementoRicaricataDaDbPerTestUpdate = motociclettaDaoInstance
                    .findById(idElementoRicaricataDaDbPerTestUpdate);
            System.out.println("...after update: " + elementoRicaricataDaDbPerTestUpdate);
            System.out.println("carico studente con id: " + idElementoRicaricataDaDbPerTestUpdate);
            if (elementoRicaricataDaDbPerTestUpdate == null
                    || !elementoRicaricataDaDbPerTestUpdate.getModello().equals(nuovoValoreDaAssegnareAModello))
                throw new AssertionError("se ne esiste almeno uno: FAILED");
        }
        System.out.println("################### test se ne esiste almeno uno provo a modificarlo :FINE #######");

    }

}
