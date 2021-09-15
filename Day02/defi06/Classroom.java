
// Compile: javac *.java
// Run: java Classroom

class Classroom {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Etudiant 1", true),
                new Student("Etudiant 2", false),
                new Student("Etudiant 3", true),
        };

        for(int i = 0; i < students.length; i++)
            System.out.println(students[i].whoAmi());
    }
}