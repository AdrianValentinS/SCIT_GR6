import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Declaram persoane.

        Persoana persoana0 = new Persoana("Theodor Ilica", 30);
        Persoana persoana1 = new Persoana("Neculai Covaci", 50);
        Persoana persoana2 = new Persoana("Gavril Tavitian", 60);
        Persoana persoana3 = new Persoana("Andrei Stefanescu", 55);
        Persoana persoana4 = new Persoana("Ion Ionescu", 34);
        Persoana persoana5 = new Persoana("Mircea Popescu", 88);

        // Declaram 2 treeset-uri cu comparatori integrati pentru sortate dupa nume/varsta, adaugam persoane si iterator.

        TreeSet<Persoana> persoanaTreeSet0 = new TreeSet<Persoana>(new Comparator<Persoana>() {
            @Override
            public int compare(Persoana o1, Persoana o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        TreeSet<Persoana> persoanaTreeSet1 = new TreeSet<Persoana>(new Comparator<Persoana>() {
            @Override
            public int compare(Persoana o1, Persoana o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        persoanaTreeSet0.add(persoana0);
        persoanaTreeSet0.add(persoana1);
        persoanaTreeSet0.add(persoana2);
        persoanaTreeSet1.add(persoana3);
        persoanaTreeSet1.add(persoana4);
        persoanaTreeSet1.add(persoana5);

        Iterator<Persoana> persoanaIterator0 = persoanaTreeSet0.iterator();

        System.out.println("Obiecte TreeSet 0 sortate dupa nume: ");
        while (persoanaIterator0.hasNext())
            System.out.println(persoanaIterator0.next() + ", ");

        Iterator<Persoana> persoanaIterator1 = persoanaTreeSet1.iterator();

        System.out.println("Obiecte TreeSet 1 sortate dupa varsta: ");
        while (persoanaIterator1.hasNext())
            System.out.println(persoanaIterator1.next() + ", ");

        // Declaram adrese si liste de adrese pentru printare in hashmap.

        Adresa adresa0 = new Adresa("Mount Everest, Nepal");
        Adresa adresa1 = new Adresa("Miami, USA");
        Adresa adresa2 = new Adresa("Florida, USA");
        Adresa adresa3 = new Adresa("Stalingrad, Russia");

        List<Adresa> addressList0 = new ArrayList<Adresa>();
        List<Adresa> addressList1 = new  ArrayList<Adresa>();
        List<Adresa> addressList2 = new ArrayList<Adresa>();
        List<Adresa> addressList3= new  ArrayList<Adresa>();

        addressList0.add(adresa0);
        addressList1.add(adresa1);
        addressList2.add(adresa2);
        addressList3.add(adresa3);

        // Declaram hobby-uri si hobbylists.

        List<Hobby> hobbyList0 = new ArrayList<Hobby>();
        List<Hobby> hobbyList1 = new ArrayList<Hobby>();

        hobbyList0.add(new Hobby("Innot", 2, addressList0));
        hobbyList0.add(new Hobby("Pescuit", 3, addressList1));
        hobbyList1.add(new Hobby("Antrenament fizic", 5, addressList2));
        hobbyList1.add(new Hobby("Jogging", 3, addressList3));

        // Declaram hashmap-uri. Aici se printeaza persoanele si hobby-urile relevante.

        HashMap<Persoana, List<Hobby>> hashMap0 = new HashMap<>();
        hashMap0.put(persoana0, hobbyList0);

        System.out.println("HashMap pentru prima persoana: " + hashMap0.toString());

        HashMap<Persoana, List<Hobby>> hashMap1 = new HashMap<>();
        hashMap1.put(persoana1, hobbyList1);

        System.out.println("HashMap pentru a doua persoana: " + hashMap1.toString());

    }
}
