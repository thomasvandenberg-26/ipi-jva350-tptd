package com.ipi.jva350.model;

import com.ipi.jva350.model.Entreprise;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EntrepriseTest {


    @Test
    //Test si la date est bien dans la plage
    public void testEstDansPlage_True()
    {
        Entreprise entreprise = new Entreprise();
        //Given
        LocalDate d = LocalDate.of(2024, 2, 15);
        LocalDate datedebut = LocalDate.of(2024, 2, 10);
        LocalDate datefin = LocalDate.of(2024, 2, 20);
        //When
        boolean result = entreprise.estDansPlage(d, datedebut, datefin);

        assertTrue(result);
    }

    @Test
    //Test si la date n'est pas dans la plage
    public void testEstDansPlage_False()
    {
        Entreprise entreprise = new Entreprise();
        //Given
        LocalDate d = LocalDate.of(2024, 2, 5);
        LocalDate datedebut = LocalDate.of(2024, 2, 10);
        LocalDate datefin = LocalDate.of(2024, 2, 20);
        //When
        boolean result = entreprise.estDansPlage(d, datedebut, datefin);

        assertFalse(result);
    }

    @Test
    //Test avec une plage de dates identiques
    public void testEstDansPlage_DateDebutFinIndentique()
    {
        Entreprise entreprise = new Entreprise();
        //Given
        LocalDate d = LocalDate.of(2024, 2, 10);
        LocalDate datedebut = LocalDate.of(2024, 2, 10);
        LocalDate datefin = LocalDate.of(2024, 2, 10);
        //When
        boolean result = entreprise.estDansPlage(d, datedebut, datefin);

        assertTrue(result);
    }
    @Test
    //Test lorsque la date est égale à la date de fin de la plage :
    public void testEstDansPlage_DateEgaleADateFin()
    {
        Entreprise entreprise = new Entreprise();
        //Given
        LocalDate d = LocalDate.of(2024, 2, 20);
        LocalDate datedebut = LocalDate.of(2024, 2, 10);
        LocalDate datefin = LocalDate.of(2024, 2, 20);
        //When
        boolean result = entreprise.estDansPlage(d, datedebut, datefin);

        assertTrue(result);
    }


    @Test
    //Test si dateDébut est plus grand que dateFin
    public void testEstDansPlage_DateDebutPlusQueDateFin()
    {
        Entreprise entreprise = new Entreprise();
        //Given
        LocalDate d = LocalDate.of(2024, 2, 15);
        LocalDate datedebut = LocalDate.of(2024, 2, 26);
        LocalDate datefin = LocalDate.of(2024, 2, 25);
        //When
        //Then
        assertThrows(RuntimeException.class, () ->{ entreprise.estDansPlage(d, datedebut, datefin); });
    }

    @Test
    // Test pour verifier que le 8 mai est bien compté comme férié
    public void testEstJourFerieTrue() {

        //Given
        Entreprise e1 = new Entreprise();
        LocalDate date = LocalDate.of(2023,5,8);

        //When
        boolean res =  e1.estJourFerie(date);

        //Then
        Assertions.assertTrue(res);


    }
    @Test
    // Test si le 2 février est un jour férié
    public void testEstJourFerieTest(){
        //Given
        Entreprise e1 = new Entreprise();
        //When
        LocalDate date = LocalDate.of(2023,2,22);
        boolean res = e1.estJourFerie(date);
        //Then
        Assertions.assertFalse(res);
    }
    @Test
    // Je verifie que si la moitié de l'année à commencé, il retourne à l'année suivante le 1er juin
    public void getPremierJourAnneeDeConges() {
        //given
        Entreprise e1 = new Entreprise();
        LocalDate date = LocalDate.of(2023,6,10);
        //When
        LocalDate result = e1.getPremierJourAnneeDeConges(date);
        //Then
        Assertions.assertEquals(LocalDate.parse("2024-06-01"), result);
    }
    @Test
    // je verifie que si l'année n'est pas arrivée a la moitié on renvoi l'année précédent 1 jour de juin
    public void testGetPremierJourAnneeDeCongesAnneePrecedente() {
        //Given
        Entreprise e1 = new Entreprise();
        LocalDate date = LocalDate.of(2025,3,10);
        //When
        LocalDate result = e1.getPremierJourAnneeDeConges(date);
        //Then
        Assertions.assertEquals(LocalDate.parse("2024-06-01"), result);
    }
    @Test
    // Test si le mois est superieur à 6 que on retourne l'année suivante 1er jour de juin
    public void testGetPremierJourAnneDeCongesAnneePrecedente7emeMois(){
        //Given
        Entreprise e1 = new Entreprise();
        LocalDate date = LocalDate.of(2023,7,10);
        //When
        LocalDate result = e1.getPremierJourAnneeDeConges(date);
        //Then
        Assertions.assertEquals(LocalDate.parse("2024-06-01"), result);
    }

}
