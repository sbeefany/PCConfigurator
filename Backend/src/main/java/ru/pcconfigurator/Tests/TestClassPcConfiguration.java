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
        PcConfiguration newConfiguration = pcConfiguration.addAccessory(computerCase);

        Assertions.assertEquals(pcConfiguration.getAccessories().size()+1,newConfiguration.getAccessories().size());

    }

    @Test
    void addAccessoryFirstAccessoryWhichIndependent() {
        Assertions.assertEquals(1,pcConfiguration.addAccessory(cooler).getAccessories().size());

    }

    //Поправить тест, добавление чувствительно к размерам кулера, т.е если можно добавить только 2 90ых кулера, а всего кулеров 3, то 3 90ых кулерв неполучится добавить
    //Поправить Fake классы
    @Test
    void addAccessoryToConfigurationWithCorrectDataSomeOfTheseAccessoriesHaveAlreadyBeenButCanBeMore() {
        PcConfiguration newConfiguration = pcConfiguration.addAccessory(computerCase);
        PcConfiguration newConfiguration2 = newConfiguration.addAccessory(computerCaseCooler);
        newConfiguration = newConfiguration2.addAccessory(computerCaseCooler2);
        Assertions.assertEquals(newConfiguration2.getAccessories().size()+1,newConfiguration.getAccessories().size());

    }

    @Test
    void addComputerCaseCoolerButComputerCaseHasNotChosenYet() {
        PcConfiguration newConfiguration = pcConfiguration.addAccessory(computerCaseCooler);
        Assertions.assertEquals(pcConfiguration.getAccessories().size(),newConfiguration.getAccessories().size());

    }

    @Test
    void addRamButMotherBoardHasNotChosenYet() {
        PcConfiguration newConfiguration = pcConfiguration.addAccessory(ram);
        Assertions.assertEquals(pcConfiguration.getAccessories().size(),newConfiguration.getAccessories().size());

    }

    @Test
    void addRamToConfigurationWithCorrectDataButHasAlreadyBeenMaxCount() {
        PcConfiguration newConfiguration = fullPcConfiguration.addAccessory(ram);
        Assertions.assertEquals(fullPcConfiguration.getAccessories().size(),newConfiguration.getAccessories().size());

    }

    @Test
    void addComputerToConfigurationWithCorrectDataButHasAlreadyBeenMaxCount() {
        PcConfiguration newConfiguration = fullPcConfiguration.addAccessory(cooler);
        PcConfiguration newConfiguration2 = fullPcConfiguration.addAccessory(cooler);
        Assertions.assertEquals(newConfiguration.getAccessories().size(),newConfiguration2.getAccessories().size());

    }

    @Test
    void addAccessoryToConfigurationWithCorrectDataButThisAccessoryHasAlreadyBeen() {
        PcConfiguration configuration = fullPcConfiguration.addAccessory(gpu);
        Assertions.assertEquals(fullPcConfiguration.getAccessories().size(),configuration.getAccessories().size());
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
        PcConfiguration configuration = fullPcConfiguration.deleteAccessory(ram.getId());
        Assertions.assertEquals(fullPcConfiguration.getAccessories().size()-1,configuration.getAccessories().size());
    }


    @Test
    @Ignore
    void generateFullConfigurationAndCheckCompatibility() {

    }

}
