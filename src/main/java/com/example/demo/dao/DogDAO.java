package com.example.demo.dao;

import com.example.demo.model.DogModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DogDAO {
    private static int Dog_COUNT;
    private List<DogModel> dogs;
    {
        dogs = new ArrayList<>();

        dogs.add(new DogModel(++Dog_COUNT, "Лютик", 6,"Громыко О.", "йорк"));
        dogs.add(new DogModel(++Dog_COUNT, "Арчи", 3,"Смернов Д.",  "колли"));
        dogs.add(new DogModel(++Dog_COUNT,"Эшли", 12,"Кисин А.", "бульдог"));
    }

    public List<DogModel> index(){

        return dogs;
    }

    public DogModel show(int id){
        return dogs.stream().filter(dogModel ->  dogModel.getId() == id).findAny().orElse(null);
    }

    public void save(DogModel dog){
        dog.setId(++Dog_COUNT);
        dogs.add(dog);
    }

    public void update(int id, DogModel dogModel){
        DogModel updateDog = show(id);
        updateDog.setNickname(dogModel.getNickname());
        updateDog.setAge(dogModel.getAge());
        updateDog.setMaster(dogModel.getMaster());
        updateDog.setBreed(dogModel.getBreed());
    }


    public void delete(int id){ dogs.removeIf(p-> p.getId() == id);}
}
