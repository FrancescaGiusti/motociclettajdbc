package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.util.List;

public class TestDelete {
    public static void main(String[] args) {
        System.out.println("Inizio....");

        MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();

        System.out.println("################ test se esiste almeno uno ne sfrutto l'id per rimozione #######");
        List<Motocicletta> attualmentePresentiSullaBaseDati = motociclettaDaoInstance
                .findAll();

        if (!attualmentePresentiSullaBaseDati.isEmpty()) {
            Motocicletta elementoCheVoglioEliminare = attualmentePresentiSullaBaseDati.get(0);

            Long idElementoRicaricataDaDbPerTestDelete = elementoCheVoglioEliminare.getId();

            motociclettaDaoInstance.delete(idElementoRicaricataDaDbPerTestDelete);

            Motocicletta elementoRicaricatoDaDbPerTestUpdate = motociclettaDaoInstance
                    .findById(idElementoRicaricataDaDbPerTestDelete);
            if (elementoRicaricatoDaDbPerTestUpdate != null)
                throw new AssertionError("test di rimozione: FAILED");
        } else
            throw new AssertionError("test di rimozione: FAILED in quanto non c'è nulla da rimuovere");

        System.out.println("################### test se esiste almeno uno ne sfrutto l'id per rimozione :FINE #######");

    }

}
