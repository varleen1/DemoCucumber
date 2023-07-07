package pages;

import main.DatabaseConnection;

public class Test {

	public static void main(String[] args) {
		DatabaseConnection db = new DatabaseConnection();
		
		db.updateUser("1");
	}

}
