package com.ramanprabhakar.goshopping.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Raman on 5/22/2016.
 */
public class ServerResponse implements Serializable {

    @SerializedName("responseHeader")
    ResponseHeader responseHeader;

    @SerializedName("response")
    Response response;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
