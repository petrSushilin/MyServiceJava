package ru.medicaltickets.MyServiceJava.user.account.dto;

public record AccountChangePasswordDTO (String login, char[] oldPassword, char[] newPassword) {
}
