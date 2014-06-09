// 有理数を表現するクラス
// Scalaでは、Javaと違いコンストラクタに引数を渡すのではなく、クラスの基本コンストラクタが自動で定義され、クラスそのものに引数を渡す
class Rational(n: Int, d: Int) {
    // 有理数は、分母に0をとってはいけないので、インスタンス化の前に引数の有効性をチェックする
    // 有効でない引数が渡されると、IllegalArgumentExceptionがスローされる
    require(d != 0)

    // メンバの宣言
    private val g = gcd(n.abs, d.abs) // メンバは、宣言された順番に処理される。そのため、先に最大公約数gを初期化し、残りのnumerとdenomの処理が行われる
    // メンバに名前をつけることで、getterが自動生成される
    val numer: Int = n / g
    val denom: Int = d / g

    // 補助コンストラクタ
    // Scalaでは、コンストラクタは必ずクラスの基本コンストラクタを通過しなくてはいけない
    // そのため、補助コンストラクタは、基本コンストラクタを呼び出すための窓口である(基本コンストラクタはthisで表現される)
    def this(n: Int) = this(n, 1)

    // メソッドのオーバーライド
    override def toString = n + "/" + d

    // 加算メソッド(整数の加算のように扱えるようにするため、メソッド名は+で、引数をひとつ取るメソッドを定義する)
    def + (that: Rational): Rational =
        new Rational(
            numer * that.denom + that.numer * denom,
            denom * that.denom
        )

    // メソッドの多重定義。コンパイラにより、より適正な引数のメソッドが採用される
    def + (i: Int): Rational =
        new Rational(numer + i * denom, denom)

    // 積算メソッド(加算メソッドと同様、演算子のように振る舞わせる)
    // 尚、演算子の優先度は守られるため、整数の計算のように、任意の順番で加算と積算を混ぜても、正しく順序が解決される
    def * (that: Rational): Rational =
        new Rational(numer * that.numer, denom * that.denom)

    // 積算メソッドの多重定義
    def * (i: Int): Rational =
        new Rational(numer * i, denom)

    // 減算メソッド
    def - (that: Rational): Rational =
        new Rational(
            numer * that.denom - that.numer * denom,
            denom * that.denom
        )
    // 減算メソッドの多重定義
    def - (i: Int): Rational =
        new Rational(numer - i * denom, denom)

    // 除算メソッド
    def / (that: Rational): Rational =
        new Rational(numer * that.denom, denom * that.numer)
    // 除算メソッドの多重定義
    def / (i: Int): Rational =
        new Rational(numer, denom * i)

    // 比較メソッド　内部で自己参照(this)を使用している
    def lessThan(that: Rational) = 
        this.numer * that.denom < that.numer * this.denom

    // 2つの有理数を比較し、大きな方を返す
    def max(that: Rational) =
        if (lessThan(that)) that else this

    // ユークリッドの互除法により、最大公約数を見つけるメソッド
    private def gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
}

val a = new Rational(2,4)
println(a) // 2/4

val b = new Rational(1,3)
println(b) // 1/3

val c = a + b
println(c) // 5/6

val d = new Rational(2)
val e = c -d 
println(e) // -7/6 このへんのマイナスの値になってくると変だけど、写経だからとりあえず気にしない

val f = a * e
println(f) // -7/12 これとか意味不明だけど気にしない

val g = f / e
println(g) // -42/-84 以下略

val h = c max a
println(h) // 5/6
