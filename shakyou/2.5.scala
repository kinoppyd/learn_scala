var i = 0
while( i < args.length ){
    if(i!=0)
        print(" ") // ブロックが1行だけなら、中括弧を省略できる
    print(args(i))
    i += 1 // Scalaでは、i++や++iの様なインクリメント、デクリメントが使えない
}
println()


// 今更だけど、Saclaは文末のセミコロンを省略できる（Rubyといっしょ）
// 上のブロックを細かく書くと、こうなる
var j = 0;
while( j < args.length ){
    if(j!=0){
        print(" ");
    }
    print(args(j));
    j += 1;
}
println();
