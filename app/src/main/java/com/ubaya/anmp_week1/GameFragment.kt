package com.ubaya.anmp_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ubaya.anmp_week1.databinding.FragmentGameBinding
import com.ubaya.anmp_week1.databinding.FragmentMainBinding
import java.util.Random

class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private var num1: Int = 0
    private var num2: Int = 0
    private var correctAnswer: Int = 0
    private var score: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    //akses tombol
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Question()
        binding.btnJawab.setOnClickListener{
            checkAnswer()
        }

        if(arguments != null) {
            val name =
                GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$name's Turn"
        }

        binding.btnBack.setOnClickListener{

            val action =  GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
    private fun Question(){
        num1 = kotlin.random.Random.nextInt(1, 101)
        num2 = kotlin.random.Random.nextInt(1, 101)
        correctAnswer = num1 + num2
        binding.txtQuest.text = "$num1 + $num2"
    }
    private fun checkAnswer() {
        val playerAnswer = binding.txtAnswer.text.toString()
        if (playerAnswer.isNotEmpty()) {
            if (playerAnswer.toInt() == correctAnswer) {
                score++
                Question()
            } else {
                endGame()
            }
        }
    }
    private fun endGame() {
        val action = GameFragmentDirections.actionResultFragment(score)
        findNavController().navigate(action)
    }
}