package br.com.oquefazerembsb.events.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "table_subscription")
public class SubscriptionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_number")
    private Integer subscriptionNumber;

    @Column
    private EventModel event;

    private UserModel subscriptionID;

    private UserModel indicationID;
}
