package com.pandiandcode.mpp.cardsagainsthumanity.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

internal expect val Main: CoroutineDispatcher

internal expect val Background: CoroutineDispatcher