package net.megogo.api.model;

import lombok.Data;

@Data
public class ResponseContainer<T> {

    private String result;
    private T data;
}
