public class wc{
	private String expression = null;

	public wc(String exp) {
		this.expression = exp;
	}

	public int charCount() {
		return expression.length();
	}
}