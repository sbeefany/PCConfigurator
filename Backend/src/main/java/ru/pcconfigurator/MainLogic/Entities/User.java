package ru.pcconfigurator.MainLogic.Entities;

import java.util.List;
import java.util.UUID;

public class User {

    private final String email;
    private final String password;
    private final List<PcConfiguration> configurationList;
    private final UUID userId;


    public User(String email, String password, List<PcConfiguration> configurationList) {
        this.email = email;
        this.password = password;
        this.configurationList = configurationList;
        userId = UUID.randomUUID();
    }

    public User(String email, String password, List<PcConfiguration> configurationList, UUID userId) {
        this.email = email;
        this.password = password;
        this.configurationList = configurationList;
        this.userId = userId;
    }

    public User addNewConfiguration(PcConfiguration configuration){

    }

    public User deleteConfiguration(UUID configurationId)
}
