package cellularData;

public class CountryNode {
    private Country country;
    private CountryNode next;

    public CountryNode(Country country)
    {
        this.country = country;
        next = null;
    }

    public CountryNode(Country country, CountryNode next)
    {
        this.country = country;
        this.next = next;
    }

    public Country getCountry()
    {
        return country;
    }

    public CountryNode getNext()
    {
        return next;
    }

    public void setNext(CountryNode next)
    {
        this.next = next;
    }

}
