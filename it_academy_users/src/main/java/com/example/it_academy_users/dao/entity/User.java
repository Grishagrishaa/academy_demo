package com.example.it_academy_users.dao.entity;

import com.example.it_academy_users.controllers.utils.LocalDateTimeSerializer;
import com.example.it_academy_users.dao.entity.enums.ERole;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email", name = "emailConstr"))
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID uuid;
    @CreatedDate
    private LocalDateTime createDate;
    @Version
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateDate;

    private String name;
    private String surname;
    private String patronymic;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private ERole role;

    public User(Builder builder) {
        this.uuid = builder.uuid;
        this.createDate = builder.createDate;
        this.updateDate = builder.updateDate;
        this.name = builder.name;
        this.surname = builder.surname;
        this.patronymic = builder.patronymic;
        this.email = builder.email;
        this.role = builder.role;
    }

    public User() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public User setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public User setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public User setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public static class Builder{
        private UUID uuid;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private String name;
        private String surname;
        private String patronymic;
        private String email;
        private ERole role;

        private Builder() {
        }

        public Builder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder setCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder setUpdateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setRole(ERole role) {
            this.role = role;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public User build(){
            return new User(this);
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "uuid=" + uuid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
