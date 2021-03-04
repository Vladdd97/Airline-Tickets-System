package com.airiline.tickets.domain;

import com.airiline.tickets.domain.common.UserRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class ATSUser extends AbstractEntity{
    @Column(unique = true, nullable = false)
    private String username;
    @NotNull
    private String password;
    private Boolean enabled;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
