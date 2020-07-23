package addressBook.utils;

import java.util.Comparator;
import addressBook.Person;

public class Compare{

	public static Comparator<Person> firstNameComparator = new Comparator<Person>() {

		public int compare(Person n1, Person n2) {
			String firstName1 = n1.getFirstName().toUpperCase();
			String firstName2 = n2.getFirstName().toUpperCase();
			return firstName1.compareTo(firstName2);
		}};

	public static Comparator<Person> zipComparator = new Comparator<Person>() {

		public int compare(Person n1, Person n2) {

			int zip1 = n1.getZip();
			int zip2 = n2.getZip();

			return zip1 - zip2;
		}
	};

	public static Comparator<Person> addressComparator = new Comparator<Person>() {

		public int compare(Person n1, Person n2) {

			String address1 = n1.getAddress().toUpperCase();
			String address2 = n2.getAddress().toUpperCase();

			return address1.compareTo(address2);
		}
	};

	public static Comparator<Person> fullNameComparator = new Comparator<Person>() {

		public int compare(Person n1, Person n2) {

			String name1 = n1.getFirstName().toUpperCase()+n1.getLastName().toUpperCase();
			String name2 = n2.getFirstName().toUpperCase()+n2.getLastName().toUpperCase();

			return name1.compareTo(name2);
		}
	};
}