public class Student {
    private String name;
    private boolean aware;

    public Student(String name, boolean aware) {
        this.name = name;
        this.aware = aware;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAware() {
        return aware;
    }

    public void setAware(boolean aware) {
        this.aware = aware;
    }

    public String whoAmi() {
        if(this.aware)
            return "Je m'appelle " + this.name + " et je suis conscient";
        else
            return "Je m'appelle " + this.name + " et je ne suis conscient";
    }
}
