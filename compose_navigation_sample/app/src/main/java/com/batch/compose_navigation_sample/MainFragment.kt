package com.batch.compose_navigation_sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.batch.compose_navigation_sample.ui.theme.ComposenavigationsampleTheme

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ComposenavigationsampleTheme {
                    Surface(color = Color.Green) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(text = "This is Compose on MainFragment")
                            Button(onClick = { replaceFragment(SecondFragment()) }) {
                                Text(text = "Go to SecondFragment")
                            }
                        }
                    }
                }
            }
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val manager = parentFragmentManager
        val transaction = manager.beginTransaction()
        val bundle = Bundle()
        bundle.putSerializable("ARG_KEY", Sample(name = "Android"))
        fragment.arguments = bundle

        transaction.addToBackStack(null)
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}