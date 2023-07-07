package com.acmepetsupplies.productcatalog;


import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.util.BufferUtil;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.UUID;

@Component
public class JettyCustomizer implements WebServerFactoryCustomizer<JettyServletWebServerFactory> {

    @Override
    public void customize(JettyServletWebServerFactory factory) {

        factory.addServerCustomizers((server) -> {
            ErrorHandler errorHandler = new CustomJettyErrorHandler();
            server.setErrorHandler(errorHandler);
        });
    }
}

class CustomJettyErrorHandler extends ErrorHandler {

    @Override
    public ByteBuffer badMessageError(int status, String reason, HttpFields fields) {
        if (reason == null) {
            reason = HttpStatus.getMessage(status);
        }
        fields.put(HttpHeader.CONTENT_TYPE, MimeTypes.Type.APPLICATION_JSON.asString());
        String messageStructure = """
                {"id": "%s", "status": 400, "code":"validation.client_error", "title": "Bad Request","detail": "%s"}""";
        String message = String.format(messageStructure,UUID.randomUUID(),  reason);
        return BufferUtil.toBuffer(message);
    }
}

