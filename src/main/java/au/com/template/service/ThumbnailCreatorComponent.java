package au.com.template.service;


import org.springframework.stereotype.Component;

@Component
public class ThumbnailCreatorComponent {

    public String createThumbnail(String url) {
        return "blah:" + url;
    }
}
