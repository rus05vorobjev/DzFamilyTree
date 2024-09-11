package model.human;

import model.familytree.FamilyTree;

public interface AddRelatives {

    Human findHuman1(String name, FamilyTree familyTree);

    Human findHuman2(String name2, FamilyTree familyTree);

    void add(String parent, String child, FamilyTree familyTree);

}
