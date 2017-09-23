package DBLesson2;

public class Word{
	//	public static int length;
	private String english;
	private String japanese;
	//	public Word(){
	//
	//	}

	public Word(String english, String japanese) {
		super();
		this.english = english;
		this.japanese = japanese;
	}

	public String toString(){
		return "英単語："+english+" 日本語："+japanese;
	}

	public String getEnglish(){
		return english;
	}

	public String getJapanese(){
		return japanese;
	}

	public void setEnglish(String english){
		this.english = english;
	}

	public void setJapanese(String japanese){
		this.japanese = japanese;
	}
}