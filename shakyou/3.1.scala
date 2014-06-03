// 新しいオブジェクトの作成と、引数を使ったパラメータ化
// ()内に引数を書くことで、オブジェクトを値でパラメータ化する
val bigint = new java.math.BigInteger("12345")
println(bigint)

// []内に型を指定することで、オブジェクトを型でパラメータ化する
val greetStrings = new Array[String](3)
// これは、String型の長さが3の配列を宣言している。また、型推論が働いているため、きちんと書くと次の形になる
val greetStrings2: Array[String] = new Array[String](3)

// 配列の各要素に、値を代入していく
// このとき、greetStrings自体はimmutableのため変更できないが、greetStringsの各要素は
// mutableのため、変更が可能であるということがわかる
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "World!\n"
// 次のコードは、配列の長さを超えるのでエラーになる
// greetStrings(3) = "Can't!"

// 配列の中身を全て表示する
for( i <- 0 to 2 )
    print(greetStrings(i))
// ここで、一行目のtoは、Intを引数にとるメソッドである
// 実際には(0).to(2)という呼び出しに置き換えられている
// Scalaでは、メソッドの引数が1つの場合は、括弧やドットを省略することができる（ただし、レシーバーが明示である必要がある）

/*
Scalaでは、全ての演算がメソッドの呼び出しである（Rubyと同じだね）
1 + 2 は、(1).+(2)と同義であり、1の+メソッドの引数に2を渡している形になる

また、Scalaの原則ルールとして、オブジェクトインスタンスに直接()でアクセスしたとき、それはapplyメソッドの呼び出しに置き換えられる
すなわち、配列に
greetStrings(1)
の様にアクセスすることは、
greetStrings.apply(1)
と同じ事である
同様に、括弧で囲まれた1個以上の引数を伴う変数への代入は、updateメソッドの呼び出しと同義である
greetStrings(1) = "hello"
は
greetStrings.update(1, "hello")
に変換さえる
*/

// 以上のルールを踏まえた上で、配列への代入と表示は、次のように書き換えられる
val greetStrings3 = new Array[String](3)
greetStrings3.update(0, "Hello")
greetStrings3.update(1, ", ")
greetStrings3.update(2, "World!\n")
for( i <- (0).to(2) )
    print( greetStrings3.apply(i) )


// また、配列の初期化は、次のように宣言することも出来る（普通はこっちを使う方が楽）
val numbers = Array("zero", "one", "two")
for( i <- 0 to 2 )
    println(numbers(i))
// この初期化が実際に行っていることは、Array.applyという名前の、新しい配列を作って返すファクトリメソッドの呼び出しである
// このArray.applyメソッドは、Arrayコンパニオンオブジェクト(companion object)で定義されており、可変長の引数をとる
// コンパニオンオブジェクトは、8.8項で解説される
val numbers2: Array[String] = Array.apply("zero", "one", "two")
for( i <- (0).to(2) )
    println(numbers.apply(i))
