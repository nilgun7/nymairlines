package com.nilgun.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass // Veritabanında tablo oluşturmaz, alt sınıflara alanları aktarır
@Getter
@Setter
public abstract class BaseEntity<T> {

    @Id
    @GeneratedValue // UUID için strateji belirtilebilir
    protected T id;

    @CreatedDate
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @LastModifiedDate
    protected LocalDateTime lastModified;

    @Version // Optimistic Locking: Aynı anda iki kişinin veriyi bozmasını engellemek için
    protected Long version;

    protected boolean isDeleted = false;
}
