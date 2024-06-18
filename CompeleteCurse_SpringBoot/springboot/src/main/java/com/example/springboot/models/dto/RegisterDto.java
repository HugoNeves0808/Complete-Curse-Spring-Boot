package com.example.springboot.models.dto;

import com.example.springboot.models.UserRoleModel;

public record RegisterDto(String login, String password, UserRoleModel role) {
}
