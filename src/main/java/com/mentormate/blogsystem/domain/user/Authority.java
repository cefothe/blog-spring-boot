package com.mentormate.blogsystem.domain.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Authority {

    @NotNull
    @Size(max = 50, min = 3)
    @Id
    @Column(length = 50)
    private String name;

}
