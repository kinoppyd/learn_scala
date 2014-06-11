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

// forは式であり、意味のある値を返す。その値は、for式の<-節で型が決まるコレクションである
// 複数のフィルタを使うには、フィルタを羅列する
for (
     file <- filesHere
     if file.isFile
     if file.getName.endsWith(".scala")
) println(file)

// 複数の<-節を追加すると、ループを入れ子にできる
def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList // ファイルを読み込む関数
def grep(pattern: String) =
    for (
         file <- filesHere
         if file.getName.endsWith(".scala"); // 多重のループの区別のためにセミコロンが必要。ジェネレータとフィルタを中括弧で囲むことで省略可(次のコードを参照)
         line <- fileLines(file)
         if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)
grep(".*gcd.*")

// 一つ前のコードでは、line.trimという式を繰り返している。ループの中で無視できるコストでは無いので、この処理を一回に減らす。
// for式の中で、=を使って新しい変数に結果地を束縛(bind)することができる（スコープはfor式の中だけでありvalである）
def grep2(pattern: String) =
    for {
        file <- filesHere
        if file.getName.endsWith(".scala")
        line <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(pattern)
    } println(file + ": " + trimmed)
grep2(".*gcd.*")

// for式の実行結果から、新しいコレクションを作り出す
// whileループと違い、for式は値を返すことができる.コレクションの型は推論される（この場合はArray[File])
def scalaFiles =
    for {
        file <- filesHere
        if file.getName.endsWith(".scala")
    } yield {file}
for( file <- scalaFiles ) println(file.getName) // scalaFilesで作成されたコレクションを出力

/*
    for yield構文は、yieldをfor式の処理ブロックの前に置かなくてはいけない。なので、次の書き方はエラーになる
    for (file <- filesHere if file.getName.endsWith(".scala") ){
        yield file // ブロックの中括弧の前に書かなくてはいけないので、エラー！
    }
    これはOK
    for (file <- filesHere if file.getName.endsWith(".scala") ) yield {
        file
    }
*/

// カレントディレクトリの全ファイルを格納したfilesHereから、各ファイルの「for」という文字列を含んでいる行の長さの配列に変換する
val forLineLengthes = 
    for {
        file <- filesHere
        if file.getName.endsWith(".scala")
        line <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(".*for.*")
    } yield trimmed.length
for ( length <- forLineLengthes ) println(length)
