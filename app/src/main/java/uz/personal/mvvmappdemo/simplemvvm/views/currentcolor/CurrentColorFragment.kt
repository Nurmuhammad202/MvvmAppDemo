package uz.personal.mvvmappdemo.simplemvvm.views.currentcolor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.personal.mvvmappdemo.foundation.views.BaseFragment
import uz.personal.mvvmappdemo.foundation.views.BaseScreen
import uz.personal.mvvmappdemo.foundation.views.screenViewModel
import uz.personal.mvvmappdemo.simplemvvm.views.onTryAgain
import uz.personal.mvvmappdemo.simplemvvm.views.renderSimpleResult
import uz.personal.mvvmappdemo.databinding.FragmentCurrentColorBinding

class CurrentColorFragment : BaseFragment() {

    // no arguments for this screen
    class Screen : BaseScreen

    override val viewModel by screenViewModel<CurrentColorViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentCurrentColorBinding.inflate(inflater, container, false)
        viewModel.currentColor.observe(viewLifecycleOwner) { result ->
            renderSimpleResult(
                root = binding.root,
                result = result,
                onSuccess = {
                    binding.colorView.setBackgroundColor(it.value)
                }
            )
        }

        binding.changeColorButton.setOnClickListener {
            viewModel.changeColor()
        }
        binding.askPermissionsButton.setOnClickListener {
            viewModel.requestPermission()
        }

        onTryAgain(binding.root) {
            viewModel.tryAgain()
        }

        return binding.root
    }


}