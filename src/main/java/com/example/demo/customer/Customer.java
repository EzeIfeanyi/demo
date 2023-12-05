package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {
    @Id
    private String id;
    @Getter
    @NotBlank(message = "name should not be empty")
    private String name;
    @NotBlank(message = "password should not be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Getter
    @Email
    @NotBlank(message = "email should not be empty")
    private String email;

    @JsonProperty("customer_id")
    public String getId() {
        return this.id;
    }

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

}
