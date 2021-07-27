package org.fuyi.coreapi.client;

import org.fuyi.coreapi.dto.TestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "core")
public interface TestClient {
    @RequestMapping(value = "/core/test/{userName}", method = RequestMethod.GET, consumes = "application/json")
    TestResponse test(@PathVariable(value = "userName") String userName);
}
