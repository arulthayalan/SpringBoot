package au.com.template.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ThumbnailRequest {

    String objectId;
    String imageUrl;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static ThumbnailRequest fromJSON(String json)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ThumbnailRequest.class);
    }
}
