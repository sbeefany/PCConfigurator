package Tests;

import SpringConfiguration.SpringConfigurationFakeClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pcconfigurator.MainLogic.Entities.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassMotherBoard {

    MotherBoard motherBoard;

    Cpu cpu;
    Cpu incorrectCpu;

    Cooler cooler;
    Cooler incorrectCooler;

    ComputerCase computerCase;
    ComputerCase incorrectComputerCase;

    Ram ram;
    Ram incorrectRam;

    Disk ssdM2;
    Disk ssd;

    Accessory otherAccessory;


    @BeforeAll
    void init() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);

        motherBoard = context.getBean("getMotherBoard", MotherBoard.class);

        cpu = context.getBean("getCpuLGA1700", Cpu.class);
        incorrectCpu = context.getBean("getCpuLGA1150", Cpu.class);

        cooler = context.getBean("getCoolerLGA1700H70", Cooler.class);
        incorrectCooler = context.getBean("getCoolerLGA1150H70", Cooler.class);

        computerCase = context.getBean("getComputerCase", ComputerCase.class);
        incorrectComputerCase = context.getBean("getComputerCaseSmall", ComputerCase.class);

        ram = context.getBean("getRamDDR4", Ram.class);
        incorrectRam = context.getBean("getRamDDR3", Ram.class);

        ssdM2 = context.getBean("getDiskM2", Disk.class);
        ssd = context.getBean("getDiskSSD", Disk.class);

        otherAccessory = context.getBean("getGpu170", Gpu.class);

    }

    @Test
    void checkCompatibilityMotherBoardWithCpuCorrectThings() {
        Assertions.assertTrue(motherBoard.compatibilityCheck(cpu));
    }

    @Test
    void checkCompatibilityMotherBoardWithCpuIncorrectThings() {

        Assertions.assertFalse(motherBoard.compatibilityCheck(incorrectCpu));
    }

    @Test
    void checkCompatibilityMotherBoardWithCpuCoolerCorrectThings() {

        Assertions.assertTrue(motherBoard.compatibilityCheck(cooler));
    }

    @Test
    void checkCompatibilityMotherBoardWithCpuCoolerIncorrectThings() {

        Assertions.assertFalse(motherBoard.compatibilityCheck(incorrectCooler));
    }

    @Test
    void checkCompatibilityMotherBoardWithComputerCaseCorrectThings() {

        Assertions.assertTrue(motherBoard.compatibilityCheck(computerCase));
    }

    @Test
    void checkCompatibilityMotherBoardWithComputerCaseIncorrectThings() {

        Assertions.assertFalse(motherBoard.compatibilityCheck(incorrectComputerCase));
    }

    @Test
    void checkCompatibilityMotherBoardWithRamCorrectThings() {

        Assertions.assertTrue(motherBoard.compatibilityCheck(ram));
    }

    @Test
    void checkCompatibilityMotherBoardWithRamIncorrectThings() {

        Assertions.assertFalse(motherBoard.compatibilityCheck(incorrectRam));
    }

    @Test
    void checkCompatibilityMotherBoardWithM2SSDCorrectThings() {

        Assertions.assertTrue(motherBoard.compatibilityCheck(ssdM2));
    }

    @Test
    void checkCompatibilityMotherBoardWithSSD() {

        Assertions.assertTrue(motherBoard.compatibilityCheck(ssd));
    }
    @Test
    void checkCompatibilityMotherBoardWithOtherAccessory() {

        Assertions.assertTrue(motherBoard.compatibilityCheck(otherAccessory));
    }
}
