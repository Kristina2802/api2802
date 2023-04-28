package com.example.hw3.Controller;

import com.example.hw3.Requests.RequestV1;
import com.example.hw3.Requests.RequestV4;
import com.example.hw3.Requests.RequestV5;
import com.example.hw3.Resposnses.ResponseV1;
import com.example.hw3.Resposnses.ResponseV2;
import com.example.hw3.Resposnses.ResponseV3;
import com.example.hw3.Service.ResponseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    ResponseService responseService;

    @GetMapping("/v1")
    public ResponseV1 responseV1(@RequestBody RequestV1 request) {
        if (request == null) {
            request = new RequestV1("%");
        }
        if (request.likeString() == null) {
            request = new RequestV1("%");
        }
        return responseService.getResponseV1(request);
    }

    @GetMapping("/v2")
    public ResponseV2 responseV2(@RequestBody RequestV1 request) {
        if (request == null) {
            request = new RequestV1("%");
        }
        if (request.likeString() == null) {
            request = new RequestV1("%");
        }
        return responseService.getResponseV2(request);
    }

    @GetMapping("/v3")
    public ResponseV3 responseV3(@RequestBody RequestV1 request) {
        if (request == null) {
            request = new RequestV1("%");
        }
        if (request.likeString() == null) {
            request = new RequestV1("%");
        }
        return responseService.getResponseV3(request);
    }

    @GetMapping("/v4")
    public ResponseV3 responseV4(@RequestBody RequestV4 request) {
        if (request == null) {
            request = new RequestV4("%", null);
        }
        if (request.likeString() == null) {
            request = new RequestV4("%", null);
        }
        if (request.regexString() == null) {
            request = new RequestV4("%", responseService.likeToRegexp(request.likeString()));
        }
        return responseService.getResponseV4(request);
    }

    @GetMapping("/v5")
    public ResponseV3 responseV5(@RequestBody RequestV5 request) {
        if (request == null) {
            request = new RequestV5("%", null, null, null, null);
        }
        if (request.likeString() == null) {
            request = new RequestV5("%", null, null, null, null);
        }
        if (request.regexpString() == null) {
            request = new RequestV5("%", responseService.likeToRegexp(request.likeString()), null, null, null);
        }
        return responseService.getResponseV5(request);
    }
}
