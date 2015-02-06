package org.sample.struts1.extra;

import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

public class ExtraTest1 extends DownloadAction {

    @Override
    protected int getBufferSize() {
        return 1024;
    }
    
    @Override
    protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String path = servlet.getServletContext().getRealPath("/WEB-INF/download.txt");
        StreamInfo streamInfo = new FileStreamInfo("application/octet-stream", Paths.get(path).toFile());
        response.setHeader("Content-disposition", "attachment; filename="
                + "fileABC.txt");
        return streamInfo;
    }
}
