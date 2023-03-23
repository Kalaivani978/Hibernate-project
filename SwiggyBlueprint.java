package JavaFSD.JavaFSDMaven1;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*
 * This is the blueprint for the Swiggy Management System. Using hibernate, we have done the project. This class
 * will act as a table in database because of @Entity annotation.
 * I have assigned the table name using @Table annotaion.If we haven't specified, then the class name will 
 * considered as table name.
 * @Id is used to indicate the primary key. Every table must need primary key.
 * @GeneratedValue is used to indicate the primary key type.
 */

@Entity
@Table(name = "Swiggy")

public class SwiggyBlueprint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Identity=start by 1 and increment by 1
	private Integer id;

	
	private String res_Name;
	private String own_Name;
	private String food_Type;
	private Integer price;
	private String location;
	private Double ratings;
	
	// for login purpose have used the variable username and password with final keyword
	
	private static final String USERNAME= "Kalaivani";
	private static final String PASSWORD ="Kalai@123";

	// Getters and Setters(To get the value & set the value)
	
	
	public String getRes_Name() {
		return res_Name;
	}
	public void setRes_Name(String res_Name) {
		this.res_Name = res_Name;
	}
	public String getOwn_Name() {
		return own_Name;
	}
	public void setOwn_Name(String own_Name) {
		this.own_Name = own_Name;
	}
	public String getFood_Type() {
		return food_Type;
	}
	public void setFood_Type(String food_Type) {
		this.food_Type = food_Type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getRatings() {
		return ratings;
	}
	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}
	
	//login method (Check the user input with our login data. If it is match. Connection will create and program starts to run. If not it will throw the message as incorrect)
	public static void toCheckLogin(String user_Name,String pass_Word) {
		if(user_Name.equals(USERNAME)&&pass_Word.equals(PASSWORD)) {
			System.out.println("Logged in Successfully");
			DatabaseConnection obj = new DatabaseConnection();
			obj.toCreateConnection();	
		}
		else {
		 System.out.println("Username/password is incorrect");
		}
		
	}
	//logout method(to display it is logged out)
	public static void toCallLogOut() {
		System.out.println("Logged out successfully");
		
	}
	@Override
	public String toString() {
		return "Restaurant list [res_Id=" + id + ", res_Name=" + res_Name + ", own_Name=" + own_Name + ", food_Type="
				+ food_Type + ", price=" + price + ", location=" + location + ", ratings=" + ratings + "]";
	}


}
