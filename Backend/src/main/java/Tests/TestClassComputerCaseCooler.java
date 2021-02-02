package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.pccconfigurator.MainLogic.Entities.*;
import ru.pccconfigurator.MainLogic.Entities.Enums.*;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassComputerCaseCooler {
    ComputeCaseCooler cooler;
    ComputerCase computerCaseCorrect;
    ComputerCase computerCaseIncorrect;
    Accessory otherAccessory;

    @BeforeAll
   void init(){
        cooler = new ComputeCaseCooler("Name","Aercool", UUID.randomUUID(),350,new CoolerSize(120,120),1100,25);
        computerCaseCorrect = new ComputerCase("computerCase","Arecool",UUID.randomUUID(),
                1900, List.of(FormFactor.ATX),
                TypeSizeComputerCase.MidTower,5,
                List.of(new CoolerSize(120,120)),
                List.of(new Connector("InfoAboutConnector", ConnectorType.Usb3)),
                FormFactorPowerSupply.ATX,500,50,150,
                new MaxSize(300,60));
        computerCaseIncorrect = new ComputerCase("computerCase","Arecool",UUID.randomUUID(),
                1900, List.of(FormFactor.ATX),
                TypeSizeComputerCase.MidTower,5,
                List.of(new CoolerSize(90,90)),
                List.of(new Connector("InfoAboutConnector", ConnectorType.Usb3)),
                FormFactorPowerSupply.ATX,500,50,150,
                new MaxSize(300,60));

        otherAccessory = new Gpu("Gpu1","NVIDIA",UUID.randomUUID(),50000,50,16,VideoMemotyType.GDDR4,170);
    }

    @Test
    void compabilityCheckCorrectThings(){
        assertTrue(cooler.compabilityCheck(computerCaseCorrect));
    }

    @Test
    void compabilityCheckIncorrectThings(){
        assertFalse(cooler.compabilityCheck(computerCaseIncorrect));
    }
    @Test
    void compabilityCheckBetweenCorrectThingsButItAlwaysCompability(){
        assertTrue(cooler.compabilityCheck(otherAccessory));
    }

    @Test
    void compabilityCheckNullThing(){

    }



}
