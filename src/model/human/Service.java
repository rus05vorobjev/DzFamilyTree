package model.human;

import model.familytree.FamilyTree;
import model.load.FileHandler;
import model.load.Writable;

import java.time.LocalDate;

public class Service {
    private int id;
    private FamilyTree familyTree;
    private Writable writable;
    private AddChild addChild;
    private AddSpouse addSpouse;


    public Service() {
        familyTree = new FamilyTree();
        writable = new FileHandler();
        addChild = new AddChild();
        addSpouse = new AddSpouse();
    }

    public void CreateHuman(String name, Gender gender, LocalDate birthData) {
        Human human = new Human(++id, name, gender, birthData);
        familyTree.AddHumans(human);
    }

    public void getInfoHumans() {System.out.println(familyTree.toString());}

    public void sortBirthData() {familyTree.sortBirthData();}

    public void sortName() {familyTree.sortName();}

    public void writingBytes(String filePath) {writable.save(familyTree, filePath);}

    public void readingBytes(String filePath) {
        FamilyTree tree = (FamilyTree) writable.read(filePath);
        System.out.println(tree);
    }
    public void findHuman(String name) {familyTree.FindHuman(name);}

    public void addChild(String name1, String name2){addChild.add(name1,name2,familyTree);}

    public void addSpouse(String spouse1, String spouse2){addSpouse.add(spouse1,spouse2,familyTree);}





}

