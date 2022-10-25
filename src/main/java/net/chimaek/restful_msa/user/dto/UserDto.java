package net.chimaek.restful_msa.user.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.chimaek.restful_msa.user.domain.User;

/**
 * A DTO for the {@link User} entity
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

  @Getter
  @AllArgsConstructor
  @Builder
  public static class ResponseDto implements Serializable {

    private Long id;
    private String name;
    private String ssn;
    private String password;
    private LocalDateTime localDateTime;

  }

  @Builder
  @AllArgsConstructor
  @Getter
  public static class CreateUserDto {

    private String name;
    private String ssn;
    private String password;

    public User toEntity() {
      return User.builder().name(name).password(password).ssn(ssn).build();
    }
  }

  @Builder
  @AllArgsConstructor
  @Getter
  public static class DeleteUserDto {

    private String name;
    private String password;
  }


}