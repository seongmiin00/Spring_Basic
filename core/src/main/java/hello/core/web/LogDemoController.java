package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;

    //스코프가 request로 되어있으면 HttpRequest의 요청이 올때 스프링 컨테이너에서 빈을 가져오게 되는데
    //여기서 autowired로 가져오고 있기 때문에 가져올 수 없어서 오류가 터짐
    private final MyLogger myLogger;

//    private final ObjectProvider<MyLogger> myLoggerProvider;


    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String requestUrl = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();//ObjectProvider의 lookup기능을 통해 해당 빈을 주입받게 됨
        myLogger.setRequestURL(requestUrl);//<- 이시점에 진짜 클래스를 찾아 주입하게됨
        myLogger.log("controller test");

        logDemoService.logic("testId");
        return "OK";
    }
}
