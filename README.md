# ✈️ NymAirlines — Microservice Tabanlı Havayolu Rezervasyon Sistemi

Microservice mimarisi prensipleri kullanılarak geliştirilmiş 
bir havayolu rezervasyon sistemidir.

## 🏗️ Mimari

| Servis | Açıklama |
|---|---|
| api-gateway | Tüm servislere tek giriş noktası |
| eureka-server | Servis keşfi ve kayıt |
| flight-service | Uçuş sorgulama ve yönetimi |
| booking-service | Rezervasyon işlemleri |
| user-service | Kullanıcı yönetimi |

## 🛠️ Teknolojiler

- Java / Spring Boot
- Spring Cloud (Eureka, API Gateway)
- Docker / Docker Compose

## 🚀 Nasıl Çalıştırılır

Projeyi klonlayın:
git clone https://github.com/nilgun7/nymairlines.git

Docker ile ayağa kaldırın:
docker-compose up
