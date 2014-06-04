// 関数型のスタイルを見分ける
// Scalaは、命令型と関数型を扱えるが、関数型がより推奨されている

/* 見分け方1:コードにvarが含まれていたら命令型のスタイルで書かれており、valのみであれば関数型のスタイルで書かれている */
// これは、2章で出てきた、命令型のスタイル
def printArgs(args: Array[String]): Unit = {
    var i = 0
    while ( i < args.length ) {
        println(args(i))
        i += 1
    }
}
// varを取り除けば、より関数的なスタイルになる
def printArgs2(args: Array[String]): Unit = {
    for ( arg <- args ) {
        println(arg)
    }
}
// 次の様にも書ける
def printArgs3(args: Array[String]): Unit = {
    args.foreach(println)
}

/* 見かけ方2:副作用を探す(例えば結果型がUnitであれば、必ず副作用を持っている) */
// 関数の内部で副作用を作るのではなく、関数の呼び出し元にそれを任せる
// この場合、標準出力にprintするのではなく、printすべき文字列を作成して返す関数にする
// 副作用もvarもない関数
def formatArgs(args: Array[String]) = args.mkString("\n")

// 副作用の無い関数の呼び出し
println(formatArgs(args))

/*
 役に立つプログラムは、必ずどこかで副作用を持つ（画面への出力などが出来なければ、結果が確認できないので）
 ただし、作成する関数に極力副作用を持たせないことを意識して作成することで、結果的に副作用を持つコードを最小限に抑えられる
 このアプローチには、プログラムをテストしやすくなるというメリットがある
*/

// 例えば、printArgsはテストは難しい。printlnを再定義して、それが期待通りであるかをチェックしなくてはいけない
// しかし、formatArgsは、関数の戻り値をチェックするだけである
val res = formatArgs(Array("zero", "one", "two"))
assert(res == "zero\none\ntwo" )

/*
 Scalaプログラマに求められる、バランスのとれた態度
 テキストのp.74を参照
*/
