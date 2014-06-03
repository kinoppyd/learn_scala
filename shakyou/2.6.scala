// whileを使ったループは、命令型のスタイル(imperative styel)である
// Scalaでは、関数型のスタイル(functional style)が推奨される

// 次のステートメントは、argsのforeachメソッドを呼び出し、そのメソッドに関数を渡している
// 渡されているのは、argという一つの引数をとる、関数リテラル(function literal)
args.foreach(arg => println(arg))
// このとき、argsはString型の配列なので、ScalaコンパイラはargがStringであると型推論を行う
// 省略をせずに書くと、次のようになる
args.foreach( (arg: String) => println(arg) )

/*
関数リテラルの構文
   (x: Int, y: Int)         =>        x + y
括弧で囲まれたパラメータ   右矢印    関数本体
*/

// また、簡潔性を優先するときには、関数リテラルが一つのパラメータをとる一文のときに、次の書き方が出来る
args.foreach(println)
// これは、部分的要された関数(partially applyed function)と呼ばれ、8.7節で解説される


// Scalaでforを扱いたい場合は、for文に対応する関数型の変種（for式）を用いる
for(arg <- args)
    println(arg)
// このとき、argはvalの変数である（ループごとに変わるからvarの様に見えるが、毎回新しく作られたvalである）
// 必ずvalなので、この構文ではvalの宣言が省略されている
