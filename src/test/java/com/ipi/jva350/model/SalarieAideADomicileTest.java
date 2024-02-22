package com.ipi.jva350.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;

public class SalarieAideADomicileTest {

    SalarieAideADomicile salarieAideADomicile;
    LocalDate moisDebutContrat = LocalDate.parse("2024-02-20");
    LocalDate moisEnCours = LocalDate.now();
    @Test
    public void testALegalementDroitADesCongesPayesTrue(){
        SalarieAideADomicile s1 = new SalarieAideADomicile
                ("Wadi",moisDebutContrat, moisEnCours, 24,
                        22,10,
                        14,14);
     boolean res =    s1.aLegalementDroitADesCongesPayes();
        Assertions.assertTrue(res);
    }
    @Test
    public void testALegalementDroitADesCongesPayesFalse(){
        SalarieAideADomicile s1 = new SalarieAideADomicile
                ("Wadi",moisDebutContrat, moisEnCours, 24,
                        22,9,
                        14,14);
        boolean res =    s1.aLegalementDroitADesCongesPayes();
        Assertions.assertFalse(res);
    }

    @Test
    public void testCalculeJoursDeCongeDecomptesPourPlageTrue(){



    }
    @Test
    public void habituellementTravaillesTrue(){

        LocalDate jourDaujourdhui = LocalDate.now();

        SalarieAideADomicile s1 = new SalarieAideADomicile
                ("Wadi",moisDebutContrat, moisEnCours, 24,
                        22,8,
                        14,14);
        boolean res = s1.estHabituellementTravaille(jourDaujourdhui);
        Assertions.assertTrue(res);



    }
    @Test
    public  void habituellementTravaillesFalse(){
        LocalDate samedi = LocalDate.parse("2024-02-17");
        SalarieAideADomicile s1 = new SalarieAideADomicile
                ("Wadi",moisDebutContrat, moisEnCours, 24,
                        22,8,
                        14,14);
        boolean res = s1.estHabituellementTravaille(samedi);
        Assertions.assertFalse(res);
    }

    @Test void estJourOuvrableTrue(){
    LocalDate today = LocalDate.now();
    SalarieAideADomicile s1 = new SalarieAideADomicile
                ("Wadi",moisDebutContrat, moisEnCours, 24,
                        22,8,
                        14,14);
    boolean res = s1.estJourOuvrable(today);
    Assertions.assertTrue(res);
    }
    @Test void estJourOuvrableFalse(){
        LocalDate noel = LocalDate.parse("2023-12-25");
        SalarieAideADomicile s1 = new SalarieAideADomicile
                ("Wadi",moisDebutContrat, moisEnCours, 24,
                        22,8,
                        14,14);
        boolean res = s1.estJourOuvrable(noel);
        Assertions.assertFalse(res);
    }
}
