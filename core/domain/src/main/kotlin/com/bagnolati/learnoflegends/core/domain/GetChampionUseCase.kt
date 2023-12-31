package com.bagnolati.learnoflegends.core.domain

import com.bagnolati.learnoflegends.core.common.result.Result
import com.bagnolati.learnoflegends.core.common.result.mapOnSuccess
import com.bagnolati.learnoflegends.core.data.repository.ChampionRepository
import com.bagnolati.learnoflegends.core.domain.mapper.asChampion
import com.bagnolati.learnoflegends.core.model.Champion
import javax.inject.Inject

class GetChampionUseCase @Inject constructor(
    private val championRepository: ChampionRepository
) {
    suspend operator fun invoke(championId: String): Result<Champion> =
        championRepository.getChampion(championId)
            .mapOnSuccess { it.asChampion() }
}