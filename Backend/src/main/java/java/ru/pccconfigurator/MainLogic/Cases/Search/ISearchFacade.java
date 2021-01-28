package java.ru.pccconfigurator.MainLogic.Cases.Search;

import java.ru.pccconfigurator.MainLogic.Entities.Accessory;
import java.util.List;

public interface ISearchFacade {
    List<Accessory> findAcceosries(String name);
}
