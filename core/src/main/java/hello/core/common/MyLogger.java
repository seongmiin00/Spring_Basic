package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;


@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//request요청을 받을때 빈이 자동으로 생성이 되고 요청을 처리했을때 자동으로 삭제됨
//위의 proxyMode 옵션을 사용하게 되면 MyLogger의 가짜 프록시 클래스를 생성하게 되고
//httpRequest에 상관없이 가짜 프록시 클래스를 다른 빈에 미리 주입해 둘 수 있음
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "] "+"[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] "+"request scope bean create: " + this);
    }

    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] "+"request scope bean close: " + this);
    }
}
