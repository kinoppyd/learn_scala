// ファイルから読み込む
import scala.io.Source

// 先頭に行数を付けて表示
if( args.length > 0 ){
    for ( line <- Source.fromFile(args(0)).getLines() ) {
        println(line.length + " " + line)
    }
}
else
    Console.err.println("Please enter filename")


// 先頭に行数と|をつけて表示し、行数の書式を揃えたい
// そのためには、各行を二回処理しなくちゃいけない（文字数カウントして最大を見つける、そして表示）
// だから全行を変数に代入するお！（普通はやっちゃだめ）

// 文字数の長さを求める関数（各行の文字数を、文字で表したときの長さ……分かりづらい）
def widthOfLength(s: String) = s.length.toString.length
// 表示
if( args.length > 0 ) {
    // 全行読み込み
    val lines = Source.fromFile(args(0)).getLines.toList
    // 最長の長さを探す
    var maxWidth = 0
    for (line <- lines) {
        maxWidth = maxWidth.max(widthOfLength(line))
    }
    for (line <- lines) {
        val numSpace = maxWidth - widthOfLength(line)
        val padding = " " * numSpace
        println(padding + line.length + " | " + line)
    }
}
else
    Console.err.println("Please enter filename")

// 関数的なスタイルで書こう
if( args.length > 0 ) {
    val lines = Source.fromFile(args(0)).getLines.toList
    // reduceLeftメソッドは、渡された関数を先頭2つの要素に適用し、その結果と次の要素に対して順次処理を行う
    val longestLine = lines.reduceLeft(
        // 2つの行を比べて、長い方を残し、各要素を順次比較していく
        (a, b) => if (a.length > b.length) a else b
    )
    val maxWidth = widthOfLength(longestLine)
    for (line <- lines) {
        val numSpace = maxWidth - widthOfLength(line)
        val padding = " " * numSpace
        println(padding + line.length + " | " + line)
    }
}
else
    Console.err.println("Please enter filename")
