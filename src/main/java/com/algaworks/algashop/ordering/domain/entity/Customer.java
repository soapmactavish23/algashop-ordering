package com.algaworks.algashop.ordering.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Customer {
    private UUID id;
    private String fullName;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private String document;
    private Boolean promotionNotificationsAllowed;
    private Boolean archived;
    private OffsetDateTime registeredAt;
    private OffsetDateTime archivedAt;
    private Integer loyaltyPoints;

    public Customer(UUID id, String fullName, LocalDate birthDate, String email, String phone, String document,
                    Boolean promotionNotificationsAllowed, OffsetDateTime registeredAt) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.document = document;
        this.promotionNotificationsAllowed = promotionNotificationsAllowed;
        this.registeredAt = registeredAt;
    }

    public Customer(UUID id, String fullName, LocalDate birthDate, String email, String phone, String document,
                    Boolean promotionNotificationsAllowed, Boolean archived, OffsetDateTime registeredAt,
                    OffsetDateTime archivedAt, Integer loyaltyPoints) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.document = document;
        this.promotionNotificationsAllowed = promotionNotificationsAllowed;
        this.archived = archived;
        this.registeredAt = registeredAt;
        this.archivedAt = archivedAt;
        this.loyaltyPoints = loyaltyPoints;
    }

    public void addLoyaltyPoints(Integer points) {

    }

    public void archive() {

    }

    public void enablePromotionNotifications() {
        this.setPromotionNotificationsAllowed(true);
    }

    public void disablePromotionNotifications() {
        this.setPromotionNotificationsAllowed(false);
    }

    public void changeName(String fullName) {
        this.setFullName(fullName);
    }

    public void changeEmail(String email) {
        this.setEmail(email);
    }

    public void changePhone(String phone) {
        this.setPhone(phone);
    }

    private UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    private String getFullName() {
        return fullName;
    }

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private LocalDate getBirthDate() {
        return birthDate;
    }

    private void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    private String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    private String getDocument() {
        return document;
    }

    private void setDocument(String document) {
        this.document = document;
    }

    private Boolean getPromotionNotificationsAllowed() {
        return promotionNotificationsAllowed;
    }

    private void setPromotionNotificationsAllowed(Boolean promotionNotificationsAllowed) {
        this.promotionNotificationsAllowed = promotionNotificationsAllowed;
    }

    private Boolean getArchived() {
        return archived;
    }

    private void setArchived(Boolean archived) {
        this.archived = archived;
    }

    private OffsetDateTime getRegisteredAt() {
        return registeredAt;
    }

    private void setRegisteredAt(OffsetDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    private OffsetDateTime getArchivedAt() {
        return archivedAt;
    }

    private void setArchivedAt(OffsetDateTime archivedAt) {
        this.archivedAt = archivedAt;
    }

    private Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    private void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(fullName, customer.fullName) && Objects.equals(birthDate, customer.birthDate) && Objects.equals(email, customer.email) && Objects.equals(phone, customer.phone) && Objects.equals(document, customer.document) && Objects.equals(promotionNotificationsAllowed, customer.promotionNotificationsAllowed) && Objects.equals(archived, customer.archived) && Objects.equals(registeredAt, customer.registeredAt) && Objects.equals(archivedAt, customer.archivedAt) && Objects.equals(loyaltyPoints, customer.loyaltyPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, birthDate, email, phone, document, promotionNotificationsAllowed, archived, registeredAt, archivedAt, loyaltyPoints);
    }
}
