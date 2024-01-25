package com.example.ecommerce.general;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/*@Embeddable ve @Embedded anotasyonları kullanarak ara tablo oluşturmaya gerek kalmadan “gömmek” istediğimiz
persist sınıfımıza eklememiz yeterli olmaktadır.
Java nesnesi tarafından farklı sınıflar ile yönettiğimiz alanları,
veritabanı olarak aynı tabloda görmemizi sağlamaktadır.*/
@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

}
