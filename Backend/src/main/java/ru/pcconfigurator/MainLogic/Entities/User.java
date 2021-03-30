package ru.pcconfigurator.MainLogic.Entities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class User {

    private final String email;
    private final String password;
    private final String name;
    private final String login;
    private final List<PcConfiguration> configurationList;
    private final UUID userId;


    public User(String email, String password, String name, String login, List<PcConfiguration> configurationList) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.login = login;
        this.configurationList = configurationList;
        userId = UUID.randomUUID();
    }

    public User(String email, String password, String name, String login, List<PcConfiguration> configurationList, UUID userId) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.login = login;
        this.configurationList = configurationList;
        this.userId = userId;
    }

    public User addNewConfiguration(PcConfiguration configuration){
        List<PcConfiguration> newList= new ArrayList<>(this.configurationList);
        boolean checkConfiguration = newList.stream().anyMatch(configuration1->{
            return configuration1.getId().equals(configuration.getId());
        });
        if(checkConfiguration){
            return this;
        }else{
            newList.add(configuration);
            return new User(this.email,this.password,this.name,this.login,newList,this.userId);
        }
    }

    public User deleteConfiguration(UUID configurationId){
        List<PcConfiguration> newList= new LinkedList<>(this.configurationList);
        boolean checkConfiguration = newList.stream().anyMatch(configuration1->{
            return configuration1.getId().equals(configurationId);
        });
        if(checkConfiguration){
            newList.remove(newList.stream().filter(pcConfiguration -> pcConfiguration.getId().equals(configurationId)).findFirst().orElse(null));
            return new User(this.email,this.password,this.name,this.login,newList,this.userId);
        }else{
            return this;
        }
    }

    public Boolean checkEmail(String email){
        return this.email.equals(email);
    }

    public Boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public Boolean checkId(UUID id){
        return this.userId.equals(id);
    }

    public User changePassword(String newPassword){
        return new User(this.email,newPassword,this.name,this.login,List.copyOf(this.configurationList),this.userId);
    }

    public UUID getUserId() {
        return userId;
    }
}
