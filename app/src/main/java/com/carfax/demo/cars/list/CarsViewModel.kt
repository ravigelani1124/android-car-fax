package com.carfax.demo.cars.list

import com.carfax.demo.cars.model.toCarModel
import com.carfax.demo.common.getErrorMessage
import com.carfax.domain.cars.model.Car
import com.carfax.domain.cars.usecase.GetAvailableCarsUseCase
import com.carfax.domain.common.Resource
import io.uniflow.android.AndroidDataFlow
import io.uniflow.core.flow.actionOn

class CarsViewModel(
    private val useCase: GetAvailableCarsUseCase,
) : AndroidDataFlow(CarsState()) {

    init {
        loadAvailableCars()
    }

    fun refresh() = loadAvailableCars()

    private fun loadAvailableCars() = actionOn<CarsState> { state ->
        useCase().collect {
            setState(mapState(it, state))
        }
    }

    private fun mapState(
        it: Resource<List<Car>>,
        state: CarsState,
    ) = when (it) {
        is Resource.Error -> state.copy(
            loading = false,
            error = it.error?.getErrorMessage()
        )

        is Resource.Loading -> state.copy(
            loading = true
        )

        is Resource.Success -> state.copy(
            loading = false,
            data = it.data?.map { it.toCarModel() }
        )
    }
}