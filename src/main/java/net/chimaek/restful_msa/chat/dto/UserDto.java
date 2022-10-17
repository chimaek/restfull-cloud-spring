package net.chimaek.restful_msa.chat.dto;

import lombok.Builder;
import net.chimaek.restful_msa.chat.domain.Message;
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
                      List<Message> messageList) implements Serializable {
    ;

    public static UserDto toUserDtoFromUser(User user) {
        return UserDto.builder().name(user.getName()).nickname(user.getNickname()).id(user.getId()).createdAt(user.getCreatedAt()).modifyAt(user.getModifyAt()).build();
    }

    public User toCreateUser(String password) {
        return User.builder().password(password).name(name).nickname(nickname).build();
    }


}