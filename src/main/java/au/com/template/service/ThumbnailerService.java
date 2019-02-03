package au.com.template.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.io.IOException;

@Service
public class ThumbnailerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThumbnailerService.class);

    @Autowired
    private ThumbnailCreatorComponent thumbnailCreator;

    @Autowired
    private NotificationComponent notification;

    @Autowired
    private SnsNotificationSender snsNotificationSender;

    @JmsListener(destination = "thumbnail_requests")
    public void createThumbnail(String requestJSON) throws JMSException {
        LOGGER.info("Received ");
        try {
            ThumbnailRequest request = ThumbnailRequest.fromJSON(requestJSON);
            String thumbnailUrl =
                    thumbnailCreator.createThumbnail(request.getImageUrl());
            //notification.thumbnailComplete(new ThumbnailResult(request, thumbnailUrl));
            snsNotificationSender.send( "sns message", new ThumbnailResult(request, thumbnailUrl).toJSON());
        } catch (IOException ex) {
            LOGGER.error("Encountered error while parsing message.", ex);
            throw new JMSException("Encountered error while parsing message.");
        }
    }
}
