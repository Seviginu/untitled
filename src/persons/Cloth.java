package persons;

public class Cloth {
    public enum Material{
        LEATHER("Кожа"), WOOL("Шерсть"), CAMELWOOl("Верблюжья шерсть");

        private final String name;
        Material(String name){
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }

    Person owner;
    Material material;
    private final String name;

    public Cloth(String name, Material material){
        this.name = name;
        this.material = material;
    }

    public String getName(){
        return name;
    }

    public void setOwner(Person person){
        this.owner = person;
    }

    @Override
    public String toString(){
        return name + ", Материал: " + material;
    }

    @Override
    public int hashCode(){
        return owner.hashCode() + getName().hashCode() + material.hashCode();
    }
}
