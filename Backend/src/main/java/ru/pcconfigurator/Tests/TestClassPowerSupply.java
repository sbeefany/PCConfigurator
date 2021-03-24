package ru.pcconfigurator.Tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pcconfigurator.MainLogic.Entities.*;
import ru.pcconfigurator.Tests.SpringConfiguration.SpringConfigurationFakeClasses;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassPowerSupply {
    PowerSupply powerSupply;

    ComputerCase computerCase;
    ComputerCase incorrectComputerCase;

    Gpu gpu;
    Gpu incorrectGpu;

    Accessory otherAccessory;

    @BeforeAll
    void init(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);

        powerSupply = context.getBean("getPowerSupply550",PowerSupply.class);

        computerCase = context.getBean("getComputerCase", ComputerCase.class);
        incorrectComputerCase = context.getBean("getComputerCaseSmall", ComputerCase.class);

        gpu = context.getBean("getGpu100", Gpu.class);
        incorrectGpu = context.getBean("getGpu170", Gpu.class);

        otherAccessory = context.getBean("getComputerCaseCooler120", ComputerCaseCooler.class);
    }

    @Test
    void checkCompatibilityPowerSupplyWithComputerCaseCorrectThings(){
        Assertions.assertTrue(powerSupply.compatibilityCheck(computerCase));
    }
    @Test
    void checkCompatibilityPowerSupplyWithComputerCaseIncorrectThings(){
        Assertions.assertFalse(powerSupply.compatibilityCheck(incorrectComputerCase));
    }
    @Test
    void checkCompatibilityPowerSupplyWithGpuCaseCorrectThings(){
        Assertions.assertTrue(powerSupply.compatibilityCheck(gpu));
    }
    @Test
    void checkCompatibilityPowerSupplyWithGpuIncorrectThings(){
        Assertions.assertFalse(powerSupply.compatibilityCheck(incorrectGpu));
    }

    @Test
    void checkCompatibilityPowerSupplyWithOtherAccessory(){
        Assertions.assertTrue(powerSupply.compatibilityCheck(otherAccessory));
    }

}
