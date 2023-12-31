package pl.nanoid.atlasotoskopii.ui.Info

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import pl.nanoid.atlasotoskopii.R

class InfoFragment : Fragment() {

    private lateinit var infoViewModel: InfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        infoViewModel =
            ViewModelProviders.of(this).get(InfoViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_info, container, false)
        val textView: TextView = root.findViewById(R.id.text_info)
        infoViewModel.text.observe(this, Observer {
            textView.text = it
        })

        // mpt - to make scrollable text view:
        val textViewAboutApplication: TextView = root.findViewById(R.id.textAboutApplication)
        textViewAboutApplication.movementMethod = ScrollingMovementMethod.getInstance()

        return root
    }
}