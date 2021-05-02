package ru.pcconfigurator.MainLogic.Controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Entities.*;
import ru.pcconfigurator.MainLogic.Entities.Dao.AccessoryDao;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/accessories")
public class AccessoriesController {

    @Autowired
    private IAccessoriesRepository repository;


    @GetMapping("")
    public List<AccessoryDao> findAllAccessories(@RequestParam(required = false, name = "name") String name) {
        if ((name == null || name.isEmpty()))
            return repository.findAllAccessories().stream().map(Accessory::convertToAccessoryDao).collect(Collectors.toList());
        else
            return repository.findAllAccessoriesByName(name).stream().map(Accessory::convertToAccessoryDao).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AccessoryDao findAccessory(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory != null)
            return accessory.convertToAccessoryDao();
        else
            return null;
    }

    @GetMapping("/computercase/{id}")
    public ComputerCase findFullInformationAboutComputerCase(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory instanceof ComputerCase)
            return (ComputerCase) accessory;
        else
            return null;
    }

    @GetMapping("/computercasecooler/{id}")
    public ComputerCaseCooler findFullInformationAboutComputerCaseCooler(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory instanceof ComputerCaseCooler)
            return (ComputerCaseCooler) accessory;
        else
            return null;
    }

    @GetMapping("/cooler/{id}")
    public Cooler findFullInformationAboutCooler(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory instanceof Cooler)
            return (Cooler) accessory;
        else
            return null;
    }

    @GetMapping("/cpu/{id}")
    public Cpu findFullInformationAboutCpu(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory instanceof ComputerCaseCooler)
            return (Cpu) accessory;
        else
            return null;
    }

    @GetMapping("/disk/{id}")
    public Disk findFullInformationAboutDisk(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory instanceof Disk)
            return (Disk) accessory;
        else
            return null;
    }

    @GetMapping("/gpu/{id}")
    public Gpu findFullInformationAboutGpu(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory instanceof Gpu)
            return (Gpu) accessory;
        else
            return null;
    }

    @GetMapping("/motherboard/{id}")
    public MotherBoard findFullInformationAboutMotherBoard(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory instanceof MotherBoard)
            return (MotherBoard) accessory;
        else
            return null;
    }

    @GetMapping("/powersupply/{id}")
    public PowerSupply findFullInformationAboutPowerSupply(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory instanceof PowerSupply)
            return (PowerSupply) accessory;
        else
            return null;
    }

    @GetMapping("/ram/{id}")
    public Ram findFullInformationAboutRam(@NotNull @PathVariable("id") UUID uuid) {
        Accessory accessory = repository.findAccessoryById(uuid);
        if (accessory instanceof Ram)
            return (Ram) accessory;
        else
            return null;
    }
}
