package ru.pcconfigurator.Tests.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.pcconfigurator.MainLogic.Application;
import ru.pcconfigurator.MainLogic.Cases.WorkWithData.IAccessoriesRepository;
import ru.pcconfigurator.MainLogic.Entities.Accessory;
import ru.pcconfigurator.MainLogic.Entities.Enums.VideoMemotyType;
import ru.pcconfigurator.MainLogic.Entities.Gpu;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class AccessoriesControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private IAccessoriesRepository accessoriesRepository;

    @Test
    public void checkEndPointAccessoriesId() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String testJson=mapper.writeValueAsString(UUID.randomUUID());
        String json = mapper.writeValueAsString(new Gpu("TESTGPU","nvidia",
                UUID.fromString("3422b448-2460-4fd2-9183-8000de6f8343"),
                12312,12,12, VideoMemotyType.GDDR4,123,750).convertToAccessoryDao());
        mvc.perform(MockMvcRequestBuilders.get("/accessories/3422b448-2460-4fd2-9183-8000de6f8343")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(json));

    }

    @Test
    public void checkEndPointAccessoriesIdButIdIdIcorrect() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/accessories/123123")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void checkEndPointAccessoriesWithoutParams() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(
                accessoriesRepository.findAllAccessories().stream().map(Accessory::convertToAccessoryDao).collect(Collectors.toList()));
        mvc.perform(MockMvcRequestBuilders.get("/accessories")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(json));

    }

    @Test
    public void checkEndPointAccessoriesWithParams() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/accessories?name=123")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

    }
    @Test
    public void checkEndPointAccessoriesWithEmptyParams() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(
                accessoriesRepository.findAllAccessories().stream().map(Accessory::convertToAccessoryDao).collect(Collectors.toList()));
        mvc.perform(MockMvcRequestBuilders.get("/accessories?name=\"\"")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(json));

    }

}
