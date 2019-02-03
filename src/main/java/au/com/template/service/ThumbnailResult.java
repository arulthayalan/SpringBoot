package au.com.template.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ThumbnailResult {

    private ThumbnailRequest request;

    private String url;

    public ThumbnailResult(ThumbnailRequest request, String url) {
        this.request = request;
        this.url = url;
    }

    public ThumbnailRequest getRequest() {
        return request;
    }

    public void setRequest(ThumbnailRequest request) {
        this.request = request;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public  String toJSON()
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
