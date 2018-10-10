package ee.mtiidla.jetpacksandbox.codelab.ui.create

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ee.mtiidla.jetpacksandbox.R
import ee.mtiidla.jetpacksandbox.codelab.Injectable
import ee.mtiidla.jetpacksandbox.codelab.ui.list.DefaultViewModelFactory
import ee.mtiidla.jetpacksandbox.codelab.ui.log
import kotlinx.android.synthetic.main.fragment_new_word.*
import javax.inject.Inject

class NewWordFragment : Fragment(), Injectable {

    private lateinit var viewModel: NewWordViewModel

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<NewWordViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[NewWordViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                             savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_save.setOnClickListener { createWord() }

    }

    private fun createWord() {
        val word = edit_word.text.toString().trim()
        if (word.isNotEmpty()) {
            log("INSERT WORD CALLED: $word")
            viewModel.onAddWordClicked(word)
        }
        view?.postDelayed({ requireActivity().supportFragmentManager.popBackStack() }, 10)
    }

    companion object {

        fun newInstance() : Fragment = NewWordFragment().apply {
            arguments = Bundle.EMPTY
        }

    }
}
