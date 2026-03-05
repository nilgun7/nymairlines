package com.nilgun.service;

import com.nilgun.client.FlightClient;
import com.nilgun.dto.BookingRequest;
import com.nilgun.dto.FlightResponse;
import com.nilgun.entity.Booking;
import com.nilgun.entity.BookingStatus;
import com.nilgun.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightClient flightClient;

    public Booking createBooking(BookingRequest request) {
        FlightResponse flight = flightClient.getFlightById(request.flightId());

        if (flight == null) {
            throw new RuntimeException("Hata: Belirtilen uçuş bulunamadı!");
        }

        if (flight.availableSeats() <= 0) {
            throw new RuntimeException("Hata: Bu uçuşta boş koltuk kalmamış!");
        }

        // 3. ADIM: Her şey yolundaysa rezervasyonu oluştur ve kaydet
        Booking booking = Booking.builder()
                .flightId(flight.id())
                .passengerName(request.passengerName())
                .passengerEmail(request.passengerEmail())
                .status(BookingStatus.CONFIRMED) // Şimdilik ödemesiz direkt onayla
                .build();

        return bookingRepository.save(booking);
    }
}