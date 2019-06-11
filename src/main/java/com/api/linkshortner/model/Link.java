package com.api.linkshortner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

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
    private ZonedDateTime createdDate;

    @JsonIgnore
    @LastModifiedDate
    private ZonedDateTime modifiedDate;

    @JsonIgnore
    @Version
    private Long version;
}
