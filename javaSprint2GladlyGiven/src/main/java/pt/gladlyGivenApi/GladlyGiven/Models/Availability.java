// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public long userId;

    public AvailabilityStatus availabilityStatus;

    public String startDateTime;

    public String endDateTime;

    public Availability() {

    }

    public Availability(long userId, AvailabilityStatus availabilityStatus, String startDateTime, String endDateTime) {
        this.userId = userId;
        this.availabilityStatus = availabilityStatus;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}