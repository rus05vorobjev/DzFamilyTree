package model.familytree;

import model.human.Human;

import java.io.Serializable;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void AddHumans(Human human) {
        humans.add(human);
    }

    public String getInfoHumans() {
        StringBuilder sb = new StringBuilder();
        if (humans != null) {
            for (Human human : humans) {
                sb.append(human);
                sb.append("\n");
                sb.append("\n");
            }
        } else System.out.println("Список пуст");
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfoHumans();
    }

    public void sortName() {
        Collections.sort(humans);
    }

    public void sortBirthData() {
        Collections.sort(humans, new CorporatBirthData());
    }

    public void FindHuman(String name) {
        for (Human human : humans)
            if (human.getName().equals(name)) {
                System.out.println(human);
            }


    }


}