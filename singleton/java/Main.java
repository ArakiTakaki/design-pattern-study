class Main {
  public static void main(String[] args) {
    var singletonInstance = Singleton.getInstance();

    singletonInstance.addMember("やな");
    singletonInstance.addMember("のざわ");

    var member = singletonInstance.getMember();
    System.out.println(member.get(0));
    System.out.println(member.get(1));
    System.out.println("call at hoge");

    Main.hoge();
  }

  public static void hoge() {
    var singletonInstance = Singleton.getInstance();
    var member = singletonInstance.getMember();
    System.out.println(member.get(0));
    System.out.println(member.get(1));
  }
}


//
// // 推奨されている方法
// public class Singleton {
//   private static Singleton() getInstance{
//     return SingletonHolder.INSTANCE;
//   }
// 
//   private static class SingletonHolder {
//     private static final Singleton INSTANCE = new Singleton();
//   }
// }
