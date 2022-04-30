package com.zied.API;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.zied.API.controller.EmployeeController;
import com.zied.API.service.EmployeeService;


// @WebMvcTest : déclenche le mécanisme permettant de tester les controllers. On indique également le ou les controllers concernés.
// L’utilisation de @WebMvcTest permet d’écrire des tests unitaires sur le controller.
@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;        //  permet d’appeler la méthode “perform” qui déclenche la requête.

    @MockBean       // Cette annotation est obligatoire, car la méthode du controller exécutée par l’appel de “/employees” utilise cette classe
    private EmployeeService employeeService;

    @Test
    public void testGetEmployees() throws Exception {
        mockMvc.perform(get("/employees"))      // La méthode perform prend en paramètre l’instruction get(“/employees”). On exécute donc une requête GET sur l’URL /employees.
                .andExpect(status().isOk());            // l’instruction .andExpect(status().isOk()) indique que nous attendons une réponse HTTP 200.
    }


}