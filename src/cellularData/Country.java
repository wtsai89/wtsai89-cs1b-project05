package cellularData;

/**
 * Stores the entire subscription data for a single country
 */
public class Country {
    private String name;
    private SubscriptionYear[] subscriptionsPerYear;
    private int index, startingYear, endingYear;

    /**
     *
     * @param name sets the country name
     * @param years sets the length of the subscriptionsPerYear array
     */
    public Country(String name, int years)
    {
        this.name = name;
        subscriptionsPerYear = new SubscriptionYear[years];
        index = 0;
    }

    /**
     * constructor that only sets the country name
     * @param name
     */
    public Country(String name)
    {
        this.name = name;
    }

    /**
     * Creates a new SubscriptionYear object and saves it in subscriptions array
     * @param year
     * @param subscriptions
     */
    public void addSubscriptionYear(int year, double subscriptions)
    {
        subscriptionsPerYear[index] = new SubscriptionYear(year, subscriptions);
        if(index == 0)
            startingYear = year;
        endingYear = year;
        index++;
    }

    /**
     * accessor method for name
     * @return
     */
    public String getName() { return name; }

    /**
     * returns the total number of subscriptions between start and end years
     * @param start
     * @param end
     * @return
     */
    public double getNumSubscriptionsForPeriod(int start, int end)
    {
        if(start > end)
            throw new IllegalArgumentException("Error: Starting year and ending year are inverted.\n");
        if((start > endingYear && end > endingYear) || (start < startingYear && end < startingYear))
            throw new IllegalArgumentException("Error: Both starting year and ending year are out of range.\n");

        int validStart = start;
        int validEnd = end;
        int flag = 0;  //only display corrected range if there is a discrepancy
        if (start < startingYear) {
            validStart = startingYear;
            flag = 1;
        }
        if (end > endingYear) {
            validEnd = endingYear;
            flag = 1;
        }
        if (flag == 1)
            System.out.printf("Illegal Argument Request of year range %d - %d. Valid period for %s is %d to %d\n", start, end, name, validStart, validEnd);

        double sum = 0;
        for(int i = validStart - startingYear; i <= validEnd - startingYear; i++)
            sum += subscriptionsPerYear[i].getSubscriptions();

        return sum;
    }

    /**
     * displays the country name and all of the subscriptions in a single formatted line
     * @return
     */
    public String toString()
    {
        String s = String.format("%-20s", name);
        for(int i = 0; i < subscriptionsPerYear.length; i++)
            s += String.format("%7.2f", subscriptionsPerYear[i].getSubscriptions());

        s += "\n";
        return s;
    }

    /**
     * If the countries' names are equal then return true
     * @param country
     * @return
     */
    public boolean equals(Country country)
    {
        if(this.name.equals(country.getName()))
            return true;

        return false;
    }
}
