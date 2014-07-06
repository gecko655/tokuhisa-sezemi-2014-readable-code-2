package readablecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;


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
			ArrayList<RecipeData> receipeDataList = readRecipeData(recipeFile);
			for(RecipeData data : receipeDataList) {
				System.out.println(data.getRecipeId()+ ": "+ data.getRecipeName());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("レシピデータのファイルが存在しません．");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("レシピデータの読み込みに失敗しました．");
		}
	}
	
	public static ArrayList<RecipeData> readRecipeData(File receipeDataFile) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(receipeDataFile));
		ArrayList<RecipeData> receipeDataList = new ArrayList<RecipeData>();

		try {
			int idCount = 0;
			while(reader.ready()) {
				String receipeDataName = reader.readLine();
				RecipeData data = new RecipeData(idCount, receipeDataName);
				receipeDataList.add(data);
				idCount += 1;
			}
			return receipeDataList;
		} catch (IOException e) {
			throw e;
		} finally {
			reader.close();
		}
	}

}
