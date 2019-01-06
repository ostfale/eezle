package naftalin.streams.bookexample;

import java.time.Year;
import java.util.List;

/**
 * Book pojo
 * Created : 13.11.2018
 *
 * @author : usauerbrei
 */
public class Book {

	int[] pageCount;
	double height;
	Topic topic;
	Year pubDate;
	private String title;
	private List<String> authors;

	public Book(String title, List<String> authors, int[] pageCount, double height, Topic topic, Year pubDate) {
		this.title = title;
		this.authors = authors;
		this.pageCount = pageCount;
		this.height = height;
		this.topic = topic;
		this.pubDate = pubDate;
	}

	@Override
	public String toString() {
		return "Book{" +
				       "title='" + title + '\'' +
				       '}';
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public int[] getPageCount() {
		return pageCount;
	}

	public void setPageCount(int[] pageCount) {
		this.pageCount = pageCount;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Year getPubDate() {
		return pubDate;
	}

	public void setPubDate(Year pubDate) {
		this.pubDate = pubDate;
	}
}
