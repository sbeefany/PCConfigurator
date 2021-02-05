package Tests;

import SpringConfiguration.SpringConfigurationFakeClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pccconfigurator.MainLogic.Entities.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassComputerCase {
    ComputerCaseCooler cooler120;
    ComputerCaseCooler cooler75;
    Cooler coolerLGA1700H70;
    Cooler coolerLGA1700H150;
    ComputerCase computerCaseSmall;
    Gpu gpu170;
    Gpu gpu100;
    MotherBoard motherBoard;
    MotherBoard motherBoard2;
    PowerSupply powerSupply;

    Accessory otherAccessory;

    @BeforeAll
    void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);

        computerCaseSmall = context.getBean("getComputerCaseSmall", ComputerCase.class);

        cooler120 = context.getBean("getComputerCaseCooler120", ComputerCaseCooler.class);
        cooler75 = context.getBean("getComputerCaseCooler75", ComputerCaseCooler.class);

        coolerLGA1700H70 = context.getBean("getCoolerLGA1700H70", Cooler.class);
        coolerLGA1700H150 = context.getBean("getCoolerLGA1700H150", Cooler.class);

        gpu170 = context.getBean("getGpu170", Gpu.class);
        gpu100 = context.getBean("getGpu100", Gpu.class);

        motherBoard = context.getBean("getMotherBoard3", MotherBoard.class);
        motherBoard2 = context.getBean("getMotherBoard2", MotherBoard.class);

        powerSupply = context.getBean("getPowerSupply850", PowerSupply.class);

        otherAccessory = context.getBean("getRamDDR4",Ram.class);
    }

    @Test
    void compabilityCheckCorrectThingsWithGpu() {
        Assertions.assertTrue(computerCaseSmall.compabilityCheck(gpu100));
    }

    @Test
    void compabilityCheckIncorrectThingsWithGpu() {
        Assertions.assertFalse(computerCaseSmall.compabilityCheck(gpu170));
    }

    @Test
    void compabilityCheckCorrectThingsWithCooler() {
        Assertions.assertTrue(computerCaseSmall.compabilityCheck(cooler75));
    }

    @Test
    void compabilityCheckIncorrectThingsWithCooler() {
        Assertions.assertFalse(computerCaseSmall.compabilityCheck(cooler120));
    }

    @Test
    void compabilityCheckCorrectThingsWithCpuCooler() {
        Assertions.assertTrue(computerCaseSmall.compabilityCheck(coolerLGA1700H70));
    }

    @Test
    void compabilityCheckIncorrectThingsWithCpuColler() {
        Assertions.assertFalse(computerCaseSmall.compabilityCheck(coolerLGA1700H150));
    }

    @Test
    void compabilityCheckCorrectThingsWithPowerSupply() {
        Assertions.assertTrue(computerCaseSmall.compabilityCheck(powerSupply));
    }

    @Test
    void compabilityCheckCorrectThingsWithMotherBoard() {
        Assertions.assertTrue(computerCaseSmall.compabilityCheck(motherBoard));
    }
    @Test
    void compabilityCheckIncorrectThingsWithMotherBoard() {
        Assertions.assertFalse(computerCaseSmall.compabilityCheck(motherBoard2));
    }

    @Test
    void compabilityCheckBetweenIndependentThings() {
        Assertions.assertTrue(computerCaseSmall.compabilityCheck(otherAccessory));
    }

}
