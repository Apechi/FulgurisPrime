package theprime.di

import theprime.adblock.AbpBlockerManager
import theprime.adblock.AbpUserRules
import theprime.adblock.NoOpAdBlocker
import theprime.browser.TabsManager
import theprime.database.bookmark.BookmarkRepository
import theprime.database.downloads.DownloadsRepository
import theprime.database.history.HistoryRepository
import theprime.dialog.LightningDialogBuilder
import theprime.download.DownloadHandler
import theprime.favicon.FaviconModel
import theprime.html.homepage.HomePageFactory
import theprime.js.InvertPage
import theprime.js.SetMetaViewport
import theprime.js.TextReflow
import theprime.network.NetworkConnectivityModel
import theprime.search.SearchEngineProvider
import theprime.settings.preferences.UserPreferences
import theprime.utils.ProxyUtils
import theprime.view.webrtc.WebRtcPermissionsModel
import android.app.DownloadManager
import android.content.ClipboardManager
import android.content.SharedPreferences
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.Scheduler

/**
 * Provide access to all our injectable classes.
 * Virtual fields can't resolve qualifiers for some reason.
 * Therefore we use functions where qualifiers are needed.
 *
 * Just add your class here if you need it.
 *
 * TODO: See if and how we can use the 'by' syntax to initialize usage of those.
 */
@EntryPoint
@InstallIn(SingletonComponent::class)
interface HiltEntryPoint {

    val bookmarkRepository: BookmarkRepository
    val userPreferences: UserPreferences
    @UserPrefs
    fun userSharedPreferences(): SharedPreferences
    val historyRepository: HistoryRepository
    @DatabaseScheduler
    fun databaseScheduler(): Scheduler
    @NetworkScheduler
    fun networkScheduler(): Scheduler
    @DiskScheduler
    fun diskScheduler(): Scheduler
    @MainScheduler
    fun mainScheduler(): Scheduler
    val searchEngineProvider: SearchEngineProvider
    val proxyUtils: ProxyUtils
    val textReflowJs: TextReflow
    val invertPageJs: InvertPage
    val setMetaViewport: SetMetaViewport
    val homePageFactory: HomePageFactory
    val abpBlockerManager: AbpBlockerManager
    val noopBlocker: NoOpAdBlocker
    val dialogBuilder: LightningDialogBuilder
    val networkConnectivityModel: NetworkConnectivityModel
    val faviconModel: FaviconModel
    val webRtcPermissionsModel: WebRtcPermissionsModel
    val abpUserRules: AbpUserRules
    val downloadHandler: DownloadHandler
    val downloadManager: DownloadManager
    val downloadsRepository: DownloadsRepository
    var tabsManager: TabsManager
    var clipboardManager: ClipboardManager

}


