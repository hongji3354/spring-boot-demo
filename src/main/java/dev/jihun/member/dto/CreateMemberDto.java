package dev.jihun.member.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class CreateMemberDto {

    @NotEmpty(message = "{name.notempty}")
    private String name;
    private int age;
}
