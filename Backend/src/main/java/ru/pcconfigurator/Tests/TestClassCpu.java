package ru.pcconfigurator.Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pcconfigurator.MainLogic.Entities.Accessory;
import ru.pcconfigurator.MainLogic.Entities.Cpu;
import ru.pcconfigurator.MainLogic.Entities.Gpu;
import ru.pcconfigurator.MainLogic.Entities.MotherBoard;
import ru.pcconfigurator.Tests.SpringConfiguration.SpringConfigurationFakeClasses;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassCpu {
    Cpu cpu;

    MotherBoard motherBoard;
    MotherBoard incorrectMotherBoard;

    Accessory otherAccessory;

    @BeforeAll
    void init(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);

        cpu = context.getBean("getCpuLGA1150",Cpu.class);

        motherBoard = context.getBean("getMotherBoard2",MotherBoard.class);
        incorrectMotherBoard= context.getBean("getMotherBoard",MotherBoard.class);

        otherAccessory = context.getBean("getGpu170", Gpu.class);
    }

    @Test
    void checkCompatibilityCpuWithMotherBoardCorrectVariants(){
        Assertions.assertTrue(cpu.compatibilityCheck(motherBoard));
    }

    @Test
    void checkCompatibilityCpuWithMotherBoardIncorrectVariants(){
        Assertions.assertFalse(cpu.compatibilityCheck(incorrectMotherBoard));
    }

    @Test
    void checkCompatibilityCpuWithOtherAccessory(){
        Assertions.assertTrue(cpu.compatibilityCheck(otherAccessory));
    }
}
