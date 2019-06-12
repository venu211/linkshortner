package com.api.linkshortner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
//import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "LINK")
@EntityListeners({AuditingEntityListener.class})
public class Link implements Serializable {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "url", nullable = false , unique = true)
    private String url;

    @Column(name = "hash", nullable = false, unique = true)
    private String hash;

    @JsonIgnore
    @CreatedDate
    private Instant createdDate;

    @JsonIgnore
    @LastModifiedDate
    private Instant modifiedDate;

    @JsonIgnore
    @Version
    private Long version;
}
