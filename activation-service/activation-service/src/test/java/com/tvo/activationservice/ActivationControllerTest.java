//package com.tvo.activationservice;
//
//import com.tvo.activationservice.controller.ActivationController;
//import com.tvo.activationservice.service.ActivationService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(ActivationController.class)
//class ActivationControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    ActivationService service;
//
//    @Test
//    void shouldReturn200()
//            throws Exception {
//
//        when(service.getActivation("P100"))
//                .thenReturn(
//                        new ActivationResponse(
//                                "P100",
//                                true));
//
//        mockMvc.perform(
//                        get("/activations/P100"))
//                .andExpect(status().isOk())
//                .andExpect(
//                        jsonPath("$.productId")
//                                .value("P100"))
//                .andExpect(
//                        jsonPath("$.active")
//                                .value(true));
//    }
//}