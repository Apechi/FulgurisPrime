package theprime.browser.cleanup

import theprime.activity.WebBrowserActivity
import theprime.utils.WebUtils
import android.webkit.WebView
import javax.inject.Inject

/**
 * Exit cleanup that should run on API < 28 when the incognito instance is closed. This is
 * significantly less secure than on API > 28 since we can separate WebView data from
 */
class BasicIncognitoExitCleanup @Inject constructor() :
    ExitCleanup {
    override fun cleanUp(webView: WebView?, context: WebBrowserActivity) {
        // We want to make sure incognito mode is secure as possible without also breaking existing
        // browser instances.
        WebUtils.clearWebStorage()
    }
}
