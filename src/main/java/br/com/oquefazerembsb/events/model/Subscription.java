package br.com.oquefazerembsb.events.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "table_subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_number")
    private Integer subscriptionNumber;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventModel eventID;

    @ManyToOne
    @JoinColumn(name = "subscribed_user_id")
    private UserModel subscriptionID;

    @ManyToOne
    @JoinColumn(name = "indication_user_id", nullable = true)
    private UserModel indicationID;
}
