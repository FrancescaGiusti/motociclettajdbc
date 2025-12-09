package it.prova.motociclettajdbc.test;

import it.prova.motociclettajdbc.dao.MotociclettaDAO;
import it.prova.motociclettajdbc.model.Motocicletta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Testinsert {
    public static void main(String[] args) throws ParseException {
    	System.out.println("Inizio....");

    MotociclettaDAO motociclettaDaoInstance = new MotociclettaDAO();
    int quantiSonoAttualmentePresenti = -1;
    List<Motocicletta> attualmentePresentiSullaBaseDati = motociclettaDaoInstance
            .findAll();
    quantiSonoAttualmentePresenti = attualmentePresentiSullaBaseDati.size();

		System.out.println("############### test qualche insert ###########################");
    Motocicletta voceDaInserire1 = new Motocicletta("Toyota", "sqlm", 2000, new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2025"));
		motociclettaDaoInstance.insert(voceDaInserire1);
        Motocicletta voceDaInserire2 = new Motocicletta("Toyota", "hsfts", 2005, new SimpleDateFormat("dd/MM/yyyy").parse("20/03/2025"));
        motociclettaDaoInstance.insert(voceDaInserire2);
        Motocicletta voceDaInserire3 = new Motocicletta("Suzuki", "llmn", 1900, new SimpleDateFormat("dd/MM/yyyy").parse("25/06/2025"));
        motociclettaDaoInstance.insert(voceDaInserire3);
        Motocicletta voceDaInserire4 = new Motocicletta("BMW", "hafra", 1990, new SimpleDateFormat("dd/MM/yyyy").parse("12/06/2024"));
        motociclettaDaoInstance.insert(voceDaInserire4);

        int elementiAggiunti = 4;
		if (quantiSonoAttualmentePresenti + elementiAggiunti != motociclettaDaoInstance.findAll()
            .size())
            throw new AssertionError("qualche insert: FAILED");
		else
                System.out.println("Sono presenti" + elementiAggiunti + "elementi in più");
		System.out.println("################### test qualche insert: FINE ###################################");
		System.out.println("#####################################################################");

    }
}
