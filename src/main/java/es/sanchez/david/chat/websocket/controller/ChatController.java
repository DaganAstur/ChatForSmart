package es.sanchez.david.chat.websocket.controller;

import es.sanchez.david.chat.websocket.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * Receives the messages and sends them to the proper queue. All are denominated rooms, for both users or actual rooms.
     * Depending on the type, we create a different room followed by the user or room identifier.
     * @param msg
     * @throws Exception
     */
    @MessageMapping("/room")
    public void sendSpecific(
            @Payload ChatMessage msg
    ) throws Exception {

        // TODO ADD MESSAGE TO THE DATABASE


        simpMessagingTemplate.convertAndSendToUser(
                msg.getDestinationId(), "/queue/messages", msg);
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload final ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/public")
    public ChatMessage newUser(@Payload final ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
