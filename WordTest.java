import org.junit.Test;
import static org.junit.Assert.*;

public class WordTest {
	@Test
	public void wordHoldsTheWordAndTheLengthOfTheText_001() {
		Word word = new Word("Hello");
		assertEquals(word.count(),1);
	}

	@Test
	public void wordHoldsTheWordAndTheLengthOfTheText_002() {
		Word word = new Word("     r");
		assertEquals(word.count(),1);
	}

	@Test
	public void wordHoldsTheWordAndTheLengthOfTheText_003() {
		Word word = new Word("     thought Works");
		assertEquals(word.count(),2);
	}

	@Test
	public void wordHoldsTheWordAndTheLengthOfTheText_004() {
		Word word = new Word("     thought                                                              Works");
		assertEquals(word.count(),2);
	}
}