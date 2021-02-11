package SpringConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pccconfigurator.MainLogic.Entities.*;
import ru.pccconfigurator.MainLogic.Entities.Enums.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class SpringConfigurationFakeClasses {

    @Bean
    PcConfiguration getEmptyConfiguration(){
        return new PcConfiguration(new ArrayList<>());
    }

    @Bean
    PcConfiguration getConfigurationWithSomeAccessories(){
        return new PcConfiguration(List.of(getComputerCaseSmall(),getCpuLGA1700()));
    }

    @Bean
    PcConfiguration getFullConfiguration(){
        return new PcConfiguration(List.of(
                getComputerCaseSmall(),getCpuLGA1700(),getMotherBoard3(),getRamDDR4(),getRamDDR4(),
                getComputerCaseCooler90(),getComputerCaseCooler75(),getCoolerLGA1700H70(),getDiskSSD(),getGpu100(),getPowerSupply550FlexATX()
        ));
    }


    @Bean
    Accessory getComputerCaseCooler120(){
        return new ComputerCaseCooler("Name","Aercool", UUID.randomUUID(),
                350,getCoolerSize120(),1100,25);
    }

    @Bean
    Accessory getComputerCaseCooler90(){
        return new ComputerCaseCooler("Name","Aercool", UUID.randomUUID(),
                350,getCoolerSize90(),700,25);
    }
    @Bean
    Accessory getComputerCaseCooler75(){
        return new ComputerCaseCooler("Name","Aercool", UUID.randomUUID(),
                350,getCoolerSize75(),700,25);
    }

    @Bean
    Accessory getComputerCase(){
        return new ComputerCase("computerCase","Arecool",UUID.randomUUID(),
                1900, List.of(FormFactor.ATX),
                TypeSizeComputerCase.MidTower,5,
                List.of(getCoolerSize120(),getCoolerSize120(),getCoolerSize120(),getCoolerSize120(),getCoolerSize90()),
                List.of(getConnector()),
                FormFactorPowerSupply.ATX,500,50,150,
                getMaxSize());
    }
    @Bean
    Accessory getComputerCaseSmall(){
        return new ComputerCase("computerCase","Arecool",UUID.randomUUID(),
                1900, List.of(FormFactor.MiniATX),
                TypeSizeComputerCase.MiniTower,3,
                List.of(getCoolerSize90(),getCoolerSize75(),getCoolerSize75()),
                List.of(getConnector()),
                FormFactorPowerSupply.FlexATX,250,50,100,
                getMaxSizeSmall());
    }

    @Bean
    Connector getConnector(){
        return new Connector("InfoAboutConnector", ConnectorType.Usb3);
    }

    @Bean
    Accessory getCoolerLGA1700H70(){
        return new Cooler("Name","Aercool", UUID.randomUUID(),1100, Socket.LGA1700,Material.COPPER,70,20);
    }

    @Bean
    Accessory getCoolerLGA1150H70(){
        return new Cooler("Name","Aercool", UUID.randomUUID(),1100, Socket.LGA1150,Material.COPPER,70,20);
    }

    @Bean
    Accessory getCoolerLGA1150H150(){
        return new Cooler("Name","Aercool", UUID.randomUUID(),1100, Socket.LGA1150,Material.COPPER,150,20);
    }

    @Bean
    Accessory getCoolerLGA1700H150(){
        return new Cooler("Name","Aercool", UUID.randomUUID(),1100, Socket.LGA1700,Material.COPPER,150,20);
    }




    @Bean
    CoolerSize getCoolerSize120(){
        return new CoolerSize(120,120);
    }

    @Bean
    CoolerSize getCoolerSize90(){
        return new CoolerSize(90,90);
    }

    @Bean
    CoolerSize getCoolerSize75(){
        return new CoolerSize(75,75);
    }

    @Bean
    Accessory getCpuLGA1700(){
        return new Cpu("i5-10400f","Intel",UUID.randomUUID(),15000,Socket.LGA1700,
                12,12,false,2);
    }

    @Bean
    Accessory getCpuLGA1150(){
        return new Cpu("i3-5400","Intel",UUID.randomUUID(),15000,Socket.LGA1150,
                12,12,false,2);
    }

    @Bean
    Accessory getDiskM2(){
        return new Disk("WD-BLUE GREEN","WD-BLUE",UUID.randomUUID(),1500,124,DiskType.M2);
    }

    @Bean
    Accessory getDiskSSD(){
        return new Disk("WD-BLUE GREEN","WD-BLUE",UUID.randomUUID(),1500,124,DiskType.SSD);
    }
    @Bean
    Accessory getGpu170(){
        return new Gpu("GeForce3060ti","NVIDIA",UUID.randomUUID(),40000,
                2000,6,VideoMemotyType.GDDR4,170,750);
    }
    @Bean
    Accessory getGpu100(){
        return new Gpu("GeForce3060ti","NVIDIA",UUID.randomUUID(),40000,
                2000,6,VideoMemotyType.GDDR4,100,550);
    }
    @Bean
    MaxSize getMaxSize(){
        return new MaxSize(150,280);
    }

    @Bean
    MaxSize getMaxSizeSmall(){
        return new MaxSize(90,150);
    }

    @Bean
    Accessory getMotherBoard(){
        return new MotherBoard("AsusRoqH110","Asus",UUID.randomUUID(),
                7000,Socket.LGA1700,ChipSet.H110,FormFactor.ATX,TypeRam.DDR4,4,true);
    }
    @Bean
    Accessory getMotherBoard2(){
        return new MotherBoard("AsusRoqH110","Asus",UUID.randomUUID(),
                7000,Socket.LGA1150,ChipSet.H110,FormFactor.ATX,TypeRam.DDR4,4,true);
    }
    @Bean
    Accessory getMotherBoard3(){
        return new MotherBoard("AsusRoqH110","Asus",UUID.randomUUID(),
                7000,Socket.LGA1700,ChipSet.H110,FormFactor.MiniATX,TypeRam.DDR4,2,false);
    }
    @Bean
    Accessory getMotherBoard4(){
        return new MotherBoard("AsusRoqH110","Asus",UUID.randomUUID(),
                7000,Socket.LGA1700,ChipSet.H110,FormFactor.ATX,TypeRam.DDR3,4,true);
    }

    @Bean
    Accessory getPowerSupply850(){
        return new PowerSupply("Aercool","TestPowerSupply",UUID.randomUUID(),2000,FormFactorPowerSupply.ATX,850);
    }

    @Bean
    Accessory getPowerSupply550(){
        return new PowerSupply("Aercool","TestPowerSupply",UUID.randomUUID(),2000,FormFactorPowerSupply.ATX,550);
    }
    @Bean
    Accessory getPowerSupply550FlexATX(){
        return new PowerSupply("Aercool","TestPowerSupply",UUID.randomUUID(),2000,FormFactorPowerSupply.FlexATX,550);
    }
    @Bean
    Accessory getRamDDR4(){
        return new Ram("Kingston","Kingston",UUID.randomUUID(),5000,TypeRam.DDR4,8,2666);
    }

    @Bean
    Accessory getRamDDR3(){
        return new Ram("Kingston","Kingston",UUID.randomUUID(),5000,TypeRam.DDR3,8,2666);
    }


}
