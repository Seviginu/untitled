package sounds;

import persons.Person;

public class Music implements Playable {
    private Person author;
    private String title;
    private String content;
    private boolean isClear;
    private Difficult difficult;

    public Music(Person author, String title, String content, Difficult difficult, boolean isClear){
        this.author = author;
        this.title = title;
        this.content = content;
        this.difficult = difficult;
        this.isClear = isClear;
    }

    public String getSound(){
        return content;
    }

    public Person getAuthor(){
        return author;
    }

    public boolean isClear(){
        return isClear;
    }

    public Difficult getDifficult(){
        return difficult;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public int hashCode(){
        return author.hashCode() + title.hashCode() + content.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == null || this.getClass() != o.getClass()) return false;
        return (author.equals(((Music) o).author) && title.equals(((Music) o).title) && content.equals(((Music) o).content));
    }

    @Override
    public String toString(){
        return "Автор: " + author.getName() + "\n" +
                "Название: " + title + "\n" +
                "Содержание: " + content + "\n";
    }
}
