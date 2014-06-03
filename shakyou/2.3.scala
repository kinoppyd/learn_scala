// 関数定義の基本形
/*
def 関数名（引数:引数の型 ... ): 戻り値の型 = {
    // ほげほげ
}
*/
def max(x: Int, y: Int): Int = {
    if (x > y) x
    else y
}

println(max(3,2))
println(max(4,4))
println(max(5,8))


// 関数が一行で終わる場合、中括弧を省略できる
// 関数の戻り値の型は、推論されるので省略できる
// ただし、再帰呼び出しがある場合は、コンパイラが戻り値の型を要求する
def max2(x: Int, y:Int) = if(x > y) x else y

println(max2(3,2))
println(max2(4,4))
println(max2(5,8))


// 引数をとらず、有効な値も返さない関数も定義できる
def greet() = println("hello world")
greet()

// greet関数は、厳密に書くとUnit型の戻り値を返す。これは、Javaにおけるvoidに似ている
// 戻り値がUnitである関数は、副作用を持つ関数として考えられる
def greet2(): Unit = {
    println("hello world")
}
greet2()
