package DBLesson2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBLesson2{

	public static void main(String[] args) {

		ArrayList<Word> words = new ArrayList<>();
		WordDAO dao = new WordDAO();
		String input;
		int index = 0;

		// コマンドラインから入力
		System.out.println("英単語と日本語をスペースで区切って入力して下さい。");

		// ここから記述してください
		// 例えば、「apple  りんご」と入力されたときはtmp[0]に"apple"、tmp[1]に"りんご"が入る
		Scanner sc  = new
				Scanner(System.in);
		input = sc.nextLine(); //入力待ち

		try{

		while(!input.equals("e")){
			String[] tmp = new String[2];
			tmp = input.split(" ");
//			words[i] = new Word(tmp[0],tmp[1]);
			Word word1 = new Word(tmp[0],tmp[1]); //Wordクラスの”word1”という変数。

//			english[i] = tmp[0];
//			japanese[i] = tmp[1];

			words.add(word1);
			index++;
			System.out.println("次の単語を入力して下さい。\"e\"で終了します。");
			input = sc.nextLine();
		}
		}
		catch(Exception e) {
		e.printStackTrace();
		System.out.println("登録制限を 越えました。登録済みのデータは以下になります。");
		}

//		for (int i= 0; i< words.size(); i++) {
//			System.out.println(words.get(i).toString());
//		}

		//ここのクラスとメッソドを他の
		//memo printではなくregistにすることで、DB登録にする。
		//words の中のwordオブジェクトの中の単語はword.getEmglish という書き方で。

//		◾︎参考の書き方
//		for(Word word1 : words){
//			System.out.println(word1.toString());
//		}
//		for (データ型 変数名: コレクション){
//			  実行する文1;
//			  実行する文2;
//			  ...
//			}

		dao.registWords(words);
		System.out.println( index+"件、登録しました。");

		List<Word> setword = new ArrayList<>();
		setword = dao.getWords();

		int wordi=0;

		for(Word word1 : setword){
			System.out.println(word1);
			wordi++;
		}

//		for ( wordi=0; wordi< setword.size(); wordi++ ){
//			System.out.println(setword);
//		}
		System.out.println( "\n登録されている単語は" + wordi +"件です");
	}
}