package ee.mtiidla.jetpacksandbox.codelab.ui.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ee.mtiidla.jetpacksandbox.R
import ee.mtiidla.jetpacksandbox.codelab.Injectable
import ee.mtiidla.jetpacksandbox.codelab.data.Word
import ee.mtiidla.jetpacksandbox.codelab.ui.list.DefaultViewModelFactory
import ee.mtiidla.jetpacksandbox.codelab.ui.log
import kotlinx.android.synthetic.main.fragment_word_detail.*
import javax.inject.Inject


class WordDetailFragment : Fragment(), Injectable {

    private lateinit var viewModel: WordDetailViewModel

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<WordDetailViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[WordDetailViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_word_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        delete_word_button.setOnClickListener { viewModel.onDeleteWordClicked() }

        viewModel.wordDetail.observe(viewLifecycleOwner, Observer { word ->
            log("SINGLE WORD LOADED: $word")
            when (word) {
                null -> closeView()
                else -> renderWord(word)
            }
        })
    }

    private fun closeView() {
        requireActivity().supportFragmentManager.popBackStack()
    }

    fun renderWord(word: Word) {
        word_detail.text = "${word.word}: ${word.letterCount}"
    }

    companion object {

        fun newInstance(arg: WordDetailScreenArg) : Fragment = WordDetailFragment().apply {
            val bundle = Bundle()
            bundle.putParcelable("arg", arg)
            arguments = bundle
        }

    }

}