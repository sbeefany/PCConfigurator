package Tests;

import SpringConfiguration.SpringConfigurationFakeClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pcconfigurator.MainLogic.Entities.Accessory;
import ru.pcconfigurator.MainLogic.Entities.Gpu;
import ru.pcconfigurator.MainLogic.Entities.MotherBoard;
import ru.pcconfigurator.MainLogic.Entities.Ram;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassRam {

    Ram ram;

    MotherBoard motherBoard;
    MotherBoard incorrectMotherBoard;

    Accessory otherAccessory;

    @BeforeAll
    void init(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);

        ram = context.getBean("getRamDDR4",Ram.class);

        motherBoard = context.getBean("getMotherBoard",MotherBoard.class);
        incorrectMotherBoard = context.getBean("getMotherBoard4",MotherBoard.class);

        otherAccessory = context.getBean("getGpu170", Gpu.class);
    }

    @Test
    void checkCompatibilityRamWithMotherBoardCorrectThings(){
        Assertions.assertTrue(ram.compatibilityCheck(motherBoard));
    }
    @Test
    void checkCompatibilityRamWithMotherBoardIncorrectThings(){
        Assertions.assertFalse(ram.compatibilityCheck(incorrectMotherBoard));
    }
    @Test
    void checkCompatibilityRamWithOtherAccessory(){
        Assertions.assertTrue(ram.compatibilityCheck(otherAccessory));
    }
}
