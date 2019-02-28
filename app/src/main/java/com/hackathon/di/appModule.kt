package com.hackathon.di

import com.hackathon.Constants
import com.hackathon.MyApplication
import com.hackathon.di.impl.AndroidLogger
import com.hackathon.di.impl.AndroidValidator
import com.hackathon.di.module.ContextModule
import com.hackathon.di.module.SchedulersModule
import com.hackathon.domain.auth.LoginTask
import com.hackathon.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Application dependency module, initiated by Koin in [MyApplication]
 */
val appModule = module {
    // Singletons
    single { ContextModule(androidContext()) }

    // Factories
    factory<ILogger> { AndroidLogger(Constants.TAG) }
    factory<IValidator> { AndroidValidator() }
    factory { SchedulersModule() }

    // Use Cases
    factory { LoginTask(get(), get()) }

    // View Models
    viewModel { HomeViewModel(get(), get(), get()) }
}