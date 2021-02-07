package Tests;

import SpringConfiguration.SpringConfigurationFakeClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.pccconfigurator.MainLogic.Entities.Accessory;
import ru.pccconfigurator.MainLogic.Entities.Disk;
import ru.pccconfigurator.MainLogic.Entities.MotherBoard;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClassDisk {
    Disk disk;

    MotherBoard motherBoard;
    MotherBoard incorrectMotherBoard;

    Accessory otherAccessory;

    @BeforeAll
    void init(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);

        disk = context.getBean("getDiskM2",Disk.class);

        motherBoard = context.getBean("getMotherBoard", MotherBoard.class);
        incorrectMotherBoard= context.getBean("getMotherBoard3", MotherBoard.class);

        otherAccessory = context.getBean("getDiskSSD", Disk.class);
    }

    @Test
    void checkCompatibilityDiskM2WithMotherBoardCorrectVariants(){
        Assertions.assertTrue(disk.compatibilityCheck(motherBoard));
    }

    @Test
    void checkCompatibilityDiskM2WithMotherBoardIncorrectVariants(){
        Assertions.assertFalse(disk.compatibilityCheck(incorrectMotherBoard));
    }

    @Test
    void checkCompatibilityDiskM2WithOtherAccessory(){
        Assertions.assertTrue(disk.compatibilityCheck(otherAccessory));
    }


}
