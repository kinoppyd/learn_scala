// Scalaの変数スコープはJavaとあんまり変わらないが、シャドウイングという点がユニークである
def printMultiTable() {
    var i = 1
    // ここではiだけがスコープに入っている
    while (i <= 10) {
        var j = 1
        // ここでは、iとjがスコープに入っている
        while (j <= 10) {
            var prod = (i * j).toString
            // ここでは、i,j,prodがスコープに入っている
            var k = prod.length
            // ここでは、i,j,prod,kがスコープに入っている
            while (k < 4) {
                print(" ")
                k += 1
            }
            print(prod)
            j += 1
        }
        // iとjはまだスコープに入っている。prodとkはスコープから外れている
        println()
        i += 1
    }
    // iはまだスコープに入っている。j,prod,kはスコープから外れている
}
printMultiTable()
/*
    Scalaでは、外側のスコープにある変数名と同様の変数名を内側のスコープで宣言すると、外側の変数を内側の変数で隠す、シャドウイングが行われる
    Javaでは認められていない機能なので、ここが大きく異る
*/
// Shadowingの例
val a = 1; // このセミコロンは、特に意味ないスコープを作るための中括弧に必要なだけなので、気にしない
{
    val a = 2
    println(a) // 2が出力
}
println(a) // 1が出力


/*
    命令型スタイルのコードリファクタリング
    上の九九を出力する関数は、多くの副作用を含む。これを、副作用を含まない関数型のスタイルにリファクタリングする
    関数型で書くメリットは、単体テストの行いやすさである
    副作用を持つ関数は、テストするためにprintやprintlnに介入する必要があるが、副作用がなければ、出力を比較するだけで済む
*/
// 1段分をシーケンスとして返す
def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
        val prod = (row * col).toString
        val padding = " " * (4 - prod.length)
        padding + prod
    }
// 1段分を文字列として返す
def makeRow(row: Int) = makeRowSeq(row).mkString
// 1行に1段分の文字列を収めた表を返す
def multiTable() = {
    val tableSeq = // 格段の文字列のシーケンス
        for (row <- 1 to 10)
            yield makeRow(row)
    tableSeq.mkString("\n")
}
println(multiTable())
