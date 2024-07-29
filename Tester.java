import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

public class Tester implements CollectionTest{
    int size;
    ArrayList<Person> personarray;
    LinkedList<Person> personlinked;
    HashMap<Integer,Person> personhash;

    public Tester(){

    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    
    // In the runTest the parameters type and test are used to decide what method of test will take place with what type of collection type
    @Override
    public void runTest(CollectionTest.CollectionType type, CollectionTest.TestType test, int iterations) {
        for(int i =0; i<iterations;i++)
        {
            if(type == CollectionType.ARRAY_LIST && test == TestType.ADD)
            {
                arraylistpopulate();
            }
            if(type == CollectionType.ARRAY_LIST && test == TestType.INDEX)
            {
                arraylistindex();
            }
            if(type == CollectionType.ARRAY_LIST && test == TestType.SEARCH)
            {
                arraylistsearch();
            }

            if(type == CollectionType.LINKED_LIST && test == TestType.ADD)
            {
                linkedlistpopulate();
            }

            if(type == CollectionType.LINKED_LIST && test == TestType.INDEX)
            {
                linkedlistindex();
            }
            if(type == CollectionType.LINKED_LIST && test == TestType.SEARCH)
            {
                linkedlistsearch();
            }

            if(type == CollectionType.HASH_MAP && test == TestType.ADD)
            {
                hashmappopulate();
            }

            if(type == CollectionType.HASH_MAP && test == TestType.INDEX)
            {
                hashmapindex();
            }
            if(type == CollectionType.HASH_MAP && test == TestType.SEARCH)
            {
                hashmapsearch();
            }
        }
        
    }
    // For arraylistpopulate,linkedlistpopulate and hashmappopulate will create the lists and map which will be populated by people by the size
    public void arraylistpopulate()
    {
        personarray = new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            personarray.add(new Person(Integer.toString(i), i));
        }
    }

    public void linkedlistpopulate() 
    {
        personlinked = new LinkedList<>();
        for(int i=0;i<size;i++)
        {
                personlinked.add(new Person(Integer.toString(i), i));
        }
    }

    public void hashmappopulate() 
    {
        personhash = new HashMap<>();
        for(int i=0;i<size;i++)
        {
            personhash.put(i,new Person(Integer.toString(i),i));
        }        
    }



    
    // For each type the index will be half the size and will retrieve/return the person there when it is found
    public Person arraylistindex() 
    {
        return(personarray.get((int)(size/2)));

    }
    public Person linkedlistindex() 
    {
        return(personlinked.get((int)(size/2)));
    }

    public Person hashmapindex() 
    {
        int persontoget = (personhash.size())/2;
        for(int Person : personhash.keySet()){
            if(Person == persontoget)
            {
                return personhash.get(persontoget);
            }
        }
        return null;
    }
    // For each type the search will retrieve/return person from the collection based only the Person's name
    public Person arraylistsearch() 
    {
        String persontoget = Integer.toString((personarray.size())/2);
        for(Person person : personarray)
        {
            if(person.getName().equals(persontoget))
            {
                return person;
            }
        }
        return null;
    }

    public Person linkedlistsearch() 
    {
        String persontoget = Integer.toString((personlinked.size())/2);
        for(Person person : personlinked)
        {
            if(person.getName().equals(persontoget))
            {
                return person;
            }
        }
        return null;
    }

    public Person hashmapsearch() 
    {
        int persontoget = (personhash.size())/2;
        if(personhash.containsKey(persontoget))
        {
            return(personhash.get(persontoget));
        }
        return null;
 
    }
}