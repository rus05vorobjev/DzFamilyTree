package presenter;

import model.familytree.FamilyTree;
import model.human.Gender;
import model.human.Service;
import view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birthData) {
        service.CreateHuman(name, gender, birthData);
    }
    public void getInfoHumans() {
        service.getInfoHumans();
    }

    public void sortBirthData() {service.sortBirthData();}

    public void sortName() {service.sortName();}

    public void writingBytes(String filePath) {service.writingBytes(filePath);}

    public void readingBytes(String filePath) {
        service.readingBytes(filePath);
    }

    public void findHuman(String name) {service.findHuman(name);}

    public void addChild(String name1, String name2) {service.addChild(name1,name2);}

    public void addSpouse(String spouse1, String spouse2) {
        service.addSpouse(spouse1,spouse2);
    }
}
