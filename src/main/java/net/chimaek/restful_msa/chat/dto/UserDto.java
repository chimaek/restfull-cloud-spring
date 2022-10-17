package net.chimaek.restful_msa.chat.dto;

import lombok.Builder;
import net.chimaek.restful_msa.chat.domain.User;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A DTO for the {@link User} entity
 */
@Builder
public record UserDto(LocalDateTime createdAt, LocalDateTime modifyAt, Long id,
                      String name, @NotNull String nickname, String password,
                      List<net.chimaek.restful_msa.chat.domain.Message> messageList) implements Serializable {
    ;

    public net.chimaek.restful_msa.chat.domain.User toCreateUser(String password) {
        return net.chimaek.restful_msa.chat.domain.User.builder().password(password).name(name).nickname(nickname).build();
    }

    public UserDto toUserDtoFromUser(net.chimaek.restful_msa.chat.domain.User user) {
        return UserDto.builder().name(user.getName()).nickname(user.getNickname()).id(user.getId()).createdAt(user.getCreatedAt()).modifyAt(user.getModifyAt()).build();
    }


}