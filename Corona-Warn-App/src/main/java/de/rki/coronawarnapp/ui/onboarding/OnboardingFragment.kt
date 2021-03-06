package de.rki.coronawarnapp.ui.onboarding

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import de.rki.coronawarnapp.R
import de.rki.coronawarnapp.databinding.FragmentOnboardingBinding
import de.rki.coronawarnapp.ui.doNavigate
import de.rki.coronawarnapp.ui.viewLifecycle

/**
 * Onboarding starting point.
 */
class OnboardingFragment : Fragment() {
    companion object {
        private val TAG: String? = OnboardingFragment::class.simpleName
    }

    private var binding: FragmentOnboardingBinding by viewLifecycle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.onboardingButtonNext.setOnClickListener {
            findNavController().doNavigate(
                OnboardingFragmentDirections.actionOnboardingFragmentToOnboardingPrivacyFragment()
            )
        }
        setLinks()
    }

    private fun setLinks() {
        binding.onboardingInclude.onboardingEasyLanguage
            .setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.onboarding_tracing_easy_language_explanation_url)))
            startActivity(browserIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.onboardingContainer.sendAccessibilityEvent(AccessibilityEvent.TYPE_ANNOUNCEMENT)
    }
}
