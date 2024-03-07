/**
 * Author: Hugo Lopes
 */
package pt.gladlyGivenApi.GladlyGiven.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idServiceProvider;

    @OneToOne
    @JoinColumn(name = "appUser_id")
    public long idAppUser;

    public Category category;
    public List<Service> services = new ArrayList<>();
    public String licenseNumber;
    public List<Availability> availabilities;
    public List<Review> reviews;
    public float reviewAverage;

    public ServiceProvider() {
    }

    public ServiceProvider(
            Category category,
            List<Service> services,
            String licenseNumber,
            List<Availability> availabilities,
            List<Review> reviews,
            float reviewAverage) {
        this.category = category;
        this.services = services;
        this.licenseNumber = licenseNumber;
        this.availabilities = availabilities;
        this.reviews = reviews;
        this.reviewAverage = reviewAverage;
    }

    public long getIdServiceProvider() {
        return idServiceProvider;
    }

    public long getIdAppUser() {
        return idAppUser;
    }

    public Category getCategory() {
        return category;
    }

    public List<Service> getServices() {
        return services;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public float getReviewAverage() {
        return reviewAverage;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setReviewAverage(float reviewAverage) {
        this.reviewAverage = reviewAverage;
    }
}
