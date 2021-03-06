package com.referyou.authentificationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @JsonProperty("code_id")
    private long id;

    @NotNull
    @Getter @Setter
    @JsonProperty("code_value")
    private String codeValue;

    @Getter @Setter
    @JsonProperty("description")
    private String description;

    @Getter @Setter
    @JsonProperty("number_of_uses")
    private int numberOfUses;

    @Getter @Setter
    @JsonProperty("redirect_url")
    private String RedirectUrl;

    @Getter @Setter
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("expiration_date")
    private LocalDateTime expirationDate;

    @Getter @Setter
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("creation_date")
    private LocalDateTime creationDate;


    @Getter @Setter
    @JsonProperty("user_id")
    @Column(name = "owner_id")
    private long ownerId;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", updatable = false, insertable = false)
    @JsonIgnore
    public Person owner;


    @Getter @Setter
    @Column(name = "website_id")
    @JsonProperty("website_id")
    public long websiteId;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "website_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    public Website website;

    @Getter
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "code_id", insertable = false, updatable = false)
    @JsonIgnore
    public Sponsor sponsor;

    @Getter
    @JsonIgnore
    @OneToMany(targetEntity = Rating.class, mappedBy = "codeId", cascade = CascadeType.REMOVE)
    public List<Rating> ratings;
}
