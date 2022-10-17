package net.chimaek.restful_msa.chat.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends net.chimaek.restful_msa.chat.domain.BaseEntity {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long id;

    private String name;

    @Column(unique = true)
    @NotNull
    private String nickname;

    private String password;


    @OneToMany(mappedBy = "user")
    private List<net.chimaek.restful_msa.chat.domain.Message> messageList =
            new ArrayList<>();


}
