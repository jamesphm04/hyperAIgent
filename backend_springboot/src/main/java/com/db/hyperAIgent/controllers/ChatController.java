package com.db.hyperAIgent.controllers;

import com.db.hyperAIgent.domain.dtos.ChatDto;
import com.db.hyperAIgent.domain.dtos.QAPairDto;
import com.db.hyperAIgent.domain.dtos.openai.ChatResponse;
import com.db.hyperAIgent.domain.entities.ChatEntity;
import com.db.hyperAIgent.domain.entities.QAPairEntity;
import com.db.hyperAIgent.domain.entities.UserEntity;
import com.db.hyperAIgent.mappers.Mapper;
import com.db.hyperAIgent.mappers.impl.openai.ResponseChatMapper;
import com.db.hyperAIgent.services.ChatService;
import com.db.hyperAIgent.services.OpenAIService;
import com.db.hyperAIgent.services.QAPairService;
import com.db.hyperAIgent.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ChatController {
    final private UserService userService;
    final private ChatService chatService;
    final private QAPairService qaPairService;
    final private OpenAIService openAIService;

    final private Mapper<ChatEntity, ChatDto> chatMapper;
    final private Mapper<QAPairEntity, QAPairDto> qaPairMapper;
    final private ResponseChatMapper responseChatMapper;

    public ChatController(ChatService chatService,
                          UserService userService,
                          QAPairService qaPairService,
                          OpenAIService openAIService,

                          Mapper<ChatEntity, ChatDto> chatMapper,
                          Mapper<QAPairEntity, QAPairDto> qaPairMapper,
                          ResponseChatMapper responseChatMapper) {
        this.chatService = chatService;
        this.userService = userService;
        this.qaPairService = qaPairService;
        this.openAIService = openAIService;

        this.chatMapper = chatMapper;
        this.qaPairMapper = qaPairMapper;
        this.responseChatMapper = responseChatMapper;
    }

    @PostMapping(path = "/api/v1/users/{user_id}/chats")
    //start asking question
    public ResponseEntity<ChatResponse> createChat(@RequestBody QAPairDto qaPairDto, @PathVariable("user_id") Long user_id) {
        Optional<UserEntity> userEntity = userService.findOne(user_id);
        if (userEntity.isPresent()) {
            QAPairEntity newQAPairEntity = qaPairMapper.mapFrom(qaPairDto);
            //call a post request to openai TODO set the prompt
            List<QAPairEntity> history = new ArrayList<>(Collections.singletonList(newQAPairEntity));
            openAIService.getResponse(history);

            ChatEntity newChatEntity = ChatEntity.builder()
                    .user(userEntity.get())
                    .topic("This is a default topic") //TODO get the topic
                    .build();

            newQAPairEntity.setChat(newChatEntity);

            ChatEntity savedChatEntity = chatService.create(newChatEntity);
            qaPairService.create(newQAPairEntity);

            ChatResponse response = responseChatMapper.mapToResponse(savedChatEntity, history);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/api/v1/users/{user_id}/chats")
    public ResponseEntity<List<ChatDto>> listChats(@PathVariable("user_id") Long userId) {
        Optional<UserEntity> userEntity = userService.findOne(userId);
        if (userEntity.isPresent()) {
            List<ChatEntity> chats = chatService.findAll(userEntity.get());
            return  new ResponseEntity<>(chats.stream()
                    .map(chatMapper::mapTo)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/api/v1/users/{user_id}/chats/{chat_id}")
    public ResponseEntity<Void> deleteChat(@PathVariable("chat_id") Long id) {
        chatService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/api/v1/users/{user_id}/chats/{chat_id}")
    //get all QAPairDtos have the same user and sort before sending back
    public ResponseEntity<List<QAPairDto>> getChat(@PathVariable("user_id") Long userId,
                                                 @PathVariable("chat_id") Long chatId) {
        Optional<UserEntity> userEntity = userService.findOne(userId);
        if (userEntity.isPresent()) {
            Optional<ChatEntity> chatEntity = chatService.findOne(chatId);

            if (chatEntity.isPresent()) {
                List<QAPairEntity> qaPairs = qaPairService.findAll(chatEntity.get());

                return new ResponseEntity<>(
                        qaPairs.stream()
                                .sorted(Comparator.comparing(QAPairEntity::getUpdatedAt))
                                .map(qaPairMapper::mapTo)
                                .collect(Collectors.toList()),
                        HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(path = "/api/v1/users/{user_id}/chats/{chat_id}")
    // update chat with a payload of question
    public ResponseEntity<QAPairDto> updateChat(@PathVariable("user_id") Long userId,
                                                @PathVariable("chat_id") Long chatId,
                                                @RequestBody QAPairDto qaPairDto) { // only question and answer will be empty
        Optional<UserEntity> userEntity = userService.findOne(userId);
        if (userEntity.isPresent()) {
            QAPairEntity newQAPairEntity = qaPairMapper.mapFrom(qaPairDto);
            newQAPairEntity.setAnswer("This is a default answer");

            //find the chat, set that chat to newQAPair's chat

            Optional<ChatEntity> chatEntity = chatService.findOne(chatId);
            if (chatEntity.isPresent()) {
                newQAPairEntity.setChat(chatEntity.get());

                QAPairEntity savedQAPairEntity = qaPairService.create(newQAPairEntity);

                return new ResponseEntity<>(qaPairMapper.mapTo(savedQAPairEntity), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
