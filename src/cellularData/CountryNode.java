package cellularData;

/**
 * Node of the CountryList class
 */
public class CountryNode {
    private Country country;
    private CountryNode next;

    /**
     * this node is not connected to another node
     * @param country
     */
    public CountryNode(Country country)
    {
        this.country = country;
        next = null;
    }

    /**
     * this node is connected to another node
     * @param country
     * @param next
     */
    public CountryNode(Country country, CountryNode next)
    {
        this.country = country;
        this.next = next;
    }

    /**
     * getter method for country
     * @return
     */
    public Country getCountry()
    {
        return country;
    }

    /**
     * getter method for the next node
     * @return
     */
    public CountryNode getNext()
    {
        return next;
    }

    /**
     * setter method for the next node
     * @param next
     */
    public void setNext(CountryNode next)
    {
        this.next = next;
    }

}
