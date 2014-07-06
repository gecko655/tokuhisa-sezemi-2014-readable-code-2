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
		if(args.length==1){
			printRecipe(recipeFile);
		}else if(args.length==2){
			if(isNaturalNumber(args[1])){
				long specifiedId = Long.valueOf(args[1]);
				printRecipe(recipeFile,specifiedId);
			}else{
				System.err.println("第2引数は整数値を与えてください");
				System.exit(1);
			}
		}
	}
	
	private static void printRecipe(File recipeFile) {
		printRecipe(recipeFile,0);
	}

	/**
	 * Print the recipe of given specifiedId.
	 * If specifiedId is 0, it prints all of recipes.
	 * @param recipeFile
	 * @param specifiedId
	 */
	private static void printRecipe(File recipeFile, long specifiedId) {
		boolean isNotSpecifiedId = (specifiedId == 0);
		boolean found = false;
		try {
			ArrayList<RecipeData> recipeDataList = readRecipeData(recipeFile);
			for(RecipeData data: recipeDataList){
				if(data.getRecipeId()==specifiedId||isNotSpecifiedId){
					System.out.println(data.getRecipeId()+ ": "+ data.getRecipeName());
					found =true;
				}
			}
			if(!found){
				System.err.println("指定されたIDのレシピが存在しません。");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("レシピデータのファイルが存在しません．");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("レシピデータの読み込みに失敗しました．");
		}
		
	}

	private static boolean isNaturalNumber(String string) {
		long l=-1;
		try{
			l=Long.valueOf(string);
		}catch(Exception e){
			//NumberFormatException and NullPointerException are considered.
			return false;
		}
		if(l<=0){
			return false;
		}
		return true;
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
