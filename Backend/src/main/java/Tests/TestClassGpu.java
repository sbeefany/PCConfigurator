package Tests;

import SpringConfiguration.SpringConfigurationFakeClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pccconfigurator.MainLogic.Entities.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassGpu {
    Gpu gpu;

    ComputerCase computerCase;
    ComputerCase incorrectComputerCase;

    PowerSupply powerSupply850;
    PowerSupply powerSupply550;

    Accessory accessory;


    @BeforeAll
    void init(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);

        gpu = context.getBean("getGpu170",Gpu.class);

        computerCase = context.getBean("getComputerCase",ComputerCase.class);
        incorrectComputerCase = context.getBean("getComputerCaseSmall",ComputerCase.class);

        powerSupply850 = context.getBean("getPowerSupply850",PowerSupply.class);
        powerSupply550 = context.getBean("getPowerSupply550",PowerSupply.class);

        accessory = context.getBean("getMotherBoard", MotherBoard.class);

    }

    @Test
    void checkCompabilityGpuLengthWithComputerCaseCorrectVariants(){
        Assertions.assertTrue(gpu.compabilityCheck(computerCase));
    }

    @Test
    void checkCompabilityGpuLengthWithComputerCaseIncorrectVariants(){
        Assertions.assertFalse(gpu.compabilityCheck(incorrectComputerCase));
    }

    @Test
    void checkCompabilityGpuPowerWithPowerSupply850CorrectVariants(){
        Assertions.assertTrue(gpu.compabilityCheck(powerSupply850));
    }

    @Test
    void checkCompabilityGpuPowerWithPowerSupply550IncorrectVariants(){
        Assertions.assertFalse(gpu.compabilityCheck(powerSupply550));
    }

    @Test
    void checkCompabilityGpuWithOtherAccessory(){
        Assertions.assertTrue(gpu.compabilityCheck(accessory));
    }

}
