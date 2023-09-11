package com.example.demo.dao;

import com.example.demo.model.GenshinModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GenshinDAO {

    private static int Genshin_COUNT;
    private List<GenshinModel> genshins;
    {
        genshins = new ArrayList<>();

        genshins.add(new GenshinModel(++Genshin_COUNT,"Люмин", "девушка", "мульти", "одноручник"));
        genshins.add(new GenshinModel(++Genshin_COUNT, "Хэйдзо", "парень", "анемо", "каталист"));
        genshins.add(new GenshinModel(++Genshin_COUNT,"Кадзуха", "парень", "анемо","одноручник"));
    }

    public List<GenshinModel> index(){

        return genshins;
    }

    public GenshinModel show(int id){
        return genshins.stream().filter(genshinModel -> genshinModel.getId() == id).findAny().orElse(null);
    }

    public void save(GenshinModel genshin){
        genshin.setId(++Genshin_COUNT);
        genshins.add(genshin);
    }

    public void update(int id, GenshinModel genshinModel){
        GenshinModel updateGenshin = show(id);
        updateGenshin.setGender(genshinModel.getGender());
        updateGenshin.setElement(genshinModel.getElement());
        updateGenshin.setWeapon(genshinModel.getWeapon());
        updateGenshin.setName(genshinModel.getName());
    }


    public void delete(int id){ genshins.removeIf(p-> p.getId() == id);}
}
