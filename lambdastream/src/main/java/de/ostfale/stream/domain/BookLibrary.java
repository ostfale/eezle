package de.ostfale.stream.domain;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static de.ostfale.stream.domain.Topic.COMPUTING;

/**
 * Initialize some books in library
 * Created : 24.04.2018
 *
 * @author : usauerbrei
 */
public class BookLibrary {

	public static List<Book> initBookList() {
		List<Book> bookList = new ArrayList<>(4);
		bookList.add(new Book("Fundamentals of Chinese Fingernail Image", Arrays.asList("Li", "Fu", "Li"), new int[]{256}, Topic.MEDICINE, Year.of(2014), 25.2));
		bookList.add(new Book("Compilers: Principles, Techniques", Arrays.asList("Aho", "Lam", "Sethi", "Ullmann"), new int[]{1009}, Topic.COMPUTING, Year.of(2006), 23.6));
		bookList.add(new Book("Voss", Arrays.asList("Patrick White"), new int[]{478}, Topic.FICTION, Year.of(1957), 19.8));
		bookList.add(new Book("Lord of the Rings", Arrays.asList("Tolkien"), new int[]{531, 416, 624}, Topic.FICTION, Year.of(1955), 23.0));
		return bookList;
	}
}
