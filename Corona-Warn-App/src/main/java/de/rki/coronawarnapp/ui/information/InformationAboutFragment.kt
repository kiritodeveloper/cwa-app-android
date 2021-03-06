package de.rki.coronawarnapp.ui.information

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent
import androidx.fragment.app.Fragment
import de.rki.coronawarnapp.R
import de.rki.coronawarnapp.databinding.FragmentInformationAboutBinding
import de.rki.coronawarnapp.ui.main.MainActivity
import de.rki.coronawarnapp.ui.viewLifecycle

/**
 * Basic Fragment which only displays static content.
 */
class InformationAboutFragment : Fragment() {
    companion object {
        private val TAG: String? = InformationAboutFragment::class.simpleName
    }

    private var binding: FragmentInformationAboutBinding by viewLifecycle()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationAboutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonOnClickListener()
        setLinks()
    }

    private fun setLinks() {
        binding.informationAboutEasyLanguage
            .setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.onboarding_tracing_easy_language_explanation_url)))
            startActivity(browserIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.informationAboutContainer.sendAccessibilityEvent(AccessibilityEvent.TYPE_ANNOUNCEMENT)
    }

    private fun setButtonOnClickListener() {
        binding.informationAboutHeader.headerButtonBack.buttonIcon.setOnClickListener {
            (activity as MainActivity).goBack()
        }
    }
}
