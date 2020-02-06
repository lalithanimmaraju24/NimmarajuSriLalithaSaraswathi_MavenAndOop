package EPAM.NewYearGift;
import java.util.*;

public class App 
{
	
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<NewYearGift> gifts = new ArrayList<NewYearGift>();
	
	static NewYearGift gift;
	
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the New Year Gifts!!!");
        System.out.println("Enter Minimal weight of Gift Basket");
        int minweight = sc.nextInt();
        System.out.println("Enter Maximum wight of gift Basket");
        int maxweight = sc.nextInt();
        boolean check = true;
        int choice;
        
        do {
        	System.out.println("Enter your Choice :");
        	System.out.println("1.Sweet ");
        	System.out.println("2.Chocolates");
        	System.out.println("3.Exit");
        	int ch = makeChoice(3);
        	
        	switch(ch)
        	{
        		case 1:
                	gift = new Sweet();
        			System.out.println("1.Kova");
        			System.out.println("2.Laddu");
        			System.out.println("3.Jalebi");
        			System.out.println("4.Mysore Paak");
        			System.out.println("5.Rasagulla");
                	choice = makeChoice(5);
                	switch(choice)
                	{
                		case 1:
                			gift = new Kova();
                			break;
                		case 2:
                			gift = new Laddu();
                		case 3:
                			gift = new Jalebi();
                			break;
                		case 4:
                			gift = new MysorePaak();
                		case 5:
                			gift = new Rasagulla();
                			
                	}
                	gifts.add(gift);
        		break;
        			
        		case 2:
                	gift = new Chocolate();
        			System.out.println("1.DairyMilk");
        			System.out.println("2.Eclairs");
        			System.out.println("3.FiveStar");
        			System.out.println("4.Snickers");
        			choice = makeChoice(4);
        			switch(choice)
                	{
                		case 1:
                			gift = new DairyMilk();
                			break;
                		case 2:
                			gift = new Eclairs(); 
                		case 3:
                			gift = new FiveStar();
                			break;
                		case 4:
                			gift = new Snickers();   
                	}
        			gifts.add(gift);
        		break;
        		
        		case 3:
        			check = false;
        	}
        }while(check == true);
        
        if(calculateTotalWeight()>=minweight && calculateTotalWeight()<=maxweight )
        {
        System.out.println("Selected Gifts are...");
        displaygift();
        }
        else
        {   
        	System.out.println("Sorry! New Years Gift Didn't met the Range You specified\n");
  
        }
    }
    public static void displaygift()
    {
    	sortByName();
    	for(int i =0 ;i<gifts.size(); i++)
    	{
    		System.out.println(gifts.get(i).getName()+" ----- "+Integer.toString(gifts.get(i).getWeight()));
    	}
    	System.out.println("Total Weight of the Gift Basket is: "+Integer.toString(calculateTotalWeight()));
    }
    
    public static void  sortByName() {
    	
    	Collections.sort(gifts, new Comparator<NewYearGift>(){
    	
    	  public int compare(NewYearGift o1, NewYearGift o2)
    	  {
    	     return o1.name.compareTo(o2.name);
    	  }
    	});
    }	
   

	public static Integer calculateTotalWeight() {
		
		int sum =0;
		for(int i =0 ;i<gifts.size();i++)
		{
			sum+= gifts.get(i).getWeight();
		}
		return sum;
	}


    public static int makeChoice(int limit) {
		System.out.println("Enter your choice");
		int choice = 0;

		while (true) {
			try {
				choice = sc.nextInt();
				validate(choice, limit);
				break;
			} catch (Exception e) {
				System.out.println("Exception occured: " + e);
			}

		}
		return choice;
	}

    static void validate(int choice, int limit) throws InvalidChoiceException {
		if (choice < 1 || choice > limit)
			throw new InvalidChoiceException(
					"You have made a wrong choice! Please choose between 1 - " + Integer.toString(limit));

	}

}
