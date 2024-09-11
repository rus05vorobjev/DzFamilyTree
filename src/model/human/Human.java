package model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthData, deathData;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Human spouse;

    public Human(int id, String name, Gender gender, LocalDate birthData,
                 LocalDate deathData, Human father, Human mother) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthData = birthData;
        this.deathData = deathData;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(int id, String name, Gender gender, LocalDate birthData, Human father, Human mother) {
        this(id, name, gender, birthData, null, father, mother);
    }

    public Human(int id, String name, Gender gender, LocalDate birthData) {
        this(id, name, gender, birthData, null, null, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthData() {
        return birthData;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public String getFatherInfo(){
        String res = "";
        Human father = getFather();
        if( father == null){
            res += "нет";
        }else res += father.getName();
        return res;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public String getMotherInfo(){
        String res = "";
        Human mother = getMother();
        if( mother == null){
            res += "нет";
        }else res += mother.getName();
        return res;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getInfoSpouse() {
        String res = "";
        Human spouse = getSpouse();
        if (spouse == null) {
            res += "нет";
        } else res += spouse.getName();
        return res;
    }

    public void addChild(Human human){
        if(!children.contains(human)){
            children.add(human);
        }
        else System.out.println("Этот человек уже присутствует в данном списке");
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        if (children.size() != 0) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else sb.append("нет");
        return sb.toString();
    }

    public int getPeriod(LocalDate birthData, LocalDate deathData){
        Period diff = Period.between(birthData, LocalDate.now());
        return diff.getYears();
    }

    public int getAge(){
        if(deathData == null){
            return getPeriod(birthData, LocalDate.now());

        } else return getPeriod(birthData,deathData);
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id - ").append(id);
        sb.append(", Имя - ").append(name);
        sb.append(", Пол - ").append(gender);
        sb.append(", День рождения - ").append(birthData);
        sb.append(", Возраст - ").append(getAge());
        sb.append("\nОтец: ").append(getFatherInfo());
        sb.append("\nМать: ").append(getMotherInfo());
        sb.append("\nДети: ").append(getChildrenInfo());
        sb.append("\nСупруг(а): ").append(getInfoSpouse());

        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Human) ) return false;
        Human human = (Human) obj;
        return human.getId() == ((Human) obj).getId();
    }

    @Override
    public int compareTo(Human o) {
        return getName().compareTo(o.getName());
    }
}
