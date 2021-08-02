package com.superheroes.springboot.SpringBootRestWithH2;

import java.util.ArrayList;
import java.util.List;

import com.superheroes.springboot.SpringBootRestWithH2.model.Superheroe;
import com.superheroes.springboot.SpringBootRestWithH2.service.SuperheroeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class SuperheroeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SuperheroeService superheroeService;

    @Test
    public void testGetDepartment() throws Exception {
        Superheroe superheroe = new Superheroe();
        superheroe.setId(1);

        List<Superheroe> superheroeList = new ArrayList<>();
        superheroeList.add(superheroe);

        given(superheroeService.findAll()).willReturn(superheroeList);

        this.mockMvc.perform(get("/superheroes")).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1));
    }

}
