package EPAM.NewYearGift;

abstract public class NewYearGift {
	int weight;
	String name;
	
	abstract public void defineWeight();
	
	abstract public void defineName();

	public int getWeight()
	{
		return weight;
	}
	public String getName()
	{
		return name;
	}
}
