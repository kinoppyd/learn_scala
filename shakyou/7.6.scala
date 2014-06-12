// Scalaには、breakとcontinueが存在しない（！）
// 関数リテラルと非常に相性の悪い構文なので、Scalaでは排除している

// breakやcontinueを使わないループ(悪い例)
var i = 0
var foundIt = false
while (i < args.length && !foundIt) {
    if (!args(i).startsWith("-")) {
        if (args(i).endsWith(".scala"))
            foundIt = true
    }
    i = i + 1
}

// varを使わない再帰ループ(ただ、Scalaコンパイラは、このたぐいのループをwhileに最適化するらしいので、厳密には再帰しない)
def searchFrom(i: Int): Int =
    if (i >= args.length) - 1
    else if (args(i).startsWith("-")) searchFrom(i + 1)
    else if (args(i).endsWith(".scala")) i
    else searchFrom(i + 1)
val j = searchFrom(0)
println(j)

// どうしても命令形的にbreakが必要だと感じた場合、標準ライブラリを使用する
import scala.util.control.Breaks._
import java.io._

val in = new BufferedReader(new InputStreamReader(System.in))

breakable {
    while (true) {
        println("? ")
        if (in.readLine() == "") break
    }
}
