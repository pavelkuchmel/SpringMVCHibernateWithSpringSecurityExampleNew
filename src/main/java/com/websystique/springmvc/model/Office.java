package com.websystique.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "offices")
@ToString
public class Office  {
    public Office(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String address;
    @Column(name = "phone_1")
    private String phone1;
    @Column(name = "phone_2")
    private String phone2;
    @Column(name = "postal_code")
    private int postalCode;

    @Column(name = "updated_ts")
    @UpdateTimestamp
    private Timestamp updatedTS;

    @Column(name ="created_ts", columnDefinition = "CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Timestamp createdTS;
}
