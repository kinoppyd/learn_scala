/*
    Scalaプログラムの実行には、mineメソッドを持つスタンドアロンシングルトンオブジェクトの名前を指定する必要がある。
    (standalone singleton object コンパニオンクラスと同じ名前を共有しないシングルトンオブジェクト)
    mainメソッドは、Array[String]をパラメータとする、Unit型を返すメソッド
*/
import ChecksumAccumulator.calculate

object Summer {
    def main(args: Array[String]) {
        for(arg <- args){
            println(arg + ": " + calculate(arg))
        }
    }
}

// コンパイル
// scalac Checksumaccumulator.scala Summer.scala
// 実行
// scala Summer of love
// 結果
// of: -213
// love: -182

/*
    scalacは毎回Javaの初期化等に時間がかかるため、初期化を済ませてコンパイルだけを行うfsc(fast scala compiler)というデーモンも存在する
    fscは、初回起動時にJavaの初期化を済ませるため、二回目以降のコンパイルはScalaファイルのコンパイルのみで完了する
    fsc Checksumaccumulator.scala Summer.scala
    終了は
    fsc -shutdown
*/
