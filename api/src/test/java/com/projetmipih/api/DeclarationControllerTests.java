package com.projetmipih.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.projetmipih.api.controller.DeclarationController;
import com.projetmipih.api.service.DeclarationService;


@WebMvcTest(controllers = DeclarationController.class)
public class DeclarationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeclarationService employeeService;

    @Test
    public void testGetEmployees() throws Exception {
        mockMvc.perform(get("/declarations"))
            .andExpect(status().isOk());
    }

}