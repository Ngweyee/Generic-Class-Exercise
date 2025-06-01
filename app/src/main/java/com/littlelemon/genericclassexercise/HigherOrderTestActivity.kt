package com.littlelemon.genericclassexercise

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.littlelemon.genericclassexercise.ui.theme.GenericClassExerciseTheme

class HigherOrderTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GenericClassExerciseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SimpleUI(
                        modifier = Modifier.padding(innerPadding), { counts ->
                            Toast.makeText(
                                this,
                                "Button is clicked $counts times",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    )
                }
            }
        }
    }
}

fun disableThenExecute(action: (View) -> Unit): (View) -> Unit {

    return { views ->
        {
            views.isEnabled = false
            action(views)
        }

    }
}


@Composable
fun SimpleUI(modifier: Modifier = Modifier, onClick: (Int) -> Unit) {
    var counts: Int = 0
    Button(onClick = {
        onClick(counts++)
    }, modifier = modifier) {
        Text(text = "Button")

    }

    Button(onClick = {
        disableThenExecute {
            submitForm(it)
        }
    }) {
        Text(text = "Submit")
    }


}

fun submitForm(view: View) {

}


