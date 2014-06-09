// Scalaでは、クラスがstatic なメンバを持つことはできない（！）
// その代わりに、Singleton objectsというものを持っている
// Singleton objectsは、classキーワードの代わりにobjectキーワードを使う

// 4.1.scalaの、ChecksumAccumulatorクラスのコンパニオンオブジェクト
import scala.collection.mutable.Map
object ChecksumAccumulator {
    private val cache = Map[ String, Int ]()
    def calculate(s: String): Int = {
        if (cache.contains(s))
            cache(s)
        else {
            val acc = new ChecksumAccumulator
            for(c <- s)
                acc.add(c.toByte)
            val cs = acc.checksum()
            cache += (s -> cs)
            cs
        }
    }
}

/*
    あるクラスと同じ名前を持つシングルトンオブジェクトがあるとき、シングルトンオブジェクトはそのクラスのコンパニオンオブジェクト(companion objects)と呼ばれる
    クラスとコンパニオンオブジェクトは、『同じソースファイルで定義しなくてはいけない』
    そのクラスは、シングルトンオブジェクトのコンパニオンクラス(companion classes)と呼ばれる
    クラスとそのコンパニオンオブジェクトは、互いの非公開メンバにアクセス出来る（！）
*/

// ChecksumAccumulatorのコンパニオンクラス
class ChecksumAccumulator {
    private var sum = 0
    def add(b: Byte) { sum += b }
    def checksum(): Int = ~(sum&0xFF)+1
}

println( ChecksumAccumulator.calculate("Every value is an object.") )
println( ChecksumAccumulator.calculate("hoge") )
println( ChecksumAccumulator.calculate("Every value is an object.") )
