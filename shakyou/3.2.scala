// メソッドは副作用を持ってはならない！

// Scalaの配列は、同じ型のオブジェクトを集めたmutableのシーケンス
// 初期化後の要素の数は変えられないが、要素の値は変えられる
// Scalaでは、同じ型のオブジェクトのimmutableなシーケンスは、Listである
val oneTwoThree = List(1, 2, 3)
// これはエラーになる
// oneTwoThree(1) = 2

// 2つのListを連結するためには、:::というメソッドを使う
val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo :: threeFour
println( oneTwo + " and " + threeFour + " were not muted...")
println( "Thus, " + oneTwoThreeFour + " is a new list")

// リスト操作でよく使われるメソッドは、cons(constructの略)
// consは、既存のリストの先頭に新しい要素を追加して、得られるリストを返す
val twoThree = List(2, 3)
val oneTwoThree2 = 1 :: twoThree
println(oneTwoThree2)

/*
1 :: twoThree という式において、::は右被演算子であるリストの、twothreeのメソッドである
:: メソッドの結合性は、次の様なルールに従っている
a * b の様に、メソッドを演算子的な表記で使う場合、メソッド名の末尾が:で無い限り、
メソッドは(a).*(b)の様に左被演算子で定義されたものから呼び出される
しかし、メソッド名の末尾が:の場合は、メソッドは右被演算子から呼び出される
1 :: twoThree は、twothree.::(1) と同義である
5.8節で詳しく説明されるらしい
*/

// 空リストをNilと書く。新しいリストは、Nilを最後の要素としてcons演算子で数珠繋ぎにすることで初期化できる
val fourFiveSix = 4 :: 5 :: 6 :: Nil
println(fourFiveSix)


// 他いろいろなメソッド
val thrill = "will" :: "fill" :: "until" :: Nil
// 長さが4の要素の数を返す
val count = thrill.count(s => s.length == 4)
println(count)

// 先頭の2要素を除いたthrillリストを返す(元のリストに変更は加わらない)
val drop2thrill = thrill.drop(2)
println(thrill)
println(drop2thrill)

// 末尾2要素を除くにはこう
println( thrill.dropRight(2) )

// リストの中に、関数リテラルが正を返す要素が存在するか確かめる
println( thrill.exists(s => s == "until") )

// リストをフィルタする
println( thrill.filter(s => s.length == 4) )

// 全ての要素について、関数リテラルの正をチェックする
println( thrill.forall(s => s.endsWith("l")) )

// 先頭を返す
println( thrill.head )
// 末尾を返す
println( thrill.last )
// 先頭を除いた残りのリストを返す
println( thrill.tail )
// 末尾を除いた残りのリストを返す
println( thrill.init )

// 全ての要素を処理した写像を返す
println( thrill.map(s => s + "y") )

// リストの中身を、セパレータを入れて並べた文字列を作る
println( thrill.mkString(", ") )

// ソート
println( thrill.sortWith( (l, r) => l.charAt(0).toLower < r.charAt(0).toLower ) )
