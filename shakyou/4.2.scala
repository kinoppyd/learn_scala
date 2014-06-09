// Scalaでは、文末のセミコロンは省略できるが、1行に複数のステートメントを書きたいときには必要となる
val s = "hello"; println(s)

val x = 10
// 複数行にまたがるコードでも、Scalaはほとんどの場合で正しく解釈する
if (x < 2)
    println("too small")
else
    println("ok!")

// しかし、次のようなケースでは、プログラマの意思に反して文が分割されてしまう
// x; + y; として解釈される
x
+ y

// 次のように書くと、x + y; として解釈される
(x
+ y)
// もしくは、演算子を行末に揃えて
x +
y

// そのため、+のような中置演算子を連続的に使いたい場合は、演算子を行頭ではなく行末に揃えて書くのがScalaのスタイルである

/*
    セミコロン推測の規則
    1．該当行の末尾が、ピリオドや中遅延残滓など、文の末尾として文法的に認められない単語になっている
    2．次の行が文の行として認められていない単語になっている
    3．括弧(...)や角括弧[...]の中に居る状態で文末になっている。元々こうした括弧の中に複数の文を入れることは出来ない
*/