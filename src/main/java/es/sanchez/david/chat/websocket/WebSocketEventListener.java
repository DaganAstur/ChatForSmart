package es.sanchez.david.chat.websocket.controller;

import es.sanchez.david.chat.websocket.model.ChatMessage;
import es.sanchez.david.chat.websocket.model.MessageType;
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
        LOGGER.info("Connected");
    }

    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectEvent event) {
        LOGGER.info("Connect");
    }

    @EventListener
    public void handleWebSocketConnectListener(final SessionSubscribeEvent event) {
        LOGGER.info("Subscribe");
    }


    @EventListener
    public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event) {
        final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        final String userName = (String) headerAccessor.getSessionAttributes().get("username");
        final ChatMessage chatMessage = new ChatMessage(MessageType.DISCONNECT, "Disconnected", userName, null);

        sendingOperations.convertAndSend("/topic/public", chatMessage);

    }


}
