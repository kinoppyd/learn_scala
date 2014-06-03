// immutable variable
val hello_string = "Hello world!"
println(hello_string)

// 次のステートメントは、コンパイルエラーになる
// hello_string = "Hello world 2!"

// 型推論による省略を伴わない変数定義
val hello_string2: java.lang.String = "Hello world 2!"
println(hello_string2)

// mutable valiable
var hello_string3 = "Hello world 3!"
println(hello_string3)
// mutableなので、再代入が可能
hello_string3 = "Hello World 3 !!"
println(hello_string3)
