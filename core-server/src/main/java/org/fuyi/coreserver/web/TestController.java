package org.fuyi.coreserver.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/core/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private HttpServletRequest request;

    @Value("${water-walker.core.bash.workspace-prefix}")
    private String workspacePrefix;

    @Autowired
    public TestController(HttpServletRequest request){
        this.request = request;
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public String getUser(@PathVariable("userName") String userName){
        logger.info("Get user by userName from port : {} of userservice instance", request.getServerPort());
        return "FuYi" + "-" + workspacePrefix;
    }
}
