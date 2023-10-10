package com.facebook.minifacebookback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserData {
    private String given_name;
    private String family_name;
    private String email;
    private String preferred_username;
}
