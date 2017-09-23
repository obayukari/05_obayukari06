package DBLesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WordDAO {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

//	Statement stmt=null;
//	public WordDAO{
//	}

	public int registWords(ArrayList<Word>words) {
		int result = 0 ;
		try{

			String SQL = "INSERT INTO dictionary VALUES(?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8","root","");

			if(con!=null){
				System.out.println("DB接続完了(getConnection後)\r\n----");
			}
			else{
				System.out.println("DB接続失敗\r\n----");
			}

// 引数にWord型のArraylistをセット) {
//int registWords(List<Word>) {}

//		List<Word> words = new ArrayList<>();
//		WordDAO dao = new WordDAO();
//		words = dao.getWords();

			for (int i= 0; i< words.size(); i++) {

				Word wd = words.get(i);

				st = con.prepareStatement(SQL);

//				((PreparedStatement) stmt).setString(1, wd.getEnglish());
//				((PreparedStatement) stmt).setString(2, wd.getJapanese());

				st.setString(1, wd.getEnglish());
				st.setString(2, wd.getJapanese());
				st.executeUpdate();

//				result = result + //for文内で足されていく。無いと常に１になる
			}

		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;	// 結果を返す
	}
}
