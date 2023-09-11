package com.example.demo.dao;


import com.example.demo.model.CharterModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharterDAO {private static int Charter_COUNT;
    private List<CharterModel>  charters;
    {
        charters = new ArrayList<>();

        charters.add(new CharterModel(++Charter_COUNT, "Ольга Громыко", "Bungou Stray Dogs", 1,"https://toyhou.se/23277509.olga-gromyko"));
        charters.add(new CharterModel(++Charter_COUNT, "Итан", "без", 8, "https://toyhou.se/23053660.itan"));
        charters.add(new CharterModel(++Charter_COUNT,"Селестина", "Genshin impact", 151,"https://toyhou.se/14366474.selestina"));
    }

    public List<CharterModel> index(){

        return  charters;
    }

    public CharterModel show(int id){
        return  charters.stream().filter(charterModel ->  charterModel.getId() == id).findAny().orElse(null);
    }

    public void save(CharterModel  charter){
        charter.setId(++Charter_COUNT);
        charters.add(charter);
    }

    public void update(int id, CharterModel charterModel){
        CharterModel updateCharter = show(id);
        updateCharter.setName(charterModel.getName());
        updateCharter.setUniverse(charterModel.getUniverse());
        updateCharter.setArt(charterModel.getArt());
        updateCharter.setLink(charterModel.getLink());
    }


    public void delete(int id){ charters.removeIf(p-> p.getId() == id);}
}
