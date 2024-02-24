package com.example.testfinal.entity;


import com.example.testfinal.model.PartyResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "party")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column
    private String  name;

    @Column
    private String title;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String website;

    @Column
    private String email;

    public PartyResource toPartyResource() {
        return PartyResource
                .builder()
                .id(this.id)
                .name(this.name)
                .title(this.title)
                .address(this.address)
                .phone(this.phone)
                .email(this.email).build();
    }
}
