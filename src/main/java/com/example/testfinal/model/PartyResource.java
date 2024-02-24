package com.example.testfinal.model;

import lombok.*;

import jakarta.persistence.*;


    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    public class PartyResource {

        private  long id;
        private String  name;
        private String title;
        private String address;
        private String phone;
        private String website;
        private String email;
    }

