package hello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/hello")
    public Map<String, Object> hello() {
        HashMap<String, Object> body = new HashMap<>();
        body.put("message", "hello ppap.");
        return body;
    }

}