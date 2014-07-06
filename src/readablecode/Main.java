package readablecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 0) {
			System.err.println("レシピデータのパスを引数で与えてください");
			System.exit(1);
		}
		String recipeDataFilePath = args[0];
		File recipeFile = new File(recipeDataFilePath);
		try {
			String recipeData = readRecipeData(recipeFile);
			System.out.println(recipeData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("レシピデータのファイルが存在しません．");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("レシピデータの読み込みに失敗しました．");
		}
	}
	
	public static String readRecipeData(File receipeDataFile) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(receipeDataFile));
		String receipeData;
		try {
			receipeData = reader.readLine();
			return receipeData;
		} catch (IOException e) {
			throw e;
		} finally {
			reader.close();
		}
	}

}
