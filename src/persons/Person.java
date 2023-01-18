package persons;

import other.Lookable;

public abstract class Person implements Lookable {
    protected int age;
    protected String name;
    protected Lookable nowLookAt;
    protected Apperance apperance;
    protected Speciality speciality;
    protected Mood mood;

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

    public Apperance getApperance(){
        return apperance;
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
    public String toString(){
        return "Имя: " + name +
                "\nВозраст: " + age;
    }

    @Override
    public int hashCode(){
        return name.hashCode() + age + apperance.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()) return false;
        return (name.equals(((Person) o).name) && age == ((Person) o).getAge() && apperance.equals(((Person) o).apperance));
    }
}
