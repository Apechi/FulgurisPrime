package theprime.di

import theprime.browser.cleanup.DelegatingExitCleanup
import theprime.browser.cleanup.ExitCleanup
import theprime.database.adblock.UserRulesDatabase
import theprime.database.adblock.UserRulesRepository
import theprime.database.bookmark.BookmarkDatabase
import theprime.database.bookmark.BookmarkRepository
import theprime.database.downloads.DownloadsDatabase
import theprime.database.downloads.DownloadsRepository
import theprime.database.history.HistoryDatabase
import theprime.database.history.HistoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Dependency injection module used to bind implementations to interfaces.
 * SL: Looks like those are still actually needed.
 */
@Module
@InstallIn(SingletonComponent::class)
interface AppBindsModule {

    @Binds
    fun bindsExitCleanup(delegatingExitCleanup: DelegatingExitCleanup): ExitCleanup

    @Binds
    fun bindsBookmarkModel(bookmarkDatabase: BookmarkDatabase): BookmarkRepository

    @Binds
    fun bindsDownloadsModel(downloadsDatabase: DownloadsDatabase): DownloadsRepository

    @Binds
    fun bindsHistoryModel(historyDatabase: HistoryDatabase): HistoryRepository

    @Binds
    fun bindsAbpRulesRepository(apbRulesDatabase: UserRulesDatabase): UserRulesRepository

}
