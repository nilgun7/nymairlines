package com.nilgun.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // flight-service'den teyit edilecek olan ID
    @Column(nullable = false)
    private Long flightId;

    @Column(nullable = false)
    private String passengerName;

    @Column(nullable = false)
    private String passengerEmail;

    // Rezervasyonun durumu (Onaylı, Beklemede, İptal)
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}