package io.classiccrew.user_service.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppUsers extends BaseEntity {
    private Long ausrId;
    private String email;
    private String username;
    private String password;
}
