package ru.pccconfigurator.MainLogic.Cases.Search;

import ru.pccconfigurator.MainLogic.Entities.Accessory;
import java.util.List;

public interface ISearchFacade {
    List<Accessory> findAcceosries(String name);
}
