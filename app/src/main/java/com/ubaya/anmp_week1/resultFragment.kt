package com.ubaya.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.anmp_week1.databinding.FragmentGameBinding
import com.ubaya.anmp_week1.databinding.FragmentResultBinding

class resultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }

    //akses tombol
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val score =
                resultFragmentArgs.fromBundle(requireArguments()).score
            binding.txtScore.text = "Your score is $score"
        }


        binding.btnMainScreen.setOnClickListener{
            val action =  resultFragmentDirections.actionMainFragmentResult()
            Navigation.findNavController(it).navigate(action)
        }
    }
}