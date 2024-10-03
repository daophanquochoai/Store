package com.doctorhoai.monotholic_be.entity.Model;

import com.doctorhoai.monotholic_be.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer credentialId;
    private String username;
    private String password;
    @Enumerated( EnumType.STRING )
    private ERole role;
    private Boolean isEnabled;
    public List<SimpleGrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role));
    }
}
