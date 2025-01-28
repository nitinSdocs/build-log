package com.MulitThreading.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document(collection = "vendor")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Vendor {
    @Id
    private String id;
    private String logicalSystem;
    private String docId;
    private String vendorName;
    private String VendorType;

}
