package dev.jihun.member.api;

import dev.jihun.member.dto.CreateMemberDto;
import dev.jihun.member.dto.CreateMemberErrorDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberApi {

    @PostMapping
    public CreateMemberErrorDto create(@RequestBody @Valid CreateMemberDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            return new CreateMemberErrorDto(errors.get(0).getCode(), errors.get(0).getDefaultMessage());
        }
        return null;
    }
}
