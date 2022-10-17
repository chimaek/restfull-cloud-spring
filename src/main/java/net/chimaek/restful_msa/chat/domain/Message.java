package net.chimaek.restful_msa.chat.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Message extends net.chimaek.restful_msa.chat.domain.BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
}
