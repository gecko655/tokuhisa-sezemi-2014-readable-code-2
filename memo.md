メモ
====================================

#テクニック

##仕様1
命名規則はキャメルケース

##仕様3
例外処理を細かく行った．読み込み時に発生したIOExceptionとFileNotFoundExceptionの場合は出力されるエラーが異なる．

##仕様4
RecipeDataクラスを作った．メンバ変数は頭にmをつける．

#gecko655 追記

- すべての識別子が詳細を表せている。例えば、  
    recipeDataList  
    recipeDataFilePath  
など


- ややこしいコードになってしまう入出力を別メソッドにまとめて隠蔽している。  
また、その中で起こったExceptionをすべてthrowしているので、例外処理をmainメソッドで行なうことができ、どのような例外処理をしているかがわかりやすい。


#仕様6
Idがあるときとないときで、コードを共通化し、読まなければいけないコード量を削減している  
このとき、"isNotSpecifiedId"という真偽値で、IDが指定されたかどうかを保持している。  
"isNotSpecifiedId"というのが一見わかりづらいが、
    if(data.getRecipeId()==specifiedId||isNotSpecifiedId)
というif文が、「データのidと指定したidが一致した時、またはidが指定されなかった時」というように読みやすくなると感じたので採用した。
