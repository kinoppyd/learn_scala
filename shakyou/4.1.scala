/*
    クラスの宣言
*/
class ChecksumAccumulator {
    /*
        Scalaでは、アクセス修飾子を省略するとpublicとして扱われる
    */
    private var sum =0

    /*
        メソッド引数は、valで定義される。型推論がやりやすいため。
        毎回必ずvalなので、宣言する必要はない。
    */
    def add(b: Byte): Unit = {
        sum += b

        // 次のコードは通らない
        // b = 1
    }

    /*
        戻り値がUnitのメソッドには副作用があり、一般にはメソッド外にある状態の変更や、入出力のアクション
        このような場合、結果型と統合を省略し、メソッド本体を中括弧で囲むという表現方法があり、副作用を持つメソッドをわかりやすくする
        注意：関数本体前の等号を省略すると、結果型がUnitになる！
    */
    def add2(b: Byte) { sum += b }

    /*
        Scalaでは、最後に評価された式が関数・メソッドの戻り値となる（推奨された書き方、LLっぽい）
        また、1ステートメントのメソッドは、次のように省略できる
    */
    def checksum(): Int = ~(sum & 0xFF) + 1
}

val acc = new ChecksumAccumulator
acc.add(1)
println(acc.checksum())
acc.add2(8)
println(acc.checksum())
