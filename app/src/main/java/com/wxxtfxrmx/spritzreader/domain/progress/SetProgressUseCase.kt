package com.wxxtfxrmx.spritzreader.domain.progress

import javax.inject.Inject

class SetProgressUseCase @Inject constructor(
    private val repository: ProgressRepository
){

    operator fun invoke(progress: Progress) {
        repository.set(progress)
    }
}