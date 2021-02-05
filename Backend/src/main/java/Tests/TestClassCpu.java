package Tests;

import SpringConfiguration.SpringConfigurationFakeClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pccconfigurator.MainLogic.Entities.Accessory;
import ru.pccconfigurator.MainLogic.Entities.Cpu;
import ru.pccconfigurator.MainLogic.Entities.Gpu;
import ru.pccconfigurator.MainLogic.Entities.MotherBoard;

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
    void checkCompabilityCpuWithMotherBoardCorrectVariants(){
        Assertions.assertTrue(cpu.compabilityCheck(motherBoard));
    }

    @Test
    void checkCompabilityCpuWithMotherBoardIncorrectVariants(){
        Assertions.assertFalse(cpu.compabilityCheck(incorrectMotherBoard));
    }

    @Test
    void checkCompabilityCpuWithOtherAccessory(){
        Assertions.assertTrue(cpu.compabilityCheck(otherAccessory));
    }
}
