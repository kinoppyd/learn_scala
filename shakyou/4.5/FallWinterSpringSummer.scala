// scala.Applicationという、コード量を減らすための便利トレイト
// テキストではscala.Applicationだが、v2.9からはscala.Appになったらしい

import ChecksumAccumulator.calculate

// 継承すると、mainを省略できる（細かい解説がめんどかったので、ここではこれだけ理解しとく）
object FallWinterSpringSummer extends App {
    for(season <- List("fall", "winter", "spring"))
        println(season + ": " + calculate(season))
}
