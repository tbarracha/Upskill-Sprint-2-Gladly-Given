package pt.gladlyGivenApi.GladlyGiven.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pt.gladlyGivenApi.GladlyGiven.Models.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    Page<Availability> findByServiceProviderId(Long serviceProviderId, Pageable pageable);

    Page<Availability> findByStartDateTime(String startDateTime, Pageable pageable);

    Page<Availability> findByEndDateTime(String endDateTime, Pageable pageable);
}
