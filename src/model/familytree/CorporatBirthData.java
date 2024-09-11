package model.familytree;

import model.human.Human;

import java.io.Serializable;
import java.util.Comparator;

public class CorporatBirthData implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthData().compareTo(o2.getBirthData());
    }
}
