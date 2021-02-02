package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.pccconfigurator.MainLogic.Entities.*;
import ru.pccconfigurator.MainLogic.Entities.Enums.*;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassComputerCase {
    ComputeCaseCooler cooler;
    ComputeCaseCooler incorrectCooler;
    Cooler correctCpuCooler;
    Cooler incorrectCpuCooler;
    ComputerCase computerCaseCorrect;
    Gpu gpu;
    Gpu incorrectGpu;
    MotherBoard motherBoard;
    MotherBoard incoorectMotherBoard;
    PowerSupply powerSupply;
    PowerSupply incorrectPowerSupply;
    Accessory otherAccessory;

    @BeforeAll
    void init(){

        computerCaseCorrect = new ComputerCase("computerCase","Arecool",UUID.randomUUID(),
                1900, List.of(FormFactor.ATX),
                TypeSizeComputerCase.MidTower,5,
                List.of(new CoolerSize(120,120),new CoolerSize(90,90)),
                List.of(new Connector("InfoAboutConnector", ConnectorType.Usb3)),
                FormFactorPowerSupply.ATX,500,50,150,
                new MaxSize(300,60));

        cooler = new ComputeCaseCooler("Name","Aercool", UUID.randomUUID(),350,new CoolerSize(120,120),1100,25);

        otherAccessory = new Cpu("cpu1","Intel",UUID.randomUUID(),50000,Socket.LGA1700,16,16,true,4 );

    }

    @Test
    void compabilityCheckCorrectThingsWithGpu(){
       Assertions.assertTrue(computerCaseCorrect.compabilityCheck(gpu));
    }
    @Test
    void compabilityCheckIncorrectThingsWithGpu(){
        Assertions.assertFalse(computerCaseCorrect.compabilityCheck(incorrectGpu));
    }
    @Test
    void compabilityCheckCorrectThingsWithCooler(){
        Assertions.assertTrue(computerCaseCorrect.compabilityCheck(cooler));
    }
    @Test
    void compabilityCheckIncorrectThingsWithColler(){
        Assertions.assertFalse(computerCaseCorrect.compabilityCheck(incorrectCooler));
    }

    @Test
    void compabilityCheckCorrectThingsWithCpuCooler(){
        Assertions.assertTrue(computerCaseCorrect.compabilityCheck(correctCpuCooler));
    }
    @Test
    void compabilityCheckIncorrectThingsWithCpuColler(){
        Assertions.assertFalse(computerCaseCorrect.compabilityCheck(incorrectCpuCooler));
    }
    @Test
    void compabilityCheckCorrectThingsWithPowerSupply(){
        Assertions.assertTrue(computerCaseCorrect.compabilityCheck(powerSupply));
    }
    @Test
    void compabilityCheckIncorrectThingsWithPowerSupply(){
        Assertions.assertFalse(computerCaseCorrect.compabilityCheck(incorrectPowerSupply));
    }
    @Test
    void compabilityCheckCorrectThingsWithMotherBoard(){
        Assertions.assertTrue(computerCaseCorrect.compabilityCheck(motherBoard));
    }
    @Test
    void compabilityCheckIncorrectThingsWithMotherBoard(){
        Assertions.assertFalse(computerCaseCorrect.compabilityCheck(incoorectMotherBoard));
    }
    @Test
    void compabilityCheckBetweenIndependentThings(){
        assertTrue(cooler.compabilityCheck(otherAccessory));
    }

}
