package Tests;

import SpringConfiguration.SpringConfigurationFakeClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pcconfigurator.MainLogic.Entities.*;

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
    PowerSupply incorrectPowerSupply;

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

        powerSupply = context.getBean("getPowerSupply550FlexATX", PowerSupply.class);
        incorrectPowerSupply = context.getBean("getPowerSupply850", PowerSupply.class);

        otherAccessory = context.getBean("getRamDDR4",Ram.class);
    }

    @Test
    void checkCompatibilityCorrectThingsWithGpu() {
        Assertions.assertTrue(computerCaseSmall.compatibilityCheck(gpu100));
    }

    @Test
    void checkCompatibilityIncorrectThingsWithGpu() {
        Assertions.assertFalse(computerCaseSmall.compatibilityCheck(gpu170));
    }

    @Test
    void checkCompatibilityCorrectThingsWithCooler() {
        Assertions.assertTrue(computerCaseSmall.compatibilityCheck(cooler75));
    }

    @Test
    void checkCompatibilityIncorrectThingsWithCooler() {
        Assertions.assertFalse(computerCaseSmall.compatibilityCheck(cooler120));
    }

    @Test
    void checkCompatibilityCorrectThingsWithCpuCooler() {
        Assertions.assertTrue(computerCaseSmall.compatibilityCheck(coolerLGA1700H70));
    }

    @Test
    void checkCompatibilityIncorrectThingsWithCpuCooler() {
        Assertions.assertFalse(computerCaseSmall.compatibilityCheck(coolerLGA1700H150));
    }

    @Test
    void checkCompatibilityCorrectThingsWithPowerSupplyCorrectThings() {
        Assertions.assertTrue(computerCaseSmall.compatibilityCheck(powerSupply));
    }
    @Test
    void checkCompatibilityCorrectThingsWithPowerSupplyIncorrectThings() {
        Assertions.assertFalse(computerCaseSmall.compatibilityCheck(incorrectPowerSupply));
    }

    @Test
    void checkCompatibilityCorrectThingsWithMotherBoard() {
        Assertions.assertTrue(computerCaseSmall.compatibilityCheck(motherBoard));
    }
    @Test
    void checkCompatibilityIncorrectThingsWithMotherBoard() {
        Assertions.assertFalse(computerCaseSmall.compatibilityCheck(motherBoard2));
    }

    @Test
    void checkCompatibilityBetweenIndependentThings() {
        Assertions.assertTrue(computerCaseSmall.compatibilityCheck(otherAccessory));
    }

}
