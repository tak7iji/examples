package org.sample;

import java.util.List;
import java.util.Map;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.HandshakeResponse;

import org.apache.log4j.Logger;

public class EndpointConfig extends ClientEndpointConfig.Configurator {
    private Logger logger = Logger.getLogger(EndpointConfig.class);
    
    @Override
    public void afterResponse(HandshakeResponse hr) {
        Map<String, List<String>> headers = hr.getHeaders();
        for(String value: headers.get("Set-Cookie")) {
            logger.info("Set-Cookie -> "+value);
        }
    }
}
