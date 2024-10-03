package com.doctorhoai.monotholic_be.entity.Model;

import com.doctorhoai.monotholic_be.entity.OAuth2.Provider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String email;
    private String phone;
    @JoinColumn(name = "credentialId")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Credentials credentials;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "WishList",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "productId")}

    )
    @JsonIgnore
    private List<Product> products;
    @Enumerated( EnumType.STRING)
    private Provider provider;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(credentials.getAuthorities());
        return credentials.getAuthorities();
    }

    @Override
    public String getPassword() {
        return credentials.getPassword();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", credentials=" + credentials.getRole() +
                '}';
    }
}
