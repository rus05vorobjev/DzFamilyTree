package view;
import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;

import java.util.Scanner;



public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветствую!");

        while (work) {
            System.out.println(mainMenu.menu());
            System.out.print("\nВаш выбор: ");
            String choiceStr = scanner.nextLine();
            validity(choiceStr);
            int choice = Integer.parseInt(choiceStr);
            if(choice <= mainMenu.size()) mainMenu.execute(choice);
            else {
                System.out.println("Указанное число больше количества вариантов. Попробуйте снова");

            }
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void finish(){
        work = false;
        System.out.println("Досвидание.");
    }

    public void AddHuman(){
        System.out.print("Укажите имя: ");
        String name = scanner.nextLine();
        System.out.print("Укажите пол. Male или Female: ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Укажите дату рождения(год, месяц, число): ");
        LocalDate birthData = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        presenter.addHuman(name,gender,birthData);
        scanner.nextLine();
    }
    public void getInfoHumans(){
        presenter.getInfoHumans();
    }

    public void sortBirthData(){
        presenter.sortBirthData();
        getInfoHumans();
    }

    public void sortName(){
        presenter.sortName();
        getInfoHumans();
    }
    public void writingBytes(){
        System.out.println("Укажите путь к файлу");
        String filePath = scanner.nextLine();
        presenter.writingBytes(filePath);
    }

    public void readingBytes(){
        System.out.println("Укажите путь к файлу");
        String filePath = scanner.nextLine();
        presenter.readingBytes(filePath);
    }

    public void findHuman(){
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        presenter.findHuman(name);
    }

    public void addChild(){
        System.out.println("Укажите имя родителя: ");
        String parent = scanner.nextLine();
        System.out.println("Укажите имя ребенка: ");
        String child = scanner.nextLine();
        presenter.addChild(parent,child);

    }

    public void addSpouse(){
        System.out.println("Укажите имя супруга(и): ");
        String spouse1 = scanner.nextLine();
        System.out.println("Укажите имя супруга(и): ");
        String spouse2 = scanner.nextLine();
        presenter.addSpouse(spouse1,spouse2);

    }


    private boolean validity(String choiceStr){
              try{
                Integer.parseInt(choiceStr);
                 return true;
            } catch(Exception e){
                System.out.println("Вы ввели не чиcловое значение. Попробуйте снова.\n");
                start();
                   return false;
            }
    }






}
