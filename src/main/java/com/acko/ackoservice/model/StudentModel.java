package com.acko.ackoservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Generated;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="students",indexes = {
        @Index(columnList = "rollnum", name = "user_id_hidx"),
        @Index(columnList = "name", name = "user_name_hidx")
})
public class StudentModel {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rollnum;
    private String name;
    private String city;
    private String branch;
    private double marks;

}
