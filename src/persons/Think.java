package persons;

public class Think {
    private final String content;
    private final Object subject;

    public Think(String content){
        this.content = content;
        this.subject = null;
    }

    public Think(String content, Object subject){
        this.content = content;
        this.subject = subject;
    }

    @Override
    public String toString(){
        return content;
    }

    @Override
    public int hashCode(){
        return content.hashCode() + subject.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()) return false;
        return content.equals(((Think) o).content) && subject.equals(((Think) o).subject);
    }
}
