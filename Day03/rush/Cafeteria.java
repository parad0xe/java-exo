import java.util.*;

public class MitCafeteria {

    static void printArrayList(ArrayList array, String[] rooms) {
        System.out.print("ArrayList[");
        for (int i = 0; i < array.size(); i++) {
            System.out.print("\n  Day(" + (i + 1) + ")[");
            Map<String, ArrayList<String>> places = (Map<String, ArrayList<String>>)array.get(i);

            for (String place : rooms) {
                System.out.print("\n    Place(" + place + ") [");
                ArrayList<String> names = places.get(place);

                for (int j = 0; j < names.size(); j++) {
                    System.out.print(names.get(j));
                    if(j < names.size() - 1) System.out.print(", ");
                }
                System.out.print("]");
            }
            System.out.print("\n  ]");
        }
        System.out.print("\n]\n");
    }

    public static ArrayList<Object> planning(int[] shifts, String[] persons, String[] places){
        if(persons.length%2!=0){
            String[] employees = new String[persons.length+1];
            for (int i=0;i< persons.length; i++) {
                employees[i]=persons[i];
            }
            employees[persons.length]="/";
            persons=employees;
        }
        ArrayList<Object> list = new ArrayList<>();

        for (int s = 0; s < shifts.length; s++) {

            Map<String, ArrayList<String>> map= new HashMap<String, ArrayList<String>>();
            for (int pl = 0; pl < places.length; pl++) {
                map.put(places[pl],new ArrayList<String>());
            }
            for (int pe = 0; pe < persons.length; pe++) {
                int pl=0;
                if(pe%2==0){
                    pl = (pe/2+s)%places.length;
                }
                else{
                    pl = (pe/2-s);

                    if(pl<0){
                        pl=(places.length-(Math.abs(pl)%(places.length)))%places.length;
                    }
                }

                ArrayList<String> arrayPersons = map.get(places[pl]);
                arrayPersons.add(persons[pe]);
                map.put(places[pl], arrayPersons);
            }
            list.add(map);
        }

        printArrayList(list, places);
        return list;
    }
    public static void main(String[] args) {
        String[] employees = {"Marcus", "Lateefa", "Donald", "Rashad", "Quincy", "Mia"};
        String[] cafeteria = {"Lobby", "Dining Room", "Kitchen"};
        int[] shifts={0, 1, 2, 3, 4, 5, 6, 7};

        planning(shifts, employees, cafeteria);
    }
}