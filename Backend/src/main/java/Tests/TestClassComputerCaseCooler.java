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
    void compabilityCheckCorrectThings(){
        assertTrue(cooler120.compabilityCheck(computerCase));
    }

    @Test
    void compabilityCheckIncorrectThings(){
        assertFalse(cooler75.compabilityCheck(computerCase));
    }


    @Test
    void compabilityCheckBetweenCorrectThingsButItAlwaysCompability(){
        assertTrue(cooler120.compabilityCheck(otherAccessory));
    }

    @Test
    void compabilityCheckNullThing(){

    }



}
