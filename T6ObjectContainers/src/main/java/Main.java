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

        List<Adresa> addressList0 = new ArrayList<Adresa>();
        List<Adresa> addressList1 = new ArrayList<Adresa>();
        List<Adresa> addressList2 = new ArrayList<Adresa>();
        List<Adresa> addressList3 = new ArrayList<Adresa>();
        List<Adresa> addressList4 = new ArrayList<Adresa>();
        List<Adresa> addressList5 = new ArrayList<Adresa>();
        List<Adresa> addressList6 = new ArrayList<Adresa>();
        List<Adresa> addressList7 = new ArrayList<Adresa>();

        addressList0.add(new Adresa("Mount Everest, Nepal"));
        addressList1.add(new Adresa("Miami, USA"));
        addressList2.add(new Adresa("Florida, USA"));
        addressList3.add(new Adresa("Stalingrad, Russia"));
        addressList4.add(new Adresa("Shanghai, China"));
        addressList5.add(new Adresa("Berlin, Germany"));
        addressList6.add(new Adresa("Paris, France"));
        addressList7.add(new Adresa("Moscow, Russia"));

        // Declaram hobby-uri si hobbylists. Note: Unii oameni au mai putine hobby-uri decat altii.

        List<Hobby> hobbyList0 = new ArrayList<Hobby>();
        List<Hobby> hobbyList1 = new ArrayList<Hobby>();
        List<Hobby> hobbyList2 = new ArrayList<Hobby>();
        List<Hobby> hobbyList3 = new ArrayList<Hobby>();
        List<Hobby> hobbyList4 = new ArrayList<Hobby>();
        List<Hobby> hobbyList5 = new ArrayList<Hobby>();

        hobbyList0.add(new Hobby("Innot", 2, addressList0));
        hobbyList0.add(new Hobby("Pescuit", 3, addressList1));
        hobbyList1.add(new Hobby("Antrenament fizic", 5, addressList2));
        hobbyList1.add(new Hobby("Jogging", 3, addressList3));
        hobbyList2.add(new Hobby("Dans", 2, addressList4));
        hobbyList3.add(new Hobby("Cantat", 3, addressList5));
        hobbyList4.add(new Hobby("Fotbal", 5, addressList6));
        hobbyList5.add(new Hobby("Gaming", 3, addressList7));

        // Declaram hashmap-uri si inseram key objects de tip Persoana si value-uri de tip hobbyList cu adrese implicite.

        HashMap<Persoana, List<Hobby>> hashMap0 = new HashMap<>();

        hashMap0.put(persoana0, hobbyList0);
        hashMap0.put(persoana1, hobbyList1);
        hashMap0.put(persoana2, hobbyList2);
        hashMap0.put(persoana3, hobbyList3);
        hashMap0.put(persoana4, hobbyList4);
        hashMap0.put(persoana5, hobbyList5);

        // Aici folosim metoda declarata mai jos care contine iterator pentru key si value.

        hashMapIteratorMethod(hashMap0);

        // Exemplu de iterator functionand pentru orice HashMap, cu sau fara key/value:

        HashMap<Persoana, List<Hobby>> hashMap1 = new HashMap<>();

        hashMapIteratorMethod(hashMap1);

    }

    public static void hashMapIteratorMethod(Map<Persoana, List<Hobby>> map) {
        Iterator<Persoana> persoanaIterator = map.keySet().iterator();
        System.out.println("Persoane sortate dupa hashmap plus iterator: ");

        while (persoanaIterator.hasNext()) {
            Persoana key = persoanaIterator.next();
            List<Hobby> value = map.get(key);

            System.out.println(key + "" + value);
        }

    }
}
