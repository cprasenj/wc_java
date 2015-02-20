public class Word {
	private String content;

	public Word(String text) {
		this.content = text;
	}

	public int count() {
		return content == "" ? 0 : content.trim().split("\\s+").length;
	}

}