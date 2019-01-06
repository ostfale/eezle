package naftalin.streams.bookexample;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Bootstrap class to initialize books
 * Created : 13.11.2018
 *
 * @author : usauerbrei
 */
public class Bootstrap {

	private static List<Book> library = new ArrayList<>();

	private static void initBooks() {
		library.add(new Book("Fundamentals of chinese fingernail images", Arrays.asList("Li", "Fu", "Li"), new int[]{256}, 25.2, Topic.MEDICINE, Year.of(2004)));
		library.add(new Book("Compilers, Principles, Techniques and Tools", Arrays.asList("Abo", "Lam", "Sethi", "Ullman"), new int[]{1009}, 23.6, Topic.COMPUTING, Year.of(2006)));
		library.add(new Book("Voss", Collections.singletonList("Patrick White"), new int[]{478}, 19.8, Topic.FICTION, Year.of(1957)));
		library.add(new Book("Lord of the Rings", Collections.singletonList("Tolkien"), new int[]{531, 416, 624}, 23, Topic.FICTION, Year.of(1955)));
	}

	public static List<Book> getLibrary() {
		if (library.isEmpty()) {
			initBooks();
		}
		return library;
	}
}
