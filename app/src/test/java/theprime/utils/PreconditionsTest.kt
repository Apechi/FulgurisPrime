package theprime.utils

import org.junit.Test

/**
 * Unit tests for [Preconditions].
 */
class PreconditionsTest {

    @Test(expected = RuntimeException::class)
    fun `checkNonNull throws exception for null param`() = theprime.utils.Preconditions.checkNonNull(null)

    @Test
    fun `checkNonNull succeeds for non null param`() = theprime.utils.Preconditions.checkNonNull(Any())
}