package ru.pcconfigurator.MainLogic.Controllers;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Entities.Accessory;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;

import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/accessories")
public class AccessoriesController {

    @Autowired
    private IAccessoriesRepository repository;


    @GetMapping("/:id")
    public Accessory findAccessory(@NotNull @RequestParam("id") UUID uuid) {
        return repository.getAccessory(uuid);
    }

    @GetMapping("/:name")
    public List<Accessory> findAccessoriesByName(@NotNull @RequestParam("name") String name) {
        return repository.getAllAccessoriesByName(name);
    }
}
