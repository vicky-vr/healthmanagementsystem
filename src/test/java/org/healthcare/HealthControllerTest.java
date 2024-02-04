package org.healthcare;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.healthcare.repository.HealthRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(org.healthcare.HealthController.class)
public class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @MockBean
//    @Autowired
    private HealthRepository healthRepository;

    @InjectMocks
    private org.healthcare.HealthController healthController;

    @Test
    void ShouldGetAppointment() throws Exception {
        // Perform GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/api/appointments"))
                .andExpect(status().isOk());

    }

    @Test
    void shouldAppointmentSave() throws Exception {
        Map<String, String> requestBody =  new HashMap<>();
        requestBody.put("patientId", "4");
        requestBody.put("date", "2022-02-05");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/appointments")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteAppointment() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/appointments/{appointmentId}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateAppointment() throws Exception {
        Map<String, String> requestBody =  new HashMap<>();
        requestBody.put("patientId", "4");
        requestBody.put("date", "2022-02-05");
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/appointments/{appointmentId}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk());
    }


}
