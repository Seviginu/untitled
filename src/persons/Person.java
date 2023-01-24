package persons;

import other.Lookable;

import java.util.ArrayList;

public abstract class Person implements Lookable, Dressable {


    protected int age;
    protected String name;
    protected Lookable nowLookAt;
    protected Apperance apperance;
    protected Speciality speciality;
    protected Mood mood;
    protected ArrayList<Cloth> clothes = new ArrayList<>();

    public Person(String name, int age, Apperance apperance){
        this.name = name;
        this.age = age;
        this.apperance = apperance;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }
    public Speciality getSpeciality(){
        return speciality;
    }
    public void sayPhrase(String phrase){
        System.out.println(name + " сказал: \"" + phrase + "\"");
    };

    public Lookable getNowLookAt(){
        return nowLookAt;
    }

    public void lookAt(Lookable obj){
        nowLookAt = obj;
    }

    @Override
    public void putOn(Cloth cloth){
        System.out.println(name + " надел " + cloth);
        cloth.setOwner(this);
        clothes.add(cloth);
    }

    @Override
    public void takeOff(Cloth cloth){
        if(clothes.remove(cloth)){
            cloth.setOwner(null);
            System.out.println(name + " снял " + cloth);
        }
    }

    @Override
    public String toString(){
        return "Имя: " + name +
                "\nВозраст: " + age +
                "\nВнешность: " + apperance;
    }

    @Override
    public int hashCode(){
        return name.hashCode() + age + apperance.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()) return false;
        return (name.equals(((Person) o).name)
                && age == ((Person) o).getAge()
                && apperance.equals(((Person) o).apperance));
    }
}
