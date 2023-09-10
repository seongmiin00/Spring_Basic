package hello.core.singleton;

public class SingletonService {

    //static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    //public으로 열어서 객체 인스턴스가 필요하면 이 static 메소드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private로 선언하여 외부에서 new 키워드를 통해 객체를 생성하는것을 막는다.
    private SingletonService(){
    };

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
