package com.informatorio.producto.exception;

import java.io.IOException;

public class ResourceNotFoundException extends IOException {
    public ResourceNotFoundException(String messagge){
        super(messagge);
    }
}
