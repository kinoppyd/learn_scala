// 集合とマップには、mutableとimmutableの2つのトレイトが用意されている
import scala.collection.mutable.Set
import scala.collection.immutable.Set // これはデフォルトでロードされているっぽいので、本来必要ない気がする
import scala.collection.mutable.Map
import scala.collection.immutable.Map // これはデフォルトでロードされているっぽいので、本来必要ない気がする

// immutableな集合（2つのSetを1つのスクリプト内で同居させるために、フル名で書いたけど普段こんな事はしないはず
var jetSet = scala.collection.immutable.Set("Boeing", "Airbus")
// このSetはimmutableなので、要素を追加するために変数そのものはmutableである
jetSet += "Lear"
println(jetSet.contains("Cessna"))

// mutableな集合
val movieSet = scala.collection.mutable.Set("Hitch", "Poltergeist")
// このSetはmutableなので、直接要素を追加できる
movieSet += "Shark"
println(movieSet)


// mutableなMap
val treasureMap = scala.collection.mutable.Map[Int, String]()
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println( treasureMap(2) )
/*
 (1 -> "Go to island.") は、(1).->("Go to island.")の省略表記である。2章でやった。
 -> メソッドは、全てのオブジェクトが持っているメソッドで、キーと値を格納する2要素のタプルを返す
 そして、Mapオブジェクトの+=メソッドにこのタプルを渡すことで、Mapにキーと値を登録できる
*/

// immutableなMap
val romanNumeral = scala.collection.immutable.Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)
// これはエラー
// romanNumeral += (6 -> "VI")
println(romanNumeral(4))
