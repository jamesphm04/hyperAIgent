package com.db.hyperAIgent.controllers;


import com.db.hyperAIgent.TestDataUtil;
import com.db.hyperAIgent.domain.dto.ChatDto;
import com.db.hyperAIgent.domain.entities.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class ChatControllerIntegrationTests {

//    private MockMvc mockMvc;
//
//    private BookService bookService;
//
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    public ChatControllerIntegrationTests(MockMvc mockMvc, BookService bookService) {
//        this.mockMvc = mockMvc;
//        this.bookService = bookService;
//        this.objectMapper = new ObjectMapper();
//    }
//
////    @Test
//    public void testThatCreateBookReturnsHttpStatus201Created() throws Exception {
//        ChatDto chatDto = TestDataUtil.createTestBookDtoA(null);
//        String bookJson = objectMapper.writeValueAsString(chatDto);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put("/books/" + chatDto.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(bookJson)
//        ).andExpect(
//                MockMvcResultMatchers.status().isCreated()
//        );
//    }
//
//    @Test
//    public void testThatCreateBookReturnsSavedBook() throws Exception {
//        ChatDto chatDto = TestDataUtil.createTestBookDtoA(null);
//        String bookJson = objectMapper.writeValueAsString(chatDto);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put("/books/" + chatDto.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(bookJson)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.isbn").value(chatDto.getIsbn())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.title").value(chatDto.getTitle())
//        );
//    }
//
//    @Test
//    public void testThatListBooksReturnsHttpStatus200() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/books")
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void testThatListAuthorsReturnsListOfAuthors() throws Exception {
//        UserEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
//        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(testAuthorEntityA);
//        bookService.createUpdate(testBookEntityA.getIsbn(), testBookEntityA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/books")
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$[0].isbn").value(testBookEntityA.getIsbn())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$[0].title").value(testBookEntityA.getTitle())
//        );
//    }
//
//    @Test
//    public void testThatGetBookReturnsHttpStatus200WhenBookExist() throws Exception {
//        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
//        bookService.createUpdate(testBookEntityA.getIsbn(), testBookEntityA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/books/" + testBookEntityA.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void testThatGetBookReturnsHttpStatus404WhenNoBookExist() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/books/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void testThatGetBookReturnsBookWhenBookExist() throws Exception {
//        BookEntity testBookEntityA = TestDataUtil.createTestBookEntityA(null);
//        bookService.createUpdate(testBookEntityA.getIsbn(), testBookEntityA);
//
//        BookEntity testBookEntityB = TestDataUtil.createTestBookEntityB(null);
//        bookService.createUpdate(testBookEntityB.getIsbn(), testBookEntityB);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/books/" + testBookEntityA.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.isbn").value(testBookEntityA.getIsbn())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.title").value(testBookEntityA.getTitle())
//        );
//    }
//
//    @Test
//    public void testThatFullUpdateBookReturnsHttpStatus200() throws Exception {
//        BookEntity existedBookEntity= TestDataUtil.createTestBookEntityA(null);
//        bookService.createUpdate(existedBookEntity.getIsbn(), existedBookEntity);
//
//        ChatDto chatDto = TestDataUtil.createTestBookDtoA(null);
//        String updatedTitle = chatDto.getTitle() + "updated";
//        chatDto.setTitle(updatedTitle);
//        String bookJson = objectMapper.writeValueAsString(chatDto);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put("/books/" + chatDto.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(bookJson)
//        ).andExpect(
//                MockMvcResultMatchers.status().isOk()
//        );
//    }
//
//    @Test
//    public void testThatFullUpdateUpdatesExistingBook() throws Exception {
//        BookEntity existedBookEntity= TestDataUtil.createTestBookEntityA(null);
//        bookService.createUpdate(existedBookEntity.getIsbn(), existedBookEntity);
//
//        ChatDto chatDto = TestDataUtil.createTestBookDtoA(null);
//        String updatedTitle = chatDto.getTitle() + "updated";
//        chatDto.setTitle(updatedTitle);
//
//        String bookJson = objectMapper.writeValueAsString(chatDto);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put("/books/" + existedBookEntity.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(bookJson)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.isbn").value(existedBookEntity.getIsbn())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.title").value(existedBookEntity.getTitle() +"updated")
//        );
//    }
//
//    @Test
//    public void testThatPartialUpdateBookReturnsHttpStatus200() throws Exception {
//        BookEntity bookEntity= TestDataUtil.createTestBookEntityA(null);
//        BookEntity existedBookEntity = bookService.createUpdate(bookEntity.getIsbn(), bookEntity);
//
//        ChatDto chatDto = TestDataUtil.createTestBookDtoA(null);
//        chatDto.setTitle("updated title");
//        String bookJson = objectMapper.writeValueAsString(chatDto);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.patch("/books/" + chatDto.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(bookJson)
//        ).andExpect(
//                MockMvcResultMatchers.status().isOk()
//        );
//    }
//
//    @Test
//    public void testThatPartialUpdateBookReturnsUpdatedBook() throws Exception {
//        BookEntity bookEntity= TestDataUtil.createTestBookEntityA(null);
//        bookService.createUpdate(bookEntity.getIsbn(), bookEntity);
//
//        ChatDto chatDto = TestDataUtil.createTestBookDtoA(null);
//        chatDto.setTitle("updated title");
//        String bookJson = objectMapper.writeValueAsString(chatDto);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.patch("/books/" + chatDto.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(bookJson)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.title").value("updated title")
//        );
//    }
//
//    @Test
//    public void testThatDeleteBookReturnsHttpStatus204EvenNotExist() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.delete("/books/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(MockMvcResultMatchers.status().isNoContent());
//    }
//
//    @Test
//    public void testThatDeleteBookReturnsHttpStatus204() throws Exception {
//        BookEntity testBookEntity = TestDataUtil.createTestBookEntityA(null);
//        mockMvc.perform(
//                MockMvcRequestBuilders.delete("/books/" + testBookEntity.getIsbn())
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(MockMvcResultMatchers.status().isNoContent());
//    }
}
