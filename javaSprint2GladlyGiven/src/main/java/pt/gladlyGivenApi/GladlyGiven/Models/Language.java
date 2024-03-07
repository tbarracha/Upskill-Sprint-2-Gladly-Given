package pt.gladlyGivenApi.GladlyGiven.Models;

public class Language {

    //id : long <PK>
    //language : string

    public long id;
    public String language;

    public Language() {
    }

    public Language(long id, String language) {
        this.id = id;
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return id == language.id;
    }

}
