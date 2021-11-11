package br.com.leandroid.data.network.funds.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
data class BeachEntity(
    @JsonProperty("id")
    @PrimaryKey var id: Int?,
    @JsonProperty("name")
    var name: String?,
    @JsonProperty("description")
    var description: String?
)