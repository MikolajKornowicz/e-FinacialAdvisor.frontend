package com.example.efinancialadvisor.front.domain;

import lombok.*;

import java.util.Objects;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private String username;
    private String password;
    private Long userId;


    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password) && Objects.equals(userId, userDto.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, userId);
    }
}
