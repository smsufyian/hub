package org.example

import com.flagsmith.kotlin.FlagsmithClient
import kotlin.test.Test
import kotlin.test.assertTrue

class ServiceShould {


    private fun initializeFlagsmithClient(): FlagsmithClient {
        val apiKey: String = System.getenv("FLAGSMITH_API_KEY") ?: "QjLnrDgQcDkedB63mDxeCH"
        return try {
            FlagsmithClient.Builder().apiKey(apiKey).build()
        } catch (e: Exception) {
            throw IllegalStateException("Failed to initialize Flagsmith client: ${e.message}")
        }
    }


    @Test
    fun accessFlagSmithFeatureFlags() {
        val flagsmithClient = initializeFlagsmithClient()
        val featureName = "mock-feature"
        val flag = flagsmithClient.getEnvironmentFlags().isFeatureEnabled(featureName)
        assertTrue(
            flag,
            "Feature toggle '$featureName' should be enabled. Please check Flagsmith dashboard configuration."
        )
    }

}
