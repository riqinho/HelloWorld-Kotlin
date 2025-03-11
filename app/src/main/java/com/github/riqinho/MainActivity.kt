package com.github.riqinho

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.riqinho.ui.theme.HelloworldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Associa a Activity ao layout definido em activity_main.xml
            setContentView(R.layout.activity_main);

            // Referências para os componentes do layout
            val etName = findViewById<EditText>(R.id.etName)
            val tvHelloMessage = findViewById<TextView>(R.id.tvHelloMessage)
            val tvViewMessage = findViewById<TextView>(R.id.textViewHello)

            // Listener para quando o usuário pressiona Enter (actionDone)
            etName.setOnEditorActionListener { textView, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    val name = textView.text.toString().trim()
                    // Verifica se o nome foi digitado
                    if (name.isNotEmpty()) {
                        tvViewMessage.text = "Bem-vindo, $name!"
                    } else {
                        tvViewMessage.text = "Bem-vindo, User!"
                    }
                    true // Indica que consumimos o evento
                } else {
                    false
                }
            }

        }
    }
}