import java.util.*;

class Person {
    private String name;
    private ArrayList<Person> collaborators;

    Person(String name) {
        this.name = name;
        this.collaborators = new ArrayList<>();
    }

    public boolean hasCollaborateWith(Person person) {
        return this.collaborators.contains(person);
    }

    public void addCollaborator(Person person) {
        this.collaborators.add(person);
    }

    public String getName() {
        return name;
    }
}

class Room {
    private String name;
    private ArrayList<Person> users;

    Room(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public boolean wasUsedBy(Person person) {
        return this.users.contains(person);
    }

    public void addUser(Person person) {
        this.users.add(person);
    }

    public String getName() {
        return name;
    }
}



public class Cafeteria {
    public static void printPlanning(ArrayList<Map<Room, ArrayList<Person>>> plan) {
        System.out.print("ArrayList[");
        for (int i = 0; i < plan.size(); i++) {
            System.out.print("\n  Day(" + (i) + ")[");
            Map<Room, ArrayList<Person>> day = (Map<Room, ArrayList<Person>>)plan.get(i);

            for (Room room : day.keySet()) {
                System.out.print("\n    Place(" + room.getName() + ") [");
                ArrayList<Person> persons = day.get(room);

                for (int j = 0; j < persons.size(); j++) {
                    System.out.print(persons.get(j).getName());
                    if(j < persons.size() - 1) System.out.print(", ");
                }
                System.out.print("]");
            }
            System.out.print("\n  ]");
        }
        System.out.print("\n]\n");
    }

    public static ArrayList<Map<Room, ArrayList<Person>>> getPlanning(int[] days, Room[] rooms, Person[] persons){
        ArrayList<Map<Room, ArrayList<Person>>> plan = new ArrayList<>();

        for (int i = 0; i < days.length; i++) {
            Map<Room, ArrayList<Person>> day = new HashMap<>();

            ArrayList<Person> peoplePlaced = new ArrayList<>();

            for (int j = 0; j < rooms.length; j++) {
                Room room = rooms[j];
                ArrayList<Person> binome = new ArrayList<>();

                for (int k = 0; k < persons.length; k++) {
                    Person person = persons[k];

                    if(
                            !room.wasUsedBy(person) &&
                            (binome.size() < 1 || !binome.get(0).hasCollaborateWith(person)) &&
                            !peoplePlaced.contains(person)
                    ) {
                        if(binome.size() == 1) {
                            binome.get(0).addCollaborator(person);
                            person.addCollaborator(binome.get(0));
                        }

                        binome.add(person);
                        room.addUser(person);
                        peoplePlaced.add(person);

                        if(binome.size() == 2) break;
                    }
                }

                day.put(room, binome);
            }

            plan.add(day);
        }

        return plan;
    }

    public static void main(String[] args) {
        Person[] persons = {
                new Person("Marcus"),
                new Person("Lateefa"),
                new Person("Donald"),
                new Person("Rashad"),
                new Person("Quincy"),
                new Person("Mia")
        };

        Room[] rooms = {
                new Room("Lobby"),
                new Room("Dining Room"),
                new Room("Kitchen")
        };

        int[] days = {0, 1, 2, 3, 4, 5, 6, 7};

        printPlanning(getPlanning(days, rooms, persons));
    }
}