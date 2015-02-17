public class wc{
	private String expression = null;

	public wc(String exp) {
		this.expression = exp;
	}

	public int charCount() {
		return expression.length();
	}
	private int occurenceOfChar(char c) {
		int i,count = 0,limit = this.charCount();
		char[] tmp = expression.toCharArray();
		for(i = 0;i<limit;i++) 
			if(tmp[i] == c)
				count++;
		return count;
	}
	public int wordCount() {
		return occurenceOfChar(' ') + 1;
	}

	public int lineCount() {
		return occurenceOfChar('\n') + 1;
	}
}