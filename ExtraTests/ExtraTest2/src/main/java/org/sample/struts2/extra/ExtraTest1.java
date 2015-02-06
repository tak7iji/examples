package org.sample.struts2.extra;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class ExtraTest1 extends ActionSupport implements ServletContextAware {

    private ServletContext servletContext;
    private InputStream fileInputStream;

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public String execute() throws Exception {
        String path = servletContext.getRealPath("/WEB-INF/download.txt");
        setFileInputStream(Files.newInputStream(Paths.get(path)));

        return "success";
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}