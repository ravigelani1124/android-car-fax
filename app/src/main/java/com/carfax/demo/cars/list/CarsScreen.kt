package com.carfax.demo.cars.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.carfax.demo.R
import com.carfax.demo.cars.model.CarCardModel
import com.carfax.demo.common.components.AppToolbar
import com.carfax.demo.common.components.ErrorComponent
import io.uniflow.android.livedata.states
import org.koin.androidx.compose.koinViewModel

@Composable
fun CarsScreen(
    vm: CarsViewModel = koinViewModel(),
    onCarSelected: (vin: String) -> Unit,
    callCarDealer: (phone: String) -> Unit,
) {
    (vm.states.observeAsState().value as? CarsState)?.let { state ->
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AppToolbar(title = stringResource(id = R.string.app_name))
            CarsList(
                state = state,
                retry = { vm.refresh() },
                onCarSelected = onCarSelected,
                onCallDealer = callCarDealer
            )
        }
    }
}

@Composable
private fun CarsList(
    state: CarsState,
    retry: () -> Unit,
    onCallDealer: (phone: String) -> Unit,
    onCarSelected: (vin: String) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            if (state.loading) CircularProgressIndicator()
            state.error?.let {
                ErrorComponent(
                    modifier = Modifier.padding(16.dp),
                    show = true,
                    message = it,
                    onRetry = retry
                )
            }
            state.data?.let {
                CarsListItemComponent(
                    cars = it,
                    onCarSelected = onCarSelected,
                    onCallDealer = onCallDealer
                )
            }
        }
    }
}

@Composable
fun CarsListItemComponent(
    cars: List<CarCardModel>,
    onCarSelected: (vin: String) -> Unit,
    onCallDealer: (phone: String) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(cars) { car ->
            CarSummaryCard(
                car = car,
                onCallDealerClick = onCallDealer,
                onCarSelected = onCarSelected
            )
        }
    }
}