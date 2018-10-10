package ee.mtiidla.jetpacksandbox.codelab.ui.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ee.mtiidla.jetpacksandbox.R
import ee.mtiidla.jetpacksandbox.codelab.Injectable
import ee.mtiidla.jetpacksandbox.codelab.data.Word
import ee.mtiidla.jetpacksandbox.codelab.ui.create.NewWordFragment
import ee.mtiidla.jetpacksandbox.codelab.ui.detail.WordDetailFragment
import ee.mtiidla.jetpacksandbox.codelab.ui.detail.WordDetailScreenArg
import ee.mtiidla.jetpacksandbox.codelab.ui.log
import kotlinx.android.synthetic.main.fragment_word_list.*
import javax.inject.Inject

class WordListFragment : Fragment(), Injectable {

    private lateinit var wordViewModel: WordListViewModel
    private lateinit var wordAdapter: WordListAdapter

    @Inject
    lateinit var viewModelFactory: DefaultViewModelFactory<WordListViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wordViewModel = ViewModelProviders.of(this, viewModelFactory)[WordListViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_word_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        wordAdapter = WordListAdapter(::onWordClicked)
        word_recycler_view.layoutManager = LinearLayoutManager(context)
        word_recycler_view.adapter = wordAdapter

        //IMPORTANT - Use viewLifecycleOwner, see bug https://medium.com/@BladeCoder/architecture-components-pitfalls-part-1-9300dd969808
        wordViewModel.allWords.observe(viewLifecycleOwner, Observer{ words -> words?.let { updateWords(it) } })

        word_add_button.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.content, NewWordFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
        }

        log("VM onViewCreated: $wordViewModel")

    }

    private fun onWordClicked(word: Word) {
        requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.content, WordDetailFragment.newInstance(WordDetailScreenArg(word.word)))
                .addToBackStack(null)
                .commit()
    }

    private fun updateWords(words: List<Word>) {
        log("WORD LIST LOADED")
        wordAdapter.setItems(words)
    }

    companion object {

        fun newInstance(): Fragment = WordListFragment().apply {
            arguments = Bundle.EMPTY
        }
    }
}
