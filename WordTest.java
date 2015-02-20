import org.junit.Test;
import static org.junit.Assert.*;

public class WordTest {
	@Test
	public void wordHoldsTheWordAndTheLengthOfTheWord_001() {
		Word word = new Word("Hello");
		assertEquals(word.word,"Hello");
		assertEquals(word.length,5);
	}

	@Test
	public void wordHoldsTheWordAndTheLengthOfTheWord_002() {
		Word word = new Word("     ");
		assertEquals(word.word,"     ");
		assertEquals(word.length,5);
	}
}