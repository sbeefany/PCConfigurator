package Tests;

import SpringConfiguration.SpringConfigurationFakeClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pcconfigurator.MainLogic.Entities.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassCooler {

    Cooler cooler;

    MotherBoard motherBoard;
    MotherBoard inccorecMotherBoard;

    ComputerCase computerCase;
    ComputerCase incorrectComputerCase;

    Accessory accessory;


    @BeforeAll
    void init() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);
        cooler = context.getBean("getCoolerLGA1150H150", Cooler.class);

        motherBoard = context.getBean("getMotherBoard2", MotherBoard.class);
        inccorecMotherBoard = context.getBean("getMotherBoard4", MotherBoard.class);

        computerCase = context.getBean("getComputerCase", ComputerCase.class);
        incorrectComputerCase = context.getBean("getComputerCaseSmall", ComputerCase.class);

        accessory = context.getBean("getGpu170", Gpu.class);


    }

    @Test
    void checkCompatibilityCoolerWithMotherBoardWithCorrectVariants() {
        Assertions.assertTrue(cooler.compatibilityCheck(motherBoard));
    }

    @Test
    void checkCompatibilityCoolerWithMotherBoardWithIncorrectVariants() {
        Assertions.assertFalse(cooler.compatibilityCheck(inccorecMotherBoard));
    }

    @Test
    void checkCompatibilityCoolerWithcomputerCaseWithCorrectVariants() {
        Assertions.assertTrue(cooler.compatibilityCheck(computerCase));
    }

    @Test
    void checkCompatibilityCoolerWithComputerCaseWithIncorrectVariants() {
        Assertions.assertFalse(cooler.compatibilityCheck(incorrectComputerCase));
    }

    @Test
    void checkCompatibilityCoolerWithOtherAccessory() {
        Assertions.assertTrue(cooler.compatibilityCheck(accessory));
    }
}
