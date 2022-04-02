package es.sanchez.david.chat.controller;

import es.sanchez.david.chat.model.ChatMessage;
import es.sanchez.david.chat.model.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;


@Component
public class WebSocketEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);

    private SimpMessageSendingOperations sendingOperations;

    @Autowired
    public WebSocketEventListener(SimpMessageSendingOperations sendingOperations) {
        this.sendingOperations = sendingOperations;
    }

    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
        LOGGER.info("Bing bong bing. Connected");
    }

    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectEvent event) {
        LOGGER.info("Bing bong bing. Connect");
    }

    @EventListener
    public void handleWebSocketConnectListener(final SessionSubscribeEvent event) {
        LOGGER.info("Bing bong bing. Subscribe");
    }



    @EventListener
    public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event){
        final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        final String userName = (String) headerAccessor.getSessionAttributes().get("username");
        final ChatMessage chatMessage =new ChatMessage(MessageType.DISCONNECT, null, userName, null);

        sendingOperations.convertAndSend("/topic/public", chatMessage);

    }


}
