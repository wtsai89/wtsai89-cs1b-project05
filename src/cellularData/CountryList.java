package cellularData;

public class CountryList {
    private CountryNode head, walker;
    private int size;

    public CountryList()
    {
        head = null;
        size = 0;
    }

    public void add(Country country)
    {
        CountryNode node = new CountryNode(country);

        if(head == null)
        {
            head = node;
        }
        else
        {
            walker = head;
            while(walker.getNext() != null)
                walker = walker.getNext();
            walker.setNext(node);
        }

        size++;
    }

    public Country getIndex(int index)
    {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        walker = head;
        for(int i = 0; i < index; i++)
        {
            walker = walker.getNext();
        }

        return walker.getCountry();
    }

    public Country contains(Country country)
    {
        walker = head;
        Country foundCountry;
        for(int i = 0; i < size; i++)
        {
            foundCountry = walker.getCountry();
            if(foundCountry.equals(country))
                return foundCountry;
            walker = walker.getNext();
        }

        return null;
    }

    public String toString()
    {
        String s = "";
        walker = head;
        for(int i = 0; i < size; i++)
        {
            s += walker.getCountry();
            walker = walker.getNext();
        }

        return s;
    }

    public int size()
    {
        return size;
    }

    public void insertAtIndex(Country country, int index)
    {
        if(index < 0)
            throw new IndexOutOfBoundsException();
        if(index >= size)   //add to end. If size = 0 then it will default to this
        {
            add(country);
        }
        else
        {
            if(index == 0)  //add to beginning
            {
                head = new CountryNode(country, head);
            }
            else //add to middle
            {
                CountryNode before = head;
                CountryNode after = head.getNext();
                for(int i = 1; i < index; i++)
                {
                    before = after;
                    after = after.getNext();
                }
                CountryNode node = new CountryNode(country, after);
                before.setNext(node);
            }
            size++;
        }
    }
}
