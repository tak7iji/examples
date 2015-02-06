package org.sample.springmvc.extra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class SimpleTest {
    @Autowired
    ServletContext context;

    @RequestMapping(method = RequestMethod.GET)
    public void login(Model model) {
        model.addAttribute("viewordownload", new ViewOrDownload());
    }

    @RequestMapping(method = RequestMethod.POST, params = "checked=view")
    public String view() {
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.POST, params = "checked=download1")
    public void download(HttpServletResponse response) throws IOException {
        System.out.println("Download1");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition",
                "attachment; filename=fileABC.txt");
        String path = context.getRealPath("/WEB-INF/download.txt");
        Path src = Paths.get(path);
        Files.copy(src, response.getOutputStream());
    }

    @RequestMapping(method = RequestMethod.POST, params = "checked=download2")
    public ResponseEntity<String> download2() throws IOException {
        System.out.println("Download2");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "octet-stream"));
        headers.set("Content-Disposition", "attachment; filename=fileABC.txt");
        String path = context.getRealPath("/WEB-INF/download.txt");
        Path src = Paths.get(path);
        String data;
        try (Stream<String> stream = Files.lines(src)) {
            data = stream.collect(Collectors.joining("\n"));
        }
        return new ResponseEntity<String>(data, headers, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Object downloadOrView(@ModelAttribute("checked") String checked) throws IOException {
        if("view2".equals(checked)) {
            return "welcome";
        }

        System.out.println("Download3");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "octet-stream"));
        headers.set("Content-Disposition", "attachment; filename=fileABC.txt");
        String path = context.getRealPath("/WEB-INF/download.txt");
        Path src = Paths.get(path);
        String data;
        try (Stream<String> stream = Files.lines(src)) {
            data = stream.collect(Collectors.joining("\n"));
        }
        return new ResponseEntity<String>(data, headers, HttpStatus.OK);
    }
}