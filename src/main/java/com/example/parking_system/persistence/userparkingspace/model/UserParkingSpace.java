package com.example.parking_system.persistence.userparkingspace.model;

import com.example.parking_system.persistence.parkingspace.model.ParkingSpace;
import com.example.parking_system.persistence.user.model.User;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserParkingSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date start;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date end;

    @ManyToOne
    User user;

    @ManyToOne
    ParkingSpace parkingSpace;

    public UserParkingSpace() {
    }

    public UserParkingSpace(User user, ParkingSpace parkingSpace, Date start, Date end) {
        this.user = user;
        this.parkingSpace = parkingSpace;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public User getUser() {
        return user;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
}
