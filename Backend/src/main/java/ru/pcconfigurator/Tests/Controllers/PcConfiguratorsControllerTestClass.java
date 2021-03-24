package ru.pcconfigurator.Tests.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.pcconfigurator.MainLogic.Application;
import ru.pcconfigurator.MainLogic.Entities.PcConfiguration;
import ru.pcconfigurator.Tests.SpringConfiguration.SpringConfigurationFakeClasses;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc

public class PcConfiguratorsControllerTestClass {
    @Autowired
    private MockMvc mvc;

    @Test
    public void checkEndPointAddPcConfigurator() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationFakeClasses.class);

        PcConfiguration pcConfiguration=context.getBean("getFullConfiguration", PcConfiguration.class);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pcConfiguration);
        mvc.perform(MockMvcRequestBuilders.post("/pcconfigurations")
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
