package com.createarttechnology.agent.controller;

import com.createarttechnology.logger.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lixuhui on 2019/1/28.
 */
@Controller
public class ReadController {

    private static final Logger logger = Logger.getLogger(ReadController.class);

    @RequestMapping
    @ResponseBody
    public String index() {

        return "test agent";
    }

}
