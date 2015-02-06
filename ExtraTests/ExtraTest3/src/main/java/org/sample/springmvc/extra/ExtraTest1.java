package org.sample.springmvc.extra;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExtraTest1 {
    @Autowired
    ServletContext context;
    
    @RequestMapping(value="/download")
    public void execute(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment; filename="
                + "fileABC.txt");
        String path = context.getRealPath("/WEB-INF/download.txt");
        Path src = Paths.get(path);
        Files.copy(src, response.getOutputStream());
    }
}
