// 例外処理は、他の言事よく似ているが、Scalaのthrowは結果型を持つ式になっている（！）
val n = 2
val half = 
    if (n % 2 == 0)
        n / 2
    else
        // nが偶数でない場合、この例外が投げられる。結果値を返すが、実際にはval halfを使用するコードには絶対到達しないので、安全である
        throw new RuntimeException("n must be even")

// 例外のキャッチは、catch節を使用する。パターンマッチとの統一性を保つように選ばれている
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

// Scalaでは、throws節の宣言が必須ではない。@throwsアノテーションを使用すれば、宣言できる
try {
    val f = new FileReader("input.txt")
    // ファイルを使ってからクローズする
} catch {
    // ファイルなしエラーを処理
    case ex: FileNotFoundException => println(ex)
    // その他のI/Oエラーを処理
    case ex: IOException => println(ex)
}

// filally節
val file = new FileReader("7.4.scala")
try {
    // ファイルを使う
} finally {
    file.close()
}

// try-catch-finallyは、結果値を生成する
// URLの解析を試みつつ、URLに構文エラーがあればデフォルト値を使う例
import java.net.URL
import java.net.MalformedURLException
def urlFor(path: String) =
    try {
        new URL(path)
    } catch {
        case e: MalformedURLException =>
            new URL("http://www.scala-lang.org")
    }

// Javaと違い、Scalaはtry-finallyが結果を返す
// finally句に明確なreturnやthrowが記されている場合、tyrやcatchでの戻り値がfinallyでの戻り値で上書きされるが、混乱のもとなのでfinally句は値を返さないほうが良い
// この場合、2が返る
def f(): Int = try{ return 1 } finally { return 2 }
println(f())
// この場合、1が返る(コンパイルするときに警告出るけど)
def g(): Int = try{ 1 } finally { 2 }
println(g())
