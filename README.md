tokuhisa-sezemi-2014-readable-code-2
====================================
開発言語: Java

# 実行手順
## Eclipseの場合
1. Eclipseのメニューから[File]->[Import]を選択．
2. 表示されたダイアログから[General]->[Existing Projects into Workspace]を選択して[Next]ボタンをクリック
3. [Select root directory]でこのプロジェクトのディレクトリを指定し，[Projects]でチェックボックスがチェックされているのを確認して[Finish]ボタンを押す．
4. 引数として与える場合は，メニューの[Run]->[Run Configurations...]から設定
5. [Package Explorer]からプロジェクトを選択し，Macの場合は[Shift][Command][F11]で実行 

# レシピデータのファイルフォーマット
レシピデータを1行に1個だけ書く．複数行可能．

# 引数

仕様6以降では以下の2つの引数を，この順番で渡す必要がある。
- レシピデータのファイル名
- 出力させたいレシピのid，0以外の整数値．省略した場合はすべてのレシピを出力する．
