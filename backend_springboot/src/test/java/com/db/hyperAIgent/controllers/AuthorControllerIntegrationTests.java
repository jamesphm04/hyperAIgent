package com.db.hyperAIgent.controllers;

import com.db.hyperAIgent.TestDataUtil;
import com.db.hyperAIgent.domain.dto.UserDto;
import com.db.hyperAIgent.domain.entities.UserEntity;
import com.db.hyperAIgent.services.UserService;
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
public class AuthorControllerIntegrationTests {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    private UserService userService;

    @Autowired
    public AuthorControllerIntegrationTests(MockMvc mockMvc, UserService userService) {
        this.mockMvc = mockMvc;
        this.userService = userService;
        this.objectMapper = new ObjectMapper();
    }

//    @Test
//    public void testThatCreateAuthorSuccessfullyReturnsHttp201Created() throws Exception {
//        UserEntity testAuthorA = TestDataUtil.createTestAuthorEntityA();
//        testAuthorA.setId(null);
//        String authorJson = objectMapper.writeValueAsString(testAuthorA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.post("/authors")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(authorJson)
//        ).andExpect(MockMvcResultMatchers.status().isCreated());
//    }
//
//    @Test
//    public void testThatCreateAuthorSuccessfullyReturnsSavedAuthor() throws Exception {
//        UserEntity testAuthorA = TestDataUtil.createTestAuthorEntityA();
//        testAuthorA.setId(null);
//        String authorJson = objectMapper.writeValueAsString(testAuthorA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.post("/authors")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(authorJson)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.id").isNumber()
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.name").value(testAuthorA.getName())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.age").value(testAuthorA.getAge())
//        );
//    }
//
//    @Test
//    public void testThatListAuthorsReturnsHttpStatus200() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/authors")
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void testThatListAuthorsReturnsListOfAuthors() throws Exception {
//        UserEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
//        userService.createUpdate(testAuthorEntityA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/authors")
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$[0].name").value(testAuthorEntityA.getName())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$[0].age").value(testAuthorEntityA.getAge())
//        );
//    }
//
//    @Test
//    public void testThatGetAuthorReturnsHttpStatus200WhenAuthorExist() throws Exception {
//        UserEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
//        userService.createUpdate(testAuthorEntityA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/authors/" + testAuthorEntityA.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void testThatGetAuthorReturnsHttpStatus404WhenNoAuthorExist() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/authors/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void testThatGetAuthorReturnsAuthorWhenAuthorExist() throws Exception {
//        UserEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
//        userService.createUpdate(testAuthorEntityA);
//
//        UserEntity testAuthorEntityB = TestDataUtil.createTestAuthorEntityB();
//        userService.createUpdate(testAuthorEntityB);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/authors/" + testAuthorEntityA.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.id").value(testAuthorEntityA.getId())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.name").value(testAuthorEntityA.getName())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.age").value(testAuthorEntityA.getAge())
//        );
//    }
//
//    @Test
//    public void testThatFullUpdateAuthorReturnsHttpStatus404WhenNoAuthorExist() throws Exception {
//        UserEntity testAuthorA = TestDataUtil.createTestAuthorEntityA();
//        String authorJson = objectMapper.writeValueAsString(testAuthorA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put("/authors/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(authorJson)
//        ).andExpect(MockMvcResultMatchers.status().isNotFound());
//    }
//
//    @Test
//    public void testThatFullUpdateAuthorReturnsHttpStatus200WhenAuthorExist() throws Exception {
//        UserEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
//        userService.createUpdate(testAuthorEntityA);
//
//        String authorJson = objectMapper.writeValueAsString(testAuthorEntityA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put("/authors/" + testAuthorEntityA.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(authorJson)
//        ).andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void testThatFullUpdateUpdatesExistingAuthor() throws Exception {
//        UserEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
//        UserEntity savedAuthor = userService.createUpdate(testAuthorEntityA);
//
//        UserDto authorDto = TestDataUtil.createTestAuthorDtoA();
//        authorDto.setId(savedAuthor.getId());
//
//        String authorDtoUpdatingJson = objectMapper.writeValueAsString(authorDto);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.put("/authors/" + savedAuthor.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(authorDtoUpdatingJson)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.id").value(savedAuthor.getId())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.name").value(authorDto.getName())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.age").value(authorDto.getAge())
//        );
//    }
//
//    @Test
//    public void testThatPartialUpdateAuthorReturnsHttpStatus200() throws Exception {
//        UserEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
//        userService.createUpdate(testAuthorEntityA);
//
//        testAuthorEntityA.setAge(null);
//        testAuthorEntityA.setName("updated name");
//        String authorJson = objectMapper.writeValueAsString(testAuthorEntityA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.patch("/authors/" + testAuthorEntityA.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(authorJson)
//        ).andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//    @Test
//    public void testThatPartialUpdateAuthorReturnsUpdatedAuthor() throws Exception {
//        UserEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
//        UserEntity updatedAuthor = userService.createUpdate(testAuthorEntityA);
//
//        testAuthorEntityA.setAge(null);
//        testAuthorEntityA.setName("updated name");
//        String authorJson = objectMapper.writeValueAsString(testAuthorEntityA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.patch("/authors/" + testAuthorEntityA.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(authorJson)
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.id").value(testAuthorEntityA.getId())
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.name").value("updated name")
//        ).andExpect(
//                MockMvcResultMatchers.jsonPath("$.age").value(updatedAuthor.getAge())
//        );
//    }
//
//    @Test
//    public void testThatDeleteAuthorReturnHttp204EvenNonExist() throws Exception{
//        mockMvc.perform(
//                MockMvcRequestBuilders.delete("/authors/1")
//        ).andExpect(MockMvcResultMatchers.status().isNoContent());
//    }
//
//    @Test
//    public void testThatDeleteAuthorReturnHttp204() throws Exception {
//        UserEntity testAuthorEntityA = TestDataUtil.createTestAuthorEntityA();
//        UserEntity existedAuthorEntity = userService.createUpdate(testAuthorEntityA);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.delete("/authors/" + existedAuthorEntity.getId())
//        ).andExpect(MockMvcResultMatchers.status().isNoContent());
//    }
}
