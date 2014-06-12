// match式は、多言語のswitchの様に動作する
/*
    javaのswitchとの違い
    1. デフォルトの条件は、_（アンダースコア）
    2. テストするものは、どんなオブジェクトでも構わない
    3. 個々の選択肢の最後にbreakを必要としない
    4. 式が値を生成する
*/

// 副作用のあるmatch式
val firstArg = if (args.length > 0) args(0) else ""
firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
}

// 結果値を生成する、副作用の無いmatch式
val friend =
    firstArg match {
        case "salt" => "pepper"
        case "chips" => "salsa"
        case "eggs" => "bacon"
        case _ => "huh?"
    }
println(friend)
