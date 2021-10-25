package com.example.weatherapp.domain.base

interface UseCase<T, in Params> {
    suspend operator fun invoke(params: Params): T
}
