package ru.pcconfigurator.Tests;


import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pcconfigurator.MainLogic.Entities.*;
import ru.pcconfigurator.Tests.SpringConfiguration.SpringConfigurationFakeClasses;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassPcConfiguration {
    PcConfiguration pcConfiguration;
    PcConfiguration fullPcConfiguration;

    ComputerCaseCooler computerCaseCooler;
    ComputerCaseCooler computerCaseCooler2;

    MotherBoard motherBoard;

    Cooler cooler;

    Ram ram;

    PowerSupply powerSupply;

    Cpu cpu;

    ComputerCase computerCase;

    Gpu gpu;

    AnnotationConfigApplicationContext context;

    @BeforeAll
    void init() {

        context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);


        computerCaseCooler = context.getBean("getComputerCaseCooler90", ComputerCaseCooler.class);
        computerCaseCooler2 = context.getBean("getComputerCaseCooler75", ComputerCaseCooler.class);
        motherBoard = context.getBean("getMotherBoard3", MotherBoard.class);
        cooler = context.getBean("getCoolerLGA1700H70", Cooler.class);
        ram = context.getBean("getRamDDR4", Ram.class);
        powerSupply = context.getBean("getPowerSupply550FlexATX", PowerSupply.class);
        cpu = context.getBean("getCpuLGA1700", Cpu.class);
        computerCase = context.getBean("getComputerCaseSmall", ComputerCase.class);
        gpu = context.getBean("getGpu100", Gpu.class);
    }

    @BeforeEach
    void beforeEach() {
        context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);
        pcConfiguration = context.getBean("getEmptyConfiguration", PcConfiguration.class);
        fullPcConfiguration = context.getBean("getFullConfiguration", PcConfiguration.class);
    }

    @Test
    void addAccessoryToConfigurationWithCorrectDataThereIsNotThisAccessory() {
        pcConfiguration.addAccessory(computerCase);
        Assertions.assertTrue(pcConfiguration.addAccessory(computerCaseCooler));

    }

    @Test
    void addAccessoryFirstAccessoryWhichIndependent() {
        Assertions.assertTrue(pcConfiguration.addAccessory(cooler));

    }

    //Поправить тест, добавление чувствительно к размерам кулера, т.е если можно добавить только 2 90ых кулера, а всего кулеров 3, то 3 90ых кулерв неполучится добавить
    //Поправить Fake классы
    @Test
    void addAccessoryToConfigurationWithCorrectDataSomeOfTheseAccessoriesHaveAlreadyBeenButCanBeMore() {
        pcConfiguration.addAccessory(computerCase);
        pcConfiguration.addAccessory(computerCaseCooler);
        Assertions.assertTrue(pcConfiguration.addAccessory(computerCaseCooler2));

    }

    @Test
    void addComputerCaseCoolerButComputerCaseHasNotChosenYet() {

        Assertions.assertFalse(pcConfiguration.addAccessory(computerCaseCooler));

    }

    @Test
    void addRamButMotherBoardHasNotChosenYet() {
        Assertions.assertFalse(pcConfiguration.addAccessory(ram));

    }

    @Test
    void addRamToConfigurationWithCorrectDataButHasAlreadyBeenMaxCount() {

        Assertions.assertFalse(fullPcConfiguration.addAccessory(ram));

    }

    @Test
    void addComputerToConfigurationWithCorrectDataButHasAlreadyBeenMaxCount() {
        fullPcConfiguration.addAccessory(cooler);
        Assertions.assertFalse(fullPcConfiguration.addAccessory(cooler));

    }

    @Test
    void addAccessoryToConfigurationWithCorrectDataButThisAccessoryHasAlreadyBeen() {
        Assertions.assertFalse(fullPcConfiguration.addAccessory(gpu));
    }

    @Test
    void checkIsFullConfiguration_ExpectTrue() {
        Assertions.assertTrue(fullPcConfiguration.isFullPack());
    }

    @Test
    void checkIsFullConfiguration_ExpectFalse() {
        Assertions.assertFalse(pcConfiguration.isFullPack());
    }


    @Test
    void deleteAccessoryToConfigurationWithRightData() {
        Assertions.assertTrue(fullPcConfiguration.deleteAccessory(ram));
    }


    @Test
    @Ignore
    void generateFullConfigurationAndCheckCompatibility() {

    }

}
