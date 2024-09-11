package model.human;

import model.familytree.FamilyTree;

public class AddChild implements AddRelatives{
    @Override
    public Human findHuman1(String name, FamilyTree familyTree) {
        for(Human human: familyTree.getHumans()){
            if(human.getName().equals(name)) return human;
        } return null;
    }

    @Override
    public Human findHuman2(String name2, FamilyTree familyTree) {
        for(Human human: familyTree.getHumans()){
            if(human.getName().equals(name2)) return human;
        } return null;
    }

    @Override
    public void add(String name1, String name2, FamilyTree familyTree) {
        Human human1 = findHuman1(name1,familyTree);
        Human human2 = findHuman2(name2,familyTree);
        human1.addChild(human2);
        if(human1.getGender() == Gender.Male) human2.setFather(human1);
        if(human1.getGender() == Gender.Female) human2.setMother(human1);
    }
}
