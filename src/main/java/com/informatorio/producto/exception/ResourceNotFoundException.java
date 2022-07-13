package com.informatorio.producto.exception;

import org.springframework.web.util.NestedServletException;

public class ResourceNotFoundException extends NestedServletException {
    public ResourceNotFoundException(String messagge){
        super(messagge);
    }
}
