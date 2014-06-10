// 手続き的なifで、引数からファイル名を取得する
var filename = "default.txt"
if (!args.isEmpty)
    filename = args(0)

// Scalaの条件式による初期化のイディオム
val filename2 = // valになった
    if (!args.isEmpty) args(0) // Scalaのif文は、値を返す
    else "default.txt"

// whileループで、最大公約数を計算する
def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0){
        val temp = a
        a = b % a
        b = temp
    }
    b
}

// do-whileを使って標準入力を読み出す
var line = ""
do {
    // readLineで非推奨の警告が出るけど、とりあえず気にしない
    line = readLine()
    println("Read: " + line)
} while (line != "")

/*
    Scalaでは、CやJavaでよく見る次のイディオムが使えない
    var line = ""
    while ((line = readLine()) != "")
        println("Read: " + line)
    なぜなら、Scalaでは代入の結果地は常にUnit型であり、()である。だから、””には決してならない
    ifなどは意味のある値を返すために式と呼ばれるが、whileとdo-whileは意味のある値を返さないので、ループと呼ばれる
    whileループは意味のある値を返さないので、関数型言語では除かれていることが多い
*/

// for式でディレクトリ内のファイルリストを表示する
val filesHere = (new java.io.File(".")).listFiles // file <- filesHere という構文は、ジェネレータ呼ばれ、filesHereの各要素をvalのfileに入れて処理するときに使う
for (file <- filesHere)
    println(file)

// Rangeを使ったfor文
for (i <- 1 to 4)
    println("Iteration(to) " + i)
for (i <- 1 until 4)
    println("Iteration(until) " + i)

// 他の言語では見るけど、Scalaではあまり使わないイディオム
for (i <- 0 to filesHere.length - 1)
    println(filesHere(i))

// for文のフィルタリング
for (file <- filesHere if file.getName.endsWith(".scala")) // ifを使って、コレクションから利用する要素を選択する
    println(file)
// 次のコードも同様だが、これは命令形言語っぽい
for (file <- filesHere)
    if (file.getName.endsWith(".scala"))
        println(file)
// forは式であり、意味のある値を返す。その値は、for式の<-節で型が決まるコレクションである
// 複数のフィルタを使うには、フィルタを羅列する
for (
     file <- filesHere
     if file.isFile
     if file.getName.endsWith(".scala")
) println(file)
