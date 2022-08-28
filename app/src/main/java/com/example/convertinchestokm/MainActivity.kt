package com.example.convertinchestokm


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import com.example.convertinchestokm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//    либо вот так binding = ActivityMainBinding.inflate(layoutInflater)

    private val list: List<String> = listOf("", "0", "X")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty()) {
                    try {
                        binding.status.text = ""
                        if (binding.editText.isFocused) {
                            binding.editText2.setText(
                                    (s.toString().toFloat() / 39370.0f).toString()
                            )
                            return
                        }
                    } catch (e: Exception) {
                        binding.status.text = "error"
                    }
                } else binding.status.text = "error"
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty()) {
                    try {
                        binding.status.text = ""
                        if (binding.editText2.isFocused) {
                            binding.editText.setText((s.toString().toFloat() * 39370.0f).toString())
                            return
                        }
                    } catch (e: Exception) {
                        binding.status.text = "error"
                    }
                } else binding.status.text = "error"
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

}




