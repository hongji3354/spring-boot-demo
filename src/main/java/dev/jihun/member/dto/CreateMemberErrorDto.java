package dev.jihun.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberErrorDto {

    private String errorCode;
    private String errorMessage;

}
