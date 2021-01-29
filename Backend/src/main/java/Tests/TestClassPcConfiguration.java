package Tests;

import org.junit.jupiter.api.*;
import ru.pccconfigurator.MainLogic.Entities.*;
import ru.pccconfigurator.MainLogic.Entities.Enums.*;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClassPcConfiguration {
    PcConfiguration pcConfiguration ;
    List<Accessory> accessories;
    @BeforeAll
    void init(){
        accessories=List.of(new Cooler("Cooler1","Aircool",UUID.fromString("Cooler1"), Socket.LGA1700, Material.COPPER,15,15),
                new Cpu("Cpu1","Intel", UUID.fromString("Cpu1"),Socket.LGA1700,12,12,false,2),
                new Disk("Disk1","TestVendor",UUID.fromString("Disk1"),10,1024, DiskType.HardDisk),
                new Gpu("GeForce RTX 3060Ti","NVIDIA",UUID.fromString("Gpu1"),10,10, VideoMemotyType.GDDR4,270),
                new MotherBoard("AsusRogH110","ASUS",UUID.fromString("MotherBoard1"),Socket.LGA1700, ChipSet.H110,FormFactor.ATX,TypeRam.DDR4),
                new Ram("Ram1","TestRamVendor",UUID.fromString("Ram1"),TypeRam.DDR4,8,2666));

        pcConfiguration=new PcConfiguration(accessories);

    }

    @AfterAll
    void destroy(){

    }

    @Test
    void addAccessoryToConfigurationWithRightData(){
        pcConfiguration.
        assertEquals(true,);
    }

    @Test
    void deleteAccessoryToConfigurationWithRightData(){

    }

    @Test
    void changeOneAccessoryAllDataAreRight(){

    }

    @Test
    void generateFullCinfigurationAndCheckCompatibility(){

    }

    @Test
    void checkCompatibilityMethod(){

    }
}
