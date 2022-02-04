package dev.jihun.member.api;

import dev.jihun.IntegrationTest;
import dev.jihun.member.dto.CreateMemberErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class MemberApiTest extends IntegrationTest {

    @DisplayName("이름이 비어있거나 null 일시 다국화 처리된 에러 메시지가 넘어온다.")
    @ParameterizedTest
    @CsvSource(value = {"en : Name is mandatory."," ko : 이름은 필수입니다."}, delimiter = ':')
    void memberNameNullOrEmpty(String locale, String message) throws Exception {
        // given
        Map<String, Object> request = new HashMap<>();
        request.put("age", 30);

        // when
        MvcResult mvcResult = mockMvc.perform(post("/member")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                        .locale(new Locale(locale)))
                .andDo(print())
                .andReturn();

        // then
        CreateMemberErrorDto createMemberErrorDto = objectMapper.readValue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8), CreateMemberErrorDto.class);
        assertThat(createMemberErrorDto.getErrorCode()).isEqualTo("NotEmpty");
        assertThat(createMemberErrorDto.getErrorMessage()).isEqualTo(message);
    }
}