package com.kitapl.k.libraryservice.model

import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "Librarys")
data class Library @JvmOverloads constructor(
    @Id
    @Column(name="library_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id:String ? = "",
    @ElementCollection
    val userBook :List<String> = ArrayList()
) {
}