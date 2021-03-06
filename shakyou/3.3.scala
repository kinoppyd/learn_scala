/*
 タプルとは？
 コンテナオブジェクト。Listと同様にimmutableだが、異なる型の要素を持つことが出来る
 Listは、List[Int]やList[String]のように型が限定されるが、タプルは整数と文字列を混在させられる
 メソッドから、複数の値を返す場合などに使用される(JavaBeans風のクラスの定義が必要なく、タプルで置き換えられる)
 タプルの初期化はリストと同じく、カンマ区切りで要素を並べる
 アクセスには、_(アンダースコア)と、「「1から始まる要素の番号」」を指定する
 Listのようにapplyメソッドを使用しないのは、applyメソッドは常に1つの型の戻り値が定義されているが、タプルの各要素で型が異なるためである
 また、タプルのインデックスが1から始まる理由は、HaskellやML等の他の言語の伝統に則っているため
*/

val pair = (99, "Luftballons")
println(pair._1)
println(pair._2)

/*
 タプルの実際の型は、格納している要素の数と型によって決まる
 (99, "Luftballons") は、Tuple2[Int, String]であり、
 ('u', 'r', "the", 1, 4, "me") は、Tuple6[Char, Char, String, Int, Int, String]である
*/
