package es.sanchez.david.chat.websocket.controllers;

import es.sanchez.david.chat.core.service.message.MessageService;
import es.sanchez.david.chat.websocket.mappers.ChatMessageMapper;
import es.sanchez.david.chat.websocket.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class ChatController {
    private SimpMessagingTemplate simpMessagingTemplate;

    private MessageService messageService;
    private ChatMessageMapper chatMessageMapper;

    public ChatController(SimpMessagingTemplate simpMessagingTemplate, MessageService messageService, ChatMessageMapper chatMessageMapper) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.messageService = messageService;
        this.chatMessageMapper = chatMessageMapper;
    }

    /**
     * Receives the messages and sends them to the proper queue. All are denominated rooms, for both users or actual rooms.
     * Depending on the type, we create a different room followed by the user or room identifier.
     * @param msg
     * @throws Exception
     */
    @Transactional
    @MessageMapping("/room")
    public void sendSpecific(
            @Payload ChatMessage msg
    ) throws Exception {

        // TODO ADD MESSAGE TO THE DATABASE
        messageService.addMessage(chatMessageMapper.map(msg));
        simpMessagingTemplate.convertAndSendToUser(
                msg.getDestinationId(), String.format("/%s/queue/messages", msg.getDestinationType().name().toLowerCase()), msg);
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
