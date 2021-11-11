package br.com.leandroid.domain.model

import android.os.Parcelable
import br.com.leandroid.data.network.funds.entity.BeachEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
class BeachDomain(
    var name: String,
    var description: String?
) : Parcelable {

    companion object {
        fun convertToDomainList(
            beachEntities: List<BeachEntity>?
        ): List<BeachDomain> {
            val beachDomains = ArrayList<BeachDomain>()

            beachEntities?.forEach {
                beachDomains.add(
                    BeachDomain(
                        name = it.name ?: "",
                        description = it.description ?: ""
                    )
                )
            }
            return beachDomains
        }
    }
}
