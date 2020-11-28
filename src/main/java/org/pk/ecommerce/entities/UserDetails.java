package org.pk.ecommerce.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Embeddable;
import javax.persistence.Column;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.pk.ecommerce.models.UserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@ToString

@Entity
@Table
@Embeddable
public class UserDetails extends User {

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dob;

    @Column(unique = true)
    private String emailAddress;

    @Column
    private UserRole userRole;

    @Column
    private LocalDateTime createdOn;

    @Column
    private LocalDateTime updatedOn;

}
