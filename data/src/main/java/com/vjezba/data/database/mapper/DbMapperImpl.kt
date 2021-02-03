/*
 * Copyright (c) 2020 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.vjezba.data.database.mapper

import com.google.gson.annotations.SerializedName
import com.vjezba.data.database.model.DBMovies
import com.vjezba.data.networking.model.ApiMovies
import com.vjezba.domain.model.Articles
import com.vjezba.domain.model.MovieResult
import com.vjezba.domain.model.Movies
import com.vjezba.domain.model.News
import kotlin.collections.map

class DbMapperImpl : DbMapper {

    override fun mapApiMoviesToDomainMovies(apiMovies: ApiMovies): Movies {
        return with(apiMovies) {
            Movies(
                page,
                results,
                totalPages,
                totalResults
            )
        }
    }

    override fun mapDomainMoviesToDbMovies(moviesList: Movies): List<DBMovies> {
        return moviesList.result.map {
            with(it) {
                DBMovies(
                    id ?: 0,
                    idOfMovie = it.id ?: 0L,
                    backdropPath = it.backdropPath,
                    originalLanguage = it.originalLanguage,
                    originalTitle = it.originalTitle,
                    overview = it.overview,
                    popularity = it.popularity
                )
            }
        }
    }

    override fun mapDBMoviesListToMovies(moviesList: DBMovies): MovieResult {
        return with(moviesList) {
            MovieResult(
                id = id,
                backdropPath = backdropPath,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                overview = overview,
                popularity = popularity
            )
        }
    }

}
