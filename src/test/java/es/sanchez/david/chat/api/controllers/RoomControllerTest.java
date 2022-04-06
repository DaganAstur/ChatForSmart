package es.sanchez.david.chat.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.sanchez.david.chat.core.service.rooms.RoomService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RoomController.class)
class RoomControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    RoomService roomService;


    @WithMockUser()
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/rooms").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // TODO FIX TESTS
//    @WithMockUser()
//    @Test
//    public void WhenARoomIsCreatedSuccessfully() throws Exception {
//        Room room = new Room(null, "test", LocalDateTime.now());
//        mvc.perform(MockMvcRequestBuilders.post("/rooms").content(asJsonString(room)).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }
//
//    public String asJsonString(final Object obj) {
//        try {
//            return this.objectMapper.writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}