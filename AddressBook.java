package addressBook;

import addressBook.utils.Compare;
import java.util.*;
import java.io.*;

/*	Menu driven Address Book to manage Person's information. 
*	@author-Ansh Mittal
*	17ucs028@lnmiit.ac.in/mittalansh22@gmail.com
*/	

public class AddressBook{
	private String addressBookName;
	private List<Person> entries=new ArrayList<>();

	public AddressBook(String addressBookName){
		this.addressBookName=addressBookName;
	}

	public AddressBook() {
	}

	public String getAddressBookName() {
		return addressBookName;
	}

	public void setAddressBookName(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	public List<Person> getEntries() {
		return entries;
	}

	public void setEntries(List<Person> entries) {
		this.entries = entries;
	}

	public void addPerson(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("------------------Add Person--------------------");
		System.out.println("Enter the Person's firsName");
		String firsName= sc.nextLine();

		System.out.println("Enter the Person's lastName");
		String lastName = sc.nextLine();

		System.out.println("Enter the Person's address");
		String address = sc.nextLine();

		System.out.println("Enter the Person's city");
		String city = sc.nextLine();

		System.out.println("Enter the Person's state");
		String state = sc.nextLine();

		System.out.println("Enter the Person's zip(Please enter a number)");
		int zip = sc.nextInt();

		System.out.println("Enter the Person's phoneNumber(Please enter a number)");
		long phoneNumber = sc.nextLong();
		System.out.println("--------------------------------------------");

		Person person = new Person(firsName,lastName,address,city,state,zip,phoneNumber);
		this.entries.add(person);
		System.out.println("Person added : \n" + person.getInformation());
		System.out.println("--------------------------------------------");


	}

	private void editPerson(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("---------------Edit Person--------------------");
		System.out.println("Phone Number of the person that you want to edit (Please enter a number) :");

		Person person = findPerson(getPhoneNumberAsIndex());
		
		if(person==null){
			System.out.println("Number is not present in addressBook");
			return;
		}

		System.out.println("----------------current Information-----------------");    	
		System.out.println(person.getInformation());
		System.out.println("--------------------------------------------");

		boolean flag=true;
		while(flag){
			System.out.println("Which field would you like to edit: \n1. First Name\n2. Last Name\n3. Address\n4. City\n5. State\n6. Zip\n7. phone Number\n8. Exit Edit Mode");
			System.out.println("--------------------------------------------");
			
			int opt = sc.nextInt();
			sc.nextLine();
			switch(opt){
				case 1:
							System.out.println("Enter the new firsName");
							person.setFirstName(sc.next());
							break;

				case 2:
							System.out.println("Enter the new lastName");
							person.setLastName(sc.next());
							break;
				case 3:
							System.out.println("Enter the new address");
							person.setAddress(sc.next());
							break;
				case 4:
							System.out.println("Enter the new city");
							person.setCity(sc.next());
							break;
				case 5:
							System.out.println("Enter the new state");
							person.setState(sc.next());
							break;
				case 6:
							System.out.println("Enter the new zip");
							person.setZip(sc.nextInt());
							break;
				case 7:
							System.out.println("Enter the new phoneNumber");
							person.setPhoneNumber(sc.nextLong());
							break;
				case 8:
							flag=false;
							break;
				
				default:
							System.out.println("Invalid input.");
			}
		}
		System.out.println("----------------updated Information-----------------");    	
		System.out.println(person.getInformation());
		System.out.println("--------------------------------------------");
	}

	private void deletePerson(){
		System.out.println();
		System.out.println("---------------Delete Person--------------------");
		while(true){

			System.out.println("Phone Number of the person that you want to delete:");
			Person person = findPerson(getPhoneNumberAsIndex());

			if(person==null){
				System.out.println("Number is not present in addressBook");
				continue;
			}

			try{
				entries.remove(person);
				System.out.println("Person deleted Successfully");
				break;

			} catch(Exception ex){
				System.out.println("Exception"+ex);
				continue;
			}
		}
	}

	private Person findPerson(long phoneNumber){
		for (Person tempPerson : entries) {
			if (tempPerson.getPhoneNumber() == phoneNumber) {
				return tempPerson;
			}
		}
		return null;

	}

	private long getPhoneNumberAsIndex(){
		Scanner sc = new Scanner(System.in);
		long phoneNumber = sc.nextLong();
		return phoneNumber;

	}
	
	private void sortEntries(){
		List<Person> entriesOfPersons = this.entries;
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("---------------Sort Entries--------------------");

		System.out.println("Which field would you like to edit: \n1. First Name\n2. Full Name\n3. Address\n4. Zip\n5. Exit Edit Mode");
		System.out.println("--------------------------------------------");
		
		int opt = sc.nextInt();
		sc.nextLine();
		switch(opt){
			case 1:
						Collections.sort(entriesOfPersons, Compare.firstNameComparator);
						break;
			case 2:
						Collections.sort(entriesOfPersons, Compare.fullNameComparator);
						break;
			case 3:
						Collections.sort(entriesOfPersons, Compare.addressComparator);
						break;
			case 4:
						Collections.sort(entriesOfPersons, Compare.zipComparator);
						break;
			case 5:
						break;
			
			default:
						System.out.println("Invalid input.");
			}

		System.out.println("Sorting Complete");    	
		this.displayEntries(entriesOfPersons);
		System.out.println("--------------------------------------------");

	}

	private void displayEntries(List<Person> entriesOfPersons){
		System.out.println("---------------Entries--------------------");
		for (Person person : entriesOfPersons) {
			System.out.println(person.getInformation());
			System.out.println("-------------------------------");		
		}
	}

	private void displayEntries(){
		displayEntries(this.entries);
	}

	private void saveAddressBookToFile(){
		try {
			
			FileWriter myWriter = new FileWriter(this.addressBookName+".txt");
			for(Person person:entries){
				myWriter.write(person.getInformation());
				myWriter.write("\n\n");
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void showMenu(){
		System.out.println("\n");
		System.out.println("---------------Menu-----------------------");
		System.out.println("choose the following:-\n");
		System.out.println("\t1.\t Add  a Person");
		System.out.println("\t2.\t Edit  a Person");
		System.out.println("\t3.\t Delete  a Person");
		System.out.println("\t4.\t Find  a Person");
		System.out.println("\t5.\t Sort Address Book Entries");
		System.out.println("\t6.\t Display Address Book");
		System.out.println("\t7.\t Save Address Book");
		System.out.println("\t8.\t Exit");
		System.out.println("--------------------------------------------");
	}

	public static void main(String args[]){
		System.out.println("Welcome to the address Book Application");

		System.out.println("Enter the name of your addressBook");
		Scanner sc = new Scanner(System.in);
		
		AddressBook addressBook = new AddressBook(sc.next());
		
		boolean choice=true;
		while(choice){
			showMenu();
			int task = sc.nextInt();
			sc.nextLine();
			
			switch(task){

				case 1:			addressBook.addPerson();
								break;

				case 2:			addressBook.editPerson();
								break;

				case 3:			addressBook.deletePerson();
								break;

				case 4:			System.out.println("Phone Number of the person that you want to find:");
								Person person = addressBook.findPerson(addressBook.getPhoneNumberAsIndex());
								if(person==null){
									System.out.println("no match found");
								}
								else{
									System.out.println(person.getInformation());
								}
								break;
				
				case 5:			addressBook.sortEntries();
								break;

				case 6:			addressBook.displayEntries();
								break;

				case 7:			addressBook.saveAddressBookToFile();
								break;

				case 8:			choice=false;
								break;

				default:
								System.out.println("wrong choice!!");

			}
		}

				
	}
}