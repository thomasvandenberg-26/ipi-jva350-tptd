package com.ipi.jva350.model;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class SalarieAideADomicileTest {

    SalarieAideADomicile salarieAideADomicile;
    SalarieAideADomicileService salarieAideADomicileService;
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

    @ParameterizedTest
    @CsvSource({
            "2023-01-02, 2023-01-25, 20",
            "2022-01-01, 2022-12-31, 28"
    })
    public void testCalculeJoursDeCongeDecomptesPourPlage(String dateDebutStr, String dateFinStr, int expectedDays) {
        // Given
        LocalDate dateDebut = LocalDate.parse(dateDebutStr);
        LocalDate dateFin = LocalDate.parse(dateFinStr);


        SalarieAideADomicile salarie = new SalarieAideADomicile("Jane Doe", LocalDate.of(2024, 1, 1),
                LocalDate.now(), 0, 0, 120, 0, 0);

        // When
        LinkedHashSet<LocalDate> joursDeCongeDecomptes = salarie.calculeJoursDeCongeDecomptesPourPlage(dateDebut, dateFin);

        //Then
        assertEquals(expectedDays, joursDeCongeDecomptes.size());
    }
    @ExtendWith(MockitoExtension.class)
    public void testAjouteConge() {
        SalarieAideADomicileRepository repositoryMock = mock(SalarieAideADomicileRepository.class);
        LocalDate  today = LocalDate.now();
        LocalDate  unmars = LocalDate.parse("01-03-2023");


        SalarieAideADomicile s1 = new SalarieAideADomicile
                ("Wadi",moisDebutContrat, moisEnCours, 24,
                        22,8,
                        14,14);
        String Exception = " N'a pas légalement droit à des congés payés !";
        SalarieAideADomicileService s1s = new SalarieAideADomicileService();

    //    s1s.ajouteConge(s1, today, unmars);
      Assertions.assertEquals(Exception, s1.aLegalementDroitADesCongesPayes());

    }


}
