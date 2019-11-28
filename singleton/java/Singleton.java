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

