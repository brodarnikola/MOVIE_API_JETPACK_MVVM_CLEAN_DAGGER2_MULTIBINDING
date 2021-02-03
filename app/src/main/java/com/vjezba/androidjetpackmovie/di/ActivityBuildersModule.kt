package com.vjezba.androidjetpackmovie.di


import com.vjezba.androidjetpackmovie.ui.activities.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMoviesActivity(): MoviesActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMovieDetailsActivity(): MoviesDetailsActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeTrailersActivity(): TrailersActivity

}
