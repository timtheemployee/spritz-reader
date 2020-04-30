package com.wxxtfxrmx.spritzreader.domain.progress

class SetProgressUseCase(
    private val repository: ProgressRepository
){

    operator fun invoke(progress: Progress) {
        repository.set(progress)
    }
}