package Tests;

import SpringConfiguration.SpringConfigurationFakeClasses;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pccconfigurator.MainLogic.Entities.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassComputerCaseCooler {
    ComputerCaseCooler cooler120;
    ComputerCaseCooler cooler75;
    ComputerCase computerCase;
    Accessory otherAccessory;

    @BeforeAll
   void init(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);

        cooler120 = context.getBean("getComputerCaseCooler120",ComputerCaseCooler.class);
        cooler75 = context.getBean("getComputerCaseCooler75",ComputerCaseCooler.class);
        computerCase = context.getBean("getComputerCase",ComputerCase.class);
        otherAccessory = context.getBean("getGpu170",Gpu.class);

    }

    @Test
    void checkCompatibilityCorrectThings(){
        assertTrue(cooler120.compatibilityCheck(computerCase));
    }

    @Test
    void checkCompatibilityIncorrectThings(){
        assertFalse(cooler75.compatibilityCheck(computerCase));
    }


    @Test
    void checkCompatibilityBetweenCorrectThingsButItAlwaysCompability(){
        assertTrue(cooler120.compatibilityCheck(otherAccessory));
    }



}
