package naftalin.booksfindingexample;

/**
 * Helper class for a Book which holds the placement (disp) and it's own length
 * Created : 22.11.2018
 *
 * @author : usauerbrei
 */
public class DispRecord {

	final String title;
	final int disp;
	final int length;

	public DispRecord(String title, int disp, int length) {
		this.title = title;
		this.disp = disp;
		this.length = length;
	}

	int totalDisp() {
		return disp + length;
	}
}
