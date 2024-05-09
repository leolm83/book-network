package com.leolmcoding.booknetwork.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leolmcoding.booknetwork.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "app_role")
@EntityListeners(AuditingEntityListener.class)

public class Role {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<User> users;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
