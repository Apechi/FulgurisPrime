package theprime.search

import theprime.di.SuggestionsClient
import theprime.settings.preferences.UserPreferences
import android.app.Application
import dagger.Reusable
import theprime.search.engine.AskSearch
import theprime.search.engine.BaiduSearch
import theprime.search.engine.BaseSearchEngine
import theprime.search.engine.BingSearch
import theprime.search.engine.BraveSearch
import theprime.search.engine.CustomSearch
import theprime.search.engine.DuckLiteNoJSSearch
import theprime.search.engine.DuckLiteSearch
import theprime.search.engine.DuckNoJSSearch
import theprime.search.engine.DuckSearch
import theprime.search.engine.EcosiaSearch
import theprime.search.engine.EkoruSearch
import theprime.search.engine.GoogleSearch
import theprime.search.engine.MojeekSearch
import theprime.search.engine.NaverSearch
import theprime.search.engine.QwantLiteSearch
import theprime.search.engine.QwantSearch
import theprime.search.engine.SearxSearch
import theprime.search.engine.StartPageMobileSearch
import theprime.search.engine.StartPageSearch
import theprime.search.engine.YahooNoJSSearch
import theprime.search.engine.YahooSearch
import theprime.search.engine.YandexSearch
import theprime.search.suggestions.BaiduSuggestionsModel
import theprime.search.suggestions.DuckSuggestionsModel
import theprime.search.suggestions.GoogleSuggestionsModel
import theprime.search.suggestions.NaverSuggestionsModel
import theprime.search.suggestions.NoOpSuggestionsRepository
import theprime.search.suggestions.RequestFactory
import theprime.search.suggestions.SuggestionsRepository
import io.reactivex.Single
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * The model that provides the search engine based
 * on the user's preference.
 */
@Reusable
class SearchEngineProvider @Inject constructor(
    private val userPreferences: UserPreferences,
    @SuggestionsClient private val okHttpClient: Single<OkHttpClient>,
    private val requestFactory: RequestFactory,
    private val application: Application
) {

    /**
     * Provide the [SuggestionsRepository] that maps to the user's current preference.
     */
    fun provideSearchSuggestions(): SuggestionsRepository =
        when (userPreferences.searchSuggestionChoice) {
            0 -> NoOpSuggestionsRepository()
            1 -> GoogleSuggestionsModel(okHttpClient, requestFactory, application, userPreferences)
            2 -> DuckSuggestionsModel(okHttpClient, requestFactory, application, userPreferences)
            3 -> BaiduSuggestionsModel(okHttpClient, requestFactory, application, userPreferences)
            4 -> NaverSuggestionsModel(okHttpClient, requestFactory, application, userPreferences)
            else -> GoogleSuggestionsModel(okHttpClient, requestFactory, application, userPreferences)
        }

    /**
     * Provide the [BaseSearchEngine] that maps to the user's current preference.
     */
    fun provideSearchEngine(): BaseSearchEngine =
        when (userPreferences.searchChoice) {
            0 -> CustomSearch(userPreferences.searchUrl, userPreferences)
            1 -> GoogleSearch()
            2 -> AskSearch()
            3 -> BaiduSearch()
            4 -> BingSearch()
            5 -> BraveSearch()
            6 -> DuckSearch()
            7 -> DuckNoJSSearch()
            8 -> DuckLiteSearch()
            9 -> DuckLiteNoJSSearch()
            10 -> EcosiaSearch()
            11 -> EkoruSearch()
            12 -> MojeekSearch()
            13 -> NaverSearch()
            14 -> QwantSearch()
            15 -> QwantLiteSearch()
            16 -> SearxSearch()
            17 -> StartPageSearch()
            18 -> StartPageMobileSearch()
            19 -> YahooSearch()
            20 -> YahooNoJSSearch()
            21 -> YandexSearch()
            else -> GoogleSearch()
        }

    /**
     * Return the serializable index of of the provided [BaseSearchEngine].
     */
    fun mapSearchEngineToPreferenceIndex(searchEngine: BaseSearchEngine): Int =
        when (searchEngine) {
            is CustomSearch -> 0
            is GoogleSearch -> 1
            is AskSearch -> 2
            is BaiduSearch -> 3
            is BingSearch -> 4
            is BraveSearch -> 5
            is DuckSearch -> 6
            is DuckNoJSSearch -> 7
            is DuckLiteSearch -> 8
            is DuckLiteNoJSSearch -> 9
            is EcosiaSearch -> 10
            is EkoruSearch -> 11
            is MojeekSearch -> 12
            is NaverSearch -> 13
            is QwantSearch -> 14
            is QwantLiteSearch -> 15
            is SearxSearch -> 16
            is StartPageSearch -> 17
            is StartPageMobileSearch -> 18
            is YahooSearch -> 19
            is YahooNoJSSearch -> 20
            is YandexSearch -> 21
            else -> throw UnsupportedOperationException("Unknown search engine provided: " + searchEngine.javaClass)
        }

    /**
     * Provide a list of all supported search engines.
     */
    fun provideAllSearchEngines(): List<BaseSearchEngine> = listOf(
        CustomSearch(userPreferences.searchUrl, userPreferences),
        GoogleSearch(),
        AskSearch(),
        BaiduSearch(),
        BingSearch(),
        BraveSearch(),
        DuckSearch(),
        DuckNoJSSearch(),
        DuckLiteSearch(),
        DuckLiteNoJSSearch(),
        EcosiaSearch(),
        EkoruSearch(),
        MojeekSearch(),
        NaverSearch(),
        QwantSearch(),
        QwantLiteSearch(),
        SearxSearch(),
        StartPageSearch(),
        StartPageMobileSearch(),
        YahooSearch(),
        YahooNoJSSearch(),
        YandexSearch()
    )

}
