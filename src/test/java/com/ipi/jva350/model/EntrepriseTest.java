package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.ipi.jva350.model.Entreprise;

import java.time.LocalDate;

public class EntrepriseTest {

    @Test
    public void EstJourFerieTrue() {
        Entreprise e1 = new Entreprise();
            LocalDate date = LocalDate.of(2023,5,8);
              boolean res =  e1.estJourFerie(date);
             Assertions.assertTrue(res);


    }
    @Test
    public void EstJourFerieTest(){
        Entreprise e1 = new Entreprise();
        LocalDate date = LocalDate.of(2023,2,22);
           boolean res = e1.estJourFerie(date);
           Assertions.assertFalse(res);
    }
    @Test
    public void getPremierJourAnneeDeCongesTrue() {
        Entreprise e1 = new Entreprise();
        LocalDate date = LocalDate.of(2023,6,10);
        Assertions.assertEquals(LocalDate.parse("2023-05-01"), e1.getPremierJourAnneeDeConges(date));
    }
    @Test
    public void getPremierJourAnneeDeCongesAnnePrecedente() {
        Entreprise e1 = new Entreprise();
        LocalDate date = LocalDate.of(2023,3,10);
         Assertions.assertEquals(LocalDate.parse("2022-06-01"),e1.getPremierJourAnneeDeConges(date));
    }
    @Test
    public void getPremierJourAnneDeCongesAnnePrecedente7emeMois(){
        Entreprise e1 = new Entreprise();
        LocalDate date = LocalDate.of(2023,7,10);
        Assertions.assertEquals(LocalDate.of(2024,06,01),e1.getPremierJourAnneeDeConges(date));
    }

}
