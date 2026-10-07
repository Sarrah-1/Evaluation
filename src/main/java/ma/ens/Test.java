package ma.ens;

import ma.ens.beans.Assurance;
import ma.ens.beans.Client;
import ma.ens.beans.Contrat;
import ma.ens.beans.StatutContrat;
import ma.ens.service.AssuranceService;
import ma.ens.service.ClientService;
import ma.ens.service.ContratService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        ClientService cs = new ClientService();
        AssuranceService as = new AssuranceService();
        ContratService cts = new ContratService();

        Client c1 = new Client("EE8987678", "OUADAY", "SARA", "saraouaday@gmail.com", "06899987876");
        Client c2 = new Client("EE1122334", "NOURAN", "AMINA", "nouranamina@gmail.com", "068999889076");

        cs.create(c1);
        cs.create(c2);

        Assurance a1 = new Assurance("AUTO", 1000.0, "TT Risque");
        Assurance a2 = new Assurance("SANTE", 2000.0, "Moitie");

        as.create(a1);
        as.create(a2);

        Date d1 = sdf.parse("12/01/2026");
        Date d2 = sdf.parse("09/12/2026");
        Date d3 = sdf.parse("01/12/2025");
        Date d4 = sdf.parse("01/11/2026");

        Contrat ct1 = new Contrat(d1, d2, StatutContrat.ACTIF, c1, a1);
        Contrat ct2 = new Contrat(d3, d4, StatutContrat.RESILIE, c1, a2);
        Contrat ct3 = new Contrat(d1, d2, StatutContrat.ACTIF, c2, a1);

        cts.create(ct1);
        cts.create(ct2);
        cts.create(ct3);

        Assurance ass = as.findByType("AUTO");
        if (ass != null) {
            System.out.println("Assurance: " + ass.getType() + " - " + ass.getMontant());
        }

        List<Contrat> list1 = cts.findByClientCin("EE8987678");
        for (Contrat c : list1) {
            System.out.println("Contrat ID: " + c.getId() + " - Statut: " + c.getStatut());
        }

    }
}