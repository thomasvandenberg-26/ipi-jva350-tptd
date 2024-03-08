package com.ipi.jva350.repository;

import com.ipi.jva350.exception.SalarieException;

import com.ipi.jva350.model.SalarieAideADomicile;

import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(SpringExtension.class)

@SpringBootTest
public class SalarieAideADomicileRepositoryTest {

    @Autowired
    private SalarieAideADomicileService service;
    @Autowired
    private SalarieAideADomicileRepository repository;

    @Test
    public void testFindByNom() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile("Wadi", LocalDate.of(2022, 1, 1),
                LocalDate.now(), 0, 0, 15, 0, 0);
        repository.save(salarie);
        // When
        SalarieAideADomicile result = repository.findByNom("Wadi");

        assertEquals("Wadi", result.getNom());
    }

    @BeforeEach
    public void before() throws SalarieException {

        SalarieAideADomicile salarie = new SalarieAideADomicile("Charles", LocalDate.of(2022, 1, 1),
                LocalDate.now(), 50, 50, 60, 50, 50);

        SalarieAideADomicile salarie2 = new SalarieAideADomicile("Arthur", LocalDate.of(2022, 1, 1),
                LocalDate.now(), 50, 50, 60, 50, 50);
        service.creerSalarieAideADomicile(salarie);
        service.creerSalarieAideADomicile(salarie2);


    }

    @Test
    public void testajouteConge() {

        //Given
        SalarieAideADomicile result = repository.findByNom("Charles");


        //When //Then
        assertThrows(SalarieException.class, () -> {
            service.ajouteConge(result, LocalDate.of(2022, 5, 1), LocalDate.of(2023, 8, 10));
        });

    }

    @Test
    void testPartCongesPrisTotauxAnneeNMoins1() {


        // Then
        assertEquals(repository.partCongesPrisTotauxAnneeNMoins1(), 1);

    }
    @Test
    void testCalculeLimiteEntrepriseCongesPermis() {
        // Given
        SalarieAideADomicile salarie = new SalarieAideADomicile("Thomas", LocalDate.of(2022, 1, 1),
                LocalDate.now(), 0, 0, 15, 0, 0);
        repository.save(salarie);

        //When
        long limiteEntrepriseCongesPermis = service.calculeLimiteEntrepriseCongesPermis(salarie.getMoisEnCours(),
                salarie.getCongesPayesAcquisAnneeNMoins1(),
                salarie.getMoisDebutContrat(),LocalDate.parse("2023-01-20"),LocalDate.parse("2023-02-05"));

        // Then
        assertEquals(2, limiteEntrepriseCongesPermis);
    }

}