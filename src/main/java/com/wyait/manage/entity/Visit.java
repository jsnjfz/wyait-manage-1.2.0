package com.wyait.manage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author fz
 * @Date 2018/7/8 9:40
 * 
 */

@Entity
@Data
@Table(name = "visit")
public class Visit {

    @Id
    private int id;

    private String patientId;

    private String visitDate;

    private int age;

    private String mailingAddress;

    private String birthPlace;

    private String zipCode;

    private String sex;

    private String chargeType;

    private String identity;

    private String nation;

    private String idNo;

    private String diagDesc;

    private String illnessDesc;

    private String anamnesis;

    private String familyIll;

    private String marrital;

    private String individual;

    private String menses;

    private String medHistory;

    private String bodyExam;

    private String deptName;


}
