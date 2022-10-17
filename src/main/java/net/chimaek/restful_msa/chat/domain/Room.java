package net.chimaek.restful_msa.chat.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@AllArgsConstructor
public class Room extends net.chimaek.restful_msa.chat.domain.BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "room")
    private List<net.chimaek.restful_msa.chat.domain.Message> messageList =
            new ArrayList<>();
}
