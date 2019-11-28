# シングルトンパターン

　アーキテクチャを考える上で確実に通る道シングルトンパターン

## シングルトンパターン is 何

- クラス内で保持できるインスタンスが1つ
    - 2個できた時点でそれはシングルトンではない

要はストアみたいなものです。

オンメモリで管理できるので、色々ごにょごにょいじればキャッシュとしても使えます。

## なぜ必要なのか

- 状態を保持したい
- 一つのインスタンスを使いまわしたい

## どういう物で使用されているか

- サーバのセッション
    - [Spring BeanはSingletonだから、状態持たせるとバグるよ。](https://permanent-til-me.ssl-netowl.jp/archives/613)
- TomcatなどのApplicationContext
- Vue
  - Vuexのようなストア機構


### Javaのサンプルケース

```java
import java.util.ArrayList;
import java.util.List;

class Singleton {
  // 1. インスタンスを格納する部分
  private static Singleton instance = null;

  // 2. newを宣言できないようにする。
  private Singleton() {}

  private List<String> members = new ArrayList<String>();

  public static Singleton getInstance() {
    if (instance == null) {
      Singleton.instance = new Singleton();
    }
    return Singleton.instance;
  }

  public void addMember(String memberName) {
    this.members.add(memberName);
  }

  public List<String> getMember() {
    return this.members;
  }
}

```

### TypeScriptのサンプルケース

```typescript
class Singleton {
  private members: Array<string> = [];

  public addMember(member: string) {
    this.members.push(member);
  }

  public getMembers(): Array<string> {
    return this.members;
  }
}

export default new Singleton();

```

## 注意

　Facade並に最も代表的なパターンかつ、__極力使用してはならない__。
やっていることは__グローバル宣言__となんら変わりないので、使用すればするほど__ソースの見通しが悪くなり__なおかつ__テストが困難__になっていく。
ただ、サーバーにおけるSessionや、ライブラリへの依存注入する際に似たような作りになっている。

DIコンテナを使用すれば上記の問題は解決できることもある(ちなみにDIコンテナにもアンチパターンがめちゃくちゃ存在している)
- [DIコンテナの本当の使いどころ](https://www.ulsystems.co.jp/topics/025)

