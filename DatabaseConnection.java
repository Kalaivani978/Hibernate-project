package JavaFSD.JavaFSDMaven1;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DatabaseConnection {
	
	private static Scanner scan = new Scanner(System.in);
	SwiggyBlueprint res;  // class level attribute
	
	/* to create connection with mysql the configuration was done in the below method.After configuration done 
	toManipulateData method has been called to start the process*/
	
	public void toCreateConnection() {
		try {
			Configuration config = new Configuration().configure().addAnnotatedClass(SwiggyBlueprint.class);
			SessionFactory sessionFact = config.buildSessionFactory(); 
			Session session = sessionFact.openSession();
			toManipulateData(session);

		}catch(HibernateException obj) {

		}
		catch(Exception obj) {

		}

	}
  // Based on the user input, the choice have been taken and processed by calling the respective method.
	
	public  void toManipulateData(Session session) {
		int userChoice;
		do {
			System.out.println("Please choose the option 1.Add the Restaurant , 2. Update the Restaurant, 3. Search the Restaurant, 4.Delete the restaurant, 5.Log out");
			userChoice=scan.nextInt();	
			switch(userChoice) {
			case 1:addRestaurant(session);
				   break;
			case 2:updateById(session);
				   break;
			case 3:search(session);
			       break;
			case 4:deleteById(session);
			       break;
			case 5:SwiggyBlueprint.toCallLogOut();
			       session.close();
			       break;
			default:System.out.println("You have entered the wrong choice");
			        session.close();
			        break;
			}
		}while(userChoice<=4);
	}
// added the restaurant using the method getRestaurantList
	
 private static void addRestaurant(Session session) {
 		System.out.println("Enter the restaurant detail to add");
 		session.beginTransaction();
 		int Integer = (Integer) session.save(getRestaurantList());
 		System.out.println("Inserted value is:"+Integer);
 		session.getTransaction().commit();

 	}
 
 
		
/*Have taken the user Inputed id & getted the details. If the detail is there then, we removed the particular id details from the list.
  If not then we will print as id doesn't exist*/
 
 private static void deleteById(Session session) {
 		
 		System.out.println("Enter the position of the id to delete");
 		int id = scan.nextInt();
 		SwiggyBlueprint res = session.get(SwiggyBlueprint.class, id);

 		if(res != null) {
 			session.beginTransaction();
 			session.remove(res);
 			System.out.println("Deleted Successfully");
 			session.getTransaction().commit();
 		}
 		else {
 			System.out.println("Restaurant id doesnt exists..");

 		}	
 	}
 /*will get the user inputed id and check whether it is there if so we will update what the user want to update in that particular id. 
  * If not then we will show id doesn't exist*/
 
 private static void updateById(Session session) {
 		System.out.println("Enter the position of id to update");
 		int id = scan.nextInt();
 		SwiggyBlueprint res = session.get(SwiggyBlueprint.class, id);
 		if(res != null) {
 			//scanner obj 
 			System.out.println("Enter the restaurant name");
     		res.setRes_Name(scan.next());
     		System.out.println("Enter the owner name");
        	res.setOwn_Name(scan.next());
     		System.out.println("Enter the food type");
       		res.setFood_Type(scan.next());
     		System.out.println("Enter the location");
     		res.setLocation(scan.next());
     		System.out.println("Enter the price");
     		res.setPrice(scan.nextInt());
     		System.out.println("Enter the rating");
     		res.setRatings(scan.nextDouble());
 			session.beginTransaction();
 			session.persist(res);
 			session.getTransaction().commit();
 		}
 		else {
 			System.out.println("Restaurant id doesnt exists..");

 		}	
 	}
 
 /*Will get user input and check whether it is there, If so we will print that particular id. 
  * If not we will display id doesn't exist*/
 private static void search(Session session){
 		System.out.println("Enter the position of the id to search");
 		int id = scan.nextInt();
 		SwiggyBlueprint res = session.get(SwiggyBlueprint.class, id);
 		if(res != null) {
 			System.out.println(res);
 		}
 		else {
 			System.out.println("Restaurant id doesnt exists..");

 		}
 	}
 
 
 // the below method for getting the user input and to set it in the list.
 
 private static SwiggyBlueprint getRestaurantList() {
	    SwiggyBlueprint res = new SwiggyBlueprint();
 		System.out.println("Enter the restaurant name");
 		res.setRes_Name(scan.next());
 		System.out.println("Enter the owner name");
    	res.setOwn_Name(scan.next());
 		System.out.println("Enter the food type");
   		res.setFood_Type(scan.next());
 		System.out.println("Enter the location");
 		res.setLocation(scan.next());
 		System.out.println("Enter the price");
 		res.setPrice(scan.nextInt());
 		System.out.println("Enter the rating");
 		res.setRatings(scan.nextDouble());
 		return res;
 	}
 	

}
